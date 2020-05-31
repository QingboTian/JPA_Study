package cn.tianqb;

import cn.tianqb.dao.CustomerDao;
import cn.tianqb.dao.LinkmanDao;
import cn.tianqb.pojo.Customer;
import cn.tianqb.pojo.Linkman;
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
 * @Date 2020/5/31 20:15
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkmanDao linkmanDao;

    @Test
    @Transactional
    @Rollback(false)
    public void insert1() {
        Customer customer = new Customer();
        customer.setName("京东");
        Linkman linkman1 = new Linkman();
        linkman1.setName("张三");
        Linkman linkman2 = new Linkman();
        linkman2.setName("李四");

        Set<Linkman> linkmen = customer.getLinkmen();
        linkmen.add(linkman1);
        linkmen.add(linkman2);
//        linkman1.setCustomer(customer);
//        linkman2.setCustomer(customer);

        customerDao.save(customer);
        linkmanDao.save(linkmen);
    }

    /**
     * 对象导航查询
     * （一  ->  多）
     * 延迟加载
     */
    @Test
    @Transactional
    public void find() {
        Customer customer = customerDao.findOne(1);
//        System.out.println(customer);
        customer.getLinkmen().forEach(System.out::println);
    }

    /**
     * 对象导航查询
     *（多  ->  一）
     * 立即加载
     */
    @Test
    public void find2() {
        Linkman linkman = linkmanDao.findOne(1);
        System.out.println(linkman);
        System.out.println(linkman.getCustomer());
    }

}
