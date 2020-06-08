package com.danchel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Dc Lee
 * @Description:
 * @Date: 11:26 2020/6/8
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 学校
     */
    private String school;
}
