package com.assignment_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> people = objectMapper.readValue(new File("person.json"), new TypeReference<List<Person>>() {});
            List<BlogPost> blogPosts = objectMapper.readValue(new File("blogPosts.json"), new TypeReference<List<BlogPost>>() {});

            Blog blog = new Blog();
            blog.setPosts(blogPosts);
            blog.setContributors(people);

            List<String> postsByAge = blog.getPostsByAuthorAge(24);
            System.out.println("Posts by authors aged 24: " + postsByAge);

            System.out.println("Total Blog Posts: " + blog.getPosts().size());
            System.out.println("Total Contributors: " + blog.getContributors().size());

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
