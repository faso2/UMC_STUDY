package umc.spring.inquiry.entity;

import lombok.*;
import umc.spring.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class InquiryUploadFile extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiryUploadFile_id")
    private Long id;
    private String inquiryOriginalFileName;
    private String inquirySavedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;

    @Builder
    public InquiryUploadFile(String inquiryOriginalFileName, String inquirySavedFileName, Inquiry inquiry) {
        this.inquiryOriginalFileName = inquiryOriginalFileName;
        this.inquirySavedFileName = inquirySavedFileName;
        this.inquiry = inquiry;
    }
}
