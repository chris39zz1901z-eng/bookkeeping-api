package com.bookkeeping.bookkeepingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.io.Serializable;
@Entity //数据库表的映射类
@Table(name = "studenttable") //映射 student 数据库里的 studenttable 表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;//主键

        @Column
        String username;//用户名

        @Column
        String password;//密码

        @Column
        String name;//姓名

        @Column
        Integer age;//年龄


}
