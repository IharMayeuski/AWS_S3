package com.code.aws_start.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private final UUID userProfileId;
    private final String userName;
    private String userProfileImageLink; //s3 key

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, userName, userProfileImageLink);
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }


    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public UserProfile(UUID userProfileId, String userName, String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.userName = userName;
        this.userProfileImageLink = userProfileImageLink;
    }
}
