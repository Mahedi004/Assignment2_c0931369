package com.blogapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.jackson.Jacksonized;

/** Represents a blog post with an ID, author ID, and content.*/
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    @JsonCreator
    public BlogPost(@JsonProperty("id") String id,
                    @JsonProperty("authorId") String authorId,
                    @JsonProperty("postContent") String postContent) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Post ID cannot be null or blank.");
        if (authorId == null || authorId.isBlank()) throw new IllegalArgumentException("Author ID cannot be null or blank.");
        if (postContent == null || postContent.isBlank()) throw new IllegalArgumentException("Post content cannot be null or blank.");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}
