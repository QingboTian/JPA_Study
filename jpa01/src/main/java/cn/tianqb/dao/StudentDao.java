package cn.tianqb.dao;

import cn.tianqb.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/27 15:40
 * @Version v1.0
 */
public class StudentDao {

    private EntityManager em;
    private EntityTransaction tx;
    private EntityManagerFactory factory;

    @Before
    public void init() {
        // arg0 : 持久化单元名称
        factory = Persistence.createEntityManagerFactory("myjpa");
        em = factory.createEntityManager();
        tx = em.getTransaction();
    }

    /**
     * 添加
     */
    @Test
    public void perssit() {
        tx.begin();

        Student student = new Student("lisi", 0);
        em.persist(student);

        tx.commit();
    }

    /**
     * 查询（非延迟）
     */
    @Test
    public void find() {
        tx.begin();

        Student student = em.find(Student.class, 1);
        System.out.println(student);

        tx.commit();
    }

    /**
     * 查询（延迟加载）
     * 什么时候用到了对象，再进行sql的执行
     */
    @Test
    public void getReference() {
        tx.begin();

        Student student = em.getReference(Student.class, 1);
        System.out.println(student);

        tx.commit();
    }

    /**
     * 修改数据
     */
    @Test
    public void merge() {
        tx.begin();

        Student student = em.getReference(Student.class, 1);
        student.setName("tianqb");
        em.merge(student);

        tx.commit();
    }

    /**
     * 删除数据
     */
    @Test
    public void remove() {
        tx.begin();

        Student student = em.getReference(Student.class, 2);
        em.remove(student);
        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     */
    @Test
    public void jpqlFind1() {
        tx.begin();

        String jpql = "from Student";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        list.forEach(System.out::println);

        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     * 查询指定属性
     */
    @Test
    public void jpqlFind2() {
        tx.begin();

        String jpql = "select name from Student";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        list.forEach(System.out::println);

        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     * 倒序
     */
    @Test
    public void jpqlOrder() {
        tx.begin();

        String jpql = "from Student order by id desc";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        list.forEach(System.out::println);

        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     * 统计
     */
    @Test
    public void jpqlCount() {
        tx.begin();

        String jpql = "select count(id) from Student";
        Query query = em.createQuery(jpql);
        Object obj = query.getSingleResult();
        System.out.println(obj);

        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     * 统计
     */
    @Test
    public void jpqlPage() {
        tx.begin();

        String jpql = "from Student";
        Query query = em.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(3);
        List list = query.getResultList();
        list.forEach(System.out::println);

        tx.commit();
    }

    /**
     * 使用JPQL（JPA Query Language）进行查询
     * 条件查询
     */
    @Test
    public void jpqlCondition() {
        tx.begin();

        String jpql = "from Student where name like ?";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "%s%");
        List list = query.getResultList();
        list.forEach(System.out::println);

        tx.commit();
    }

    @After
    public void after() {
        em.close();
        factory.close();
    }

}
