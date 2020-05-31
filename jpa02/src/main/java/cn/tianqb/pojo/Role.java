package cn.tianqb.pojo;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 19:52
 * @Version v1.0
 */
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String roleName;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "user_role", joinColumns = {
            // 当前对象在中间表的外键
            @JoinColumn(name = "rid", referencedColumnName = "id")
    },inverseJoinColumns = {
            // 对方对象在中间表的外键
            @JoinColumn(name = "uid", referencedColumnName = "id")
    })
    private Set<User> users = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }
}
