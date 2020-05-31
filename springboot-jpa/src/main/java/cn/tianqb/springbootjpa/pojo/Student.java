package cn.tianqb.springbootjpa.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 22:02
 * @Version v1.0
 */
@Entity
@Table(name = "student_test_table")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String name;

    private Integer gender;

}
