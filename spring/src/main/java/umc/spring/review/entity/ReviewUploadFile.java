package umc.spring.review.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class ReviewUploadFile extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewUploadFile_id")
    private Long id;
    private String originalFileName;
    private String savedFileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Builder
    public ReviewUploadFile(String originalFileName, String savedFileName, Review review) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.review = review;
    }
}
