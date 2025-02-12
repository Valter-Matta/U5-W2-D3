package com.gestione.blogging.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "post")
public class Post {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	private String category;
	private String title;
	private String cover = "https://picsum.photos/200/300";
	private String content;
	private int readTime;

}