package com.assignment_2;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Blog {

    private List<BlogPost> posts;
    private List<Person> contributors;

    @Override
    public String toString() {
        return String.format("Blog{posts=%s, contributors=%s}", posts, contributors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return posts.equals(blog.posts) && contributors.equals(blog.contributors);
    }

    @Override
    public int hashCode() {
        return posts.hashCode() + contributors.hashCode();
    }
}