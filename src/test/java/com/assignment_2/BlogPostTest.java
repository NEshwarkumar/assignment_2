package com.assignment_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {

    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("1")
                .authorId("0930287")
                .postContent("This is a test blog post for the assignment.")
                .build();
        assertNotNull(post);
        assertEquals("This is a test blog post for the assignment.", post.getPostContent());
    }

    @Test
    void testInvalidBlogPostCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .authorId("0930287")
                .postContent("This is a test blog post for the assignment.")
                .build());
    }

    @Test
    void testInvalidBlogPostCreationWithNullAuthorId() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id("1")
                .postContent("This is a test blog post for the assignment.")
                .build());
    }
}