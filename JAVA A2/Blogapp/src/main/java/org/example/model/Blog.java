package com.blogapp.model;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    // Method to get posts by author's age
    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> post.getAuthorId() != null)
                .filter(post -> {
                    // Find the person with the matching authorId and check age
                    return contributors.stream()
                            .anyMatch(contributor -> contributor.getId().equals(post.getAuthorId())
                                    && contributor.getAge().equals(age));
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
