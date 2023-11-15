package umc.spring.review.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.reviewcomment.entity.ReviewComment;
import umc.spring.store.entity.Store;
import umc.spring.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;
    private String title;
    private String content;
    private Integer userRating;
    @OneToMany(mappedBy = "review")
    private List<ReviewComment> reviewComments = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Review(String title, String content, List<ReviewComment> reviewComments, User user, Store store) {
        this.title = title;
        this.content = content;
        this.reviewComments = reviewComments;
        this.user = user;
        this.store = store;
    }

    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
