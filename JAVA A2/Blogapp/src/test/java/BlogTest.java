package com.blogapp.test;

import com.blogapp.model.Blog;
import com.blogapp.model.BlogPost;
import com.blogapp.model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BlogTest {

    @Test
    public void testGetPostsByAuthorAge() {
        // Create sample persons
        Person person1 = Person.builder().id("1").firstName("Mahedi").lastName("Sunasara").age(25).gender("Male").build();
        Person person2 = Person.builder().id("2").firstName("Tasnim").lastName("Ali").age(25).gender("Female").build();

        // Create sample blog posts
        BlogPost post1 = BlogPost.builder().id("101").authorId("1").postContent("Post by Mahedi").build();
        BlogPost post2 = BlogPost.builder().id("102").authorId("2").postContent("Post by Tasnim").build();

        // Create Blog
        Blog blog = Blog.builder()
                .posts(Arrays.asList(post1, post2))
                .contributors(Arrays.asList(person1, person2))
                .build();

        // Call method to get posts by author's age
        List<String> result = blog.getPostsByAuthorAge(25);
        assertEquals(1, result.size());
        assertTrue(result.contains("101")); //
    }

