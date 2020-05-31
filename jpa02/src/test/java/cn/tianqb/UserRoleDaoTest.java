package cn.tianqb;

import cn.tianqb.dao.RoleDao;
import cn.tianqb.dao.UserDao;
import cn.tianqb.pojo.Role;
import cn.tianqb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 21:02
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserRoleDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;


    @Test
    @Transactional
    @Rollback(false)
    public void insert() {
        Role role = new Role();
        role.setRoleName("管理员");
        Set<User> users = role.getUsers();
        User user = new User();
        user.setUsername("张三");
        users.add(user);
        userDao.save(user);
        roleDao.save(role);
    }
}
