package umc.spring.inquirycomment.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;
import umc.spring.inquiry.entity.Inquiry;
import umc.spring.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
public class InquiryComment extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiryComment_id")
    private Long id;
    private String inquiryContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;

    @Builder
    public InquiryComment(String inquiryContent, User user, Inquiry inquiry) {
        this.inquiryContent = inquiryContent;
        this.user = user;
        this.inquiry = inquiry;
    }

    public static InquiryComment of(String inquiryContent, User user, Inquiry inquiry) {
        InquiryComment inquiryComment = new InquiryComment();
        inquiryComment.setInquiryContent(inquiryContent);
        inquiryComment.setUser(user);
        inquiryComment.setInquiry(inquiry);
        inquiry.getInquiryComments().add(inquiryComment);

        return inquiryComment;
    }

    public void change(String inquiryContent) { this.inquiryContent = inquiryContent; }
}
