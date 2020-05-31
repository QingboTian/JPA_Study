package cn.tianqb.pojo;

import javax.persistence.*;

/**
 * @Description: 多对一
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 19:56
 * @Version v1.0
 */
@Entity
@Table
public class Linkman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String name;

    /**
     * ManyToOne属性设置
     * cascade = CascadeType.ALL ： 全部操作采用级联
     * fetch = FetchType.EAGER : 立即加载
     * fetch = FetchType.LAZY : 延迟加载
     */
    @ManyToOne(targetEntity = Customer.class)
    /**
     * name = "cid",外键名称
     * referencedColumnName = "id" ： 外键引用对象的主键名称，这里指的就是Customer主键名称
     */
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Linkman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
