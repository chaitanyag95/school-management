package com.chaitanya.schoolmanagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NextQuestionPayload {
    private int questionNo;
    private String questionPaperId;
}
