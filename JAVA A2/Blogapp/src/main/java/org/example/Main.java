package com.blogapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.blogapp.model.Blog;
import com.blogapp.model.BlogPost;
import com.blogapp.model.Person;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON files and parse them into lists
            List<Person> persons = objectMapper.readValue(new File("person.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            List<BlogPost> blogPosts = objectMapper.readValue(new File("blogPosts.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, BlogPost.class));

            // Create Blog instance
            Blog blog = Blog.builder()
                    .posts(blogPosts)
                    .contributors(persons)
                    .build();

            // Call the getPostsByAuthorAge method and print result
            Integer ageToSearch = 25; // Example age
            List<String> postsByAuthorAge = blog.getPostsByAuthorAge(ageToSearch);
            System.out.println("Posts by authors with age " + ageToSearch + ": " + postsByAuthorAge);

            // Print number of blog post and contributor
            System.out.println("Total Blog Posts: " + blogPosts.size());
            System.out.println("Total Contributors: " + persons.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
