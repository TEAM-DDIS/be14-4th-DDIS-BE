// (조회용) DB에서 가져올 컬럼들 담을 응답용 객체 작성
package com.DDIS.post.Query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminPostDTO {
    private Long postNum;                  // 게시글 번호
    private String postTitle;               // 제목
    private String postContent;             // 내용
    private String recruitmentStartDate;    // 모집 시작일
    private String recruitmentEndDate;      // 모집 마감일
    private int activityTime;               // 활동 기간 (7,14,21,30일 중)
    private int recruitmentLimit;           // 모집 인원
    private Integer applicantCount;         // 현재 신청 인원 (nullable)
    private Boolean isPublic;               // 공개 여부
    private String password;                // 비공개 비밀번호
    private Boolean isClosed;               // 모집 마감 여부

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;       // 작성일

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime updatedDate;       // 수정일

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime deleteDate;        // 삭제일 (soft delete)

    private String categoryName;             // 카테고리명
    private String clientName;               // 작성자 이름
}