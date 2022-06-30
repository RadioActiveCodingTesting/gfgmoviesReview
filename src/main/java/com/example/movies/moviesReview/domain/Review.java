package com.example.movies.moviesReview.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="review_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long reviewId;

    private String movieReview;

    private double rating;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    private Movie movie;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;



}
