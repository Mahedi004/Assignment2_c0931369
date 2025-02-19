package com.blogapp;

import com.blogapp.model.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BlogPost class.
 */
class BlogPostTest {

    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("B001")
                .authorId("C0931")
                .postContent("This is a test blog post.")
                .build();
        assertNotNull(post);
    }

    @Test
    void testInvalidBlogPostCreation_NullAuthorID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BlogPost.builder().id("B002").authorId(null).postContent("Invalid post").build());
        assertEquals("Author ID cannot be null or blank.", exception.getMessage());
    }
}
