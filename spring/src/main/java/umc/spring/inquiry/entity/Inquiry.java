package umc.spring.inquiry.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.inquirycomment.entity.InquiryComment;
import umc.spring.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Inquiry extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Long id;
    private String inquiryTitle;
    private String inquiryContent;

    @OneToMany(mappedBy = "inquiry")
    private List<InquiryComment> inquiryComments = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Inquiry(String inquiryTitle, String inquiryContent, List<InquiryComment> inquiryComments, User user) {
        this.inquiryTitle = inquiryContent;
        this.inquiryContent = inquiryContent;
        this.inquiryComments = inquiryComments;
        this.user = user;
    }

    public void change(String inquiryTitle, String inquiryContent) {
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
    }
}
