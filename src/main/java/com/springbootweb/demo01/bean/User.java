package com.springbootweb.demo01.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class User {




    private String Username;

    private String Password;



}
