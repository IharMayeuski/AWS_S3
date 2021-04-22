package com.code.aws_start.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3 () {
        AWSCredentials awsCredentials = new BasicAWSCredentials(
          "AKIA22SOZLTOI4H6GEV6",
//          "ps3VJ3Hty25dJPn5/suLfI1nSTlyfUWBAQs7u"
          "JN/ps3VJ3Hty25dJPn5/suLfI1nSTlyfUWBAQs7u"

        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
