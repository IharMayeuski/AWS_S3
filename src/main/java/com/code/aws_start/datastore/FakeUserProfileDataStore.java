package com.code.aws_start.datastore;

import com.code.aws_start.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(111, "janetjones", null));
        USER_PROFILES.add(new UserProfile(222, "antoniojunior", null));

    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

}
