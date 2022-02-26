package com.vi.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "like", schema = "aware_schema", catalog = "aware")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private long likeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citation_id")
    private Citation citation;
    @JoinColumn(name = "is_like")
    private boolean isLike;
    @JoinColumn(name = "is_shared")
    private boolean isShared;
}
