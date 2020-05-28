package cn.tianqb;

import cn.tianqb.dao.StudentDao;
import cn.tianqb.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/28 13:20
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentTest {

    @Autowired
    private StudentDao studentDao;

    /**
     * 根据主键查询
     * 立即加载
     */
    @Test
    public void findOne() {
        Student student = studentDao.findOne(1);
        System.out.println(student);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<Student> students = studentDao.findAll();
        students.forEach(System.out::println);
    }

    /**
     * 添加数据
     */
    @Test
    public void insert() {
        // 主键没有值，则是添加数据
        Student student = new Student("王五", 1);
        studentDao.save(student);
    }

    /**
     * 更新数据
     */
    @Test
    public void update() {
        Student student = studentDao.findOne(1);
        student.setName("tianqingbo");
        studentDao.save(student);
    }

    /**
     * 根据主键删除数据
     */
    @Test
    public void delete() {
        studentDao.delete(4);
    }

    /**
     * 查看数据条数
     */
    @Test
    public void count() {
        long count = studentDao.count();
        System.out.println(count);
    }

    /**
     * 查看指定数据是否存在
     */
    @Test
    public void exist() {
        boolean exists = studentDao.exists(1);
        System.out.println(exists);
    }

    /**
     * 延迟加载
     * 若查询的数据不存在则直接抛出异常
     *
     */
    @Test
    @Transactional
    public void getOne() {
        Student student = studentDao.getOne(1);
        System.out.println(student);
    }

    /**
     * 通过JPQL查询
     * 自定义查询
     */
    @Test
    public void findAllOrderByIdDesc() {
        List<Student> list = studentDao.findAllOrderByIdDesc();
        list.forEach(System.out::println);
    }

    /**
     * JPQL
     * 根据姓名模糊查询
     */
    @Test
    public void nameLike() {
        List<Student> list = studentDao.nameLike("%t%");
        list.forEach(System.out::println);
    }

    /**
     * JPQL
     * 多参数匹配
     */
    @Test
    public void findByNameAndGender() {
        List<Student> list = studentDao.findByNameAndGender("tianqingbo", 1);
        list.forEach(System.out::println);
    }

    /**
     * JPQL
     * 根据ID去更新数据
     * 此方法仅用于测试
     * JPA事务默认回滚
     */
    @Test
    @Transactional
    @Rollback(false)
    public void updateById() {
        Student student = studentDao.findOne(3);
        student.setName("张三");
        studentDao.updateById(student);
    }

    /**
     * SQL
     *
     */
    @Test
    public void findByGender() {
        List<Student> list = studentDao.findByGender(1);
        list.forEach(System.out::println);
    }

    /**
     * 方法命名规则查询
     * 普通查询
     */
    @Test
    public void findByName() {
        List<Student> list = studentDao.findByName("tianqingbo");
        list.forEach(System.out::println);
    }

    /**
     * 方法命名规则查询
     * 模糊查询
     */
    @Test
    public void findByNameLike() {
        List<Student> list = studentDao.findByNameLike("%t%");
        list.forEach(System.out::println);
    }

    /**
     * 方法命名规则查询
     * 多条件查询
     */
    @Test
    public void findByNameLikeAndGender() {
        List<Student> list = studentDao.findByNameLikeAndGender("%t%", 1);
        list.forEach(System.out::println);
    }
}
