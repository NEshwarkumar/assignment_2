package com.assignment_2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class Blog {

    private List<BlogPost> posts;
    private List<Person> contributors;

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> contributors.stream()
                        .filter(person -> person.getAge().equals(age))
                        .anyMatch(person -> person.getId().equals(post.getAuthorId())))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }


    private Person findAuthorById(String authorId) {
        return contributors.stream()
                .filter(person -> Objects.equals(person.getId(), authorId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return String.format("Blog{posts=%s, contributors=%s}", posts, contributors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(posts, blog.posts) && Objects.equals(contributors, blog.contributors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts, contributors);
    }
}
