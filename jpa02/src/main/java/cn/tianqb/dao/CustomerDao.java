package cn.tianqb.dao;

import cn.tianqb.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 20:13
 * @Version v1.0
 */
public interface CustomerDao extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

}
