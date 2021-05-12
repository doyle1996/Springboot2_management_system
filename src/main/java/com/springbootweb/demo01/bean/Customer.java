package com.springbootweb.demo01.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Blob;


@Data

@AllArgsConstructor
@NoArgsConstructor
@TableName("test.customers")
public class Customer {
    private long id;
    private String name;
    private String email;
    private Data birth;
    private Blob blob;

    public Customer(Blob blob) {
        this.blob = blob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", blob=" + blob +
                '}';
    }
}
