package com.blogapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;

/** Represents a blog with a list of posts and contributors.*/
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;
}
