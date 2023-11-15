package umc.spring.reviewcomment.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.review.entity.Review;
import umc.spring.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
public class ReviewComment extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewComment_id")
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Builder
    public ReviewComment(String content, User user, Review review) {
        this.content = content;
        this.user = user;
        this.review = review;
    }

    public static ReviewComment of(String content, User user, Review review) {
        ReviewComment reviewComment = new ReviewComment();
        reviewComment.setContent(content);
        reviewComment.setUser(user);
        reviewComment.setReview(review);
        review.getReviewComments().add(reviewComment);

        return reviewComment;
    }

    public void change(String content) { this.content = content; }
}
