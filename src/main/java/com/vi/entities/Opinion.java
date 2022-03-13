package com.vi.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opinion_id")
    private long opinionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citation_id")
    private Citation citation;
    @JoinColumn(name = "liked")
    private int liked;
    @JoinColumn(name = "shared")
    private int shared;
}
