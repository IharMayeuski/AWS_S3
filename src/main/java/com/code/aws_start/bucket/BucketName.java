package com.code.aws_start.bucket;

public enum BucketName {
    PROFILE_IMAGE("amigoscode-image-upload-my-123");

    private final String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }


}
