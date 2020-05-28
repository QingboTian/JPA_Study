package cn.tianqb.dao;


import cn.tianqb.pojo.Student;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/27 15:11
 * @Version v1.0
 */
public class ConntionDemo1 {

    @Test
    public void test() {
        // 创建工厂对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
        // 创建实体管理对象
        EntityManager em = factory.createEntityManager();
        // 创建事务对象
        EntityTransaction tx = em.getTransaction();
        // 开启事务
        tx.begin();
        // 执行操作
        Student student = new Student("zhangsan", 1);
        // 添加数据
        em.persist(student);
        // 提交事务
        tx.commit();
        // 关闭流
        em.close();
        factory.close();
    }
}
