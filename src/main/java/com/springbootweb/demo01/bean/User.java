package com.springbootweb.demo01.bean;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class User {
    private String Username;
    private String Password;
}
