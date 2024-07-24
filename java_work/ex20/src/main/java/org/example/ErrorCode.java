package org.example;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorCode {

    private String message;
    private String code;
    private String desc;

}
