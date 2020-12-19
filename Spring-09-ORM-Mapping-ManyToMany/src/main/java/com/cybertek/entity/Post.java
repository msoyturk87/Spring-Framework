package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="post_tag_rel",
            joinColumns = {@JoinColumn(name="post_id")},inverseJoinColumns ={@JoinColumn(name ="tag_id")})
    private Set<Tag> tags = new HashSet<>();
    // To increase performance and to do it professionaly we can use SET. But List is working too



    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
