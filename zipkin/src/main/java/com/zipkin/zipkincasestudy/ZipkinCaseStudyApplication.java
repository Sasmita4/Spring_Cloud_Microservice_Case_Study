package com.zipkin.zipkincasestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinCaseStudyApplication.class, args);
	}

}

