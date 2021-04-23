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
        USER_PROFILES.add(new UserProfile(UUID.fromString("0d683cb4-e47e-4dc1-ad0a-31ee14565683"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("7e7933e5-c05a-41f9-a9eb-55ae97ef0ed0"), "antoniojunior", null));

    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

}
