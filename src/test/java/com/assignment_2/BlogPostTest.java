package com.assignment_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void testGetPostsByAuthorAge() {
        Person person1 = Person.builder()
                .id("0930287")
                .firstName("Eshwar")
                .lastName("Noola")
                .age(24)
                .gender("Male")
                .build();

        Person person2 = Person.builder()
                .id("0930288")
                .firstName("Dr")
                .lastName("Dre")
                .age(45)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("101")
                .authorId("0930287")
                .postContent("This is a post by Eshwar.")
                .build();

        BlogPost post2 = BlogPost.builder()
                .id("102")
                .authorId("0930288")
                .postContent("This is a post by Dre.")
                .build();

        BlogPost post3 = BlogPost.builder()
                .id("103")
                .authorId("0930287")
                .postContent("This is another post by Eshwar.")
                .build();

        Blog blog = new Blog();
        blog.setContributors(Arrays.asList(person1, person2));
        blog.setPosts(Arrays.asList(post1, post2, post3));

        List<String> result = blog.getPostsByAuthorAge(24);
        assertEquals(2, result.size());
        assertTrue(result.contains("101"));
        assertTrue(result.contains("103"));
    }

    @Test
    void testGetPostsByAuthorAgeNoMatchingAge() {
        Person person1 = Person.builder()
                .id("0930287")
                .firstName("Eshwar")
                .lastName("Noola")
                .age(25)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("101")
                .authorId("0930287")
                .postContent("This is a post by Eshwar.")
                .build();

        Blog blog = new Blog();
        blog.setContributors(Arrays.asList(person1));
        blog.setPosts(Arrays.asList(post1));

        List<String> result = blog.getPostsByAuthorAge(30);

        assertEquals(0, result.size());
    }


    @Test
    void testGetPostsByAuthorAgeWithMissingAuthor() {
        Person person1 = Person.builder()
                .id("0930287")
                .firstName("Eshwar")
                .lastName("Noola")
                .age(24)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("101")
                .authorId("0930289")
                .postContent("This post has an invalid author.")
                .build();

        Blog blog = new Blog();
        blog.setContributors(Arrays.asList(person1));
        blog.setPosts(Arrays.asList(post1));

        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(0, result.size()); // No posts should be found for the age
    }
}
