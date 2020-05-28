package cn.tianqb.pojo;

import javax.persistence.*;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/27 14:47
 * @Version v1.0
 */
@Entity// 声明实体类
@Table// 与表建立映射关系
public class Student {

    @Id// 声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 主键自增
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 序列化  如Oracle
//    @GeneratedValue(strategy = GenerationType.TABLE) // 另外创建一个表去维持主键
//    @GeneratedValue(strategy = GenerationType.AUTO) // 根据具体情况自动选择主键策略
    private Integer id;

    @Column(length = 20, name = "name") // 配置列的属性
    private String name;

    private Integer gender;

    public Student(String name, Integer gender) {
        this.name = name;
        this.gender = gender;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
