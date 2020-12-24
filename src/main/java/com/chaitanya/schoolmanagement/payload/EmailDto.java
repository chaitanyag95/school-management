package com.chaitanya.schoolmanagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDto {

    private String to;
    private String from = "chaitanyag95@gmail.com";
    private String subject;
    private String content;
    private String fullName;
    private String password;


    public EmailDto(String to, String subject, String content, String fullName) {
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.fullName = fullName;

    }
}
