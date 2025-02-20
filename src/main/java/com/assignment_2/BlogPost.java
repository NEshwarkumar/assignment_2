package com.assignment_2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Builder
public class BlogPost {

    private String id;
    private String authorId;
    private String postContent;

    private BlogPost(@JsonProperty("id") String id,
                     @JsonProperty("authorId") String authorId,
                     @JsonProperty("postContent") String postContent) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (authorId == null) {
            throw new IllegalArgumentException("Author ID cannot be null");
        }

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return String.format("BlogPost{id='%s', authorId='%s', postContent='%s'}", id, authorId, postContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return id.equals(blogPost.id) && authorId.equals(blogPost.authorId);
    }

    @Override
    public int hashCode() {
        return id.hashCode() + authorId.hashCode();
    }
}
