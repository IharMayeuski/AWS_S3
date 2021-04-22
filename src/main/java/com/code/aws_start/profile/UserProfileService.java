package com.code.aws_start.profile;

import com.code.aws_start.bucket.BucketName;
import com.code.aws_start.filestore.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;


@Service
public class UserProfileService {

    private  final UserProfileDataAccessService userProfileDataAccessService;
    private  final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(Integer userProfileId, MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
        if (!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_PNG.getMimeType()).contains(file.getContentType())
        ) {
            throw new IllegalStateException("File must be an image");
        }
        //the user exists in our database
        UserProfile user = getUserProfile(userProfileId);
        Map<String, String> metadata = extractMetadata(file);

        //Store to S3
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        String fileName = String.format("%s, %s", file.getName(), UUID.randomUUID());
        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String > metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfile(Integer userProfileId) {
        return userProfileDataAccessService
        .getUserProfiles()
        .stream()
        .filter(profile -> profile.getUserProfileId().equals(userProfileId))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
    }
}
