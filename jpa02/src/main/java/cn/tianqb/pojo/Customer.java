package cn.tianqb.pojo;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description: 一对多
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 19:56
 * @Version v1.0
 */
@Entity
@Table
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String name;

//    @OneToMany(targetEntity = Linkman.class)
//    @JoinColumn(name = "cid", referencedColumnName = "id")
    /**
     * 放弃外键维护
     * mappedBy = "customer"   在Linkman中Customer属性的名称
     */
    @OneToMany(mappedBy = "customer")
    private Set<Linkman> linkmen = new LinkedHashSet<>();

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

    public Set<Linkman> getLinkmen() {
        return linkmen;
    }

    public void setLinkmen(Set<Linkman> linkmen) {
        this.linkmen = linkmen;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
