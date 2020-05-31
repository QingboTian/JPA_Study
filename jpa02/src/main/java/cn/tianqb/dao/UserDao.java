package cn.tianqb.dao;

import cn.tianqb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 21:03
 * @Version v1.0
 */
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
