package cn.tianqb;

import cn.tianqb.dao.StudentDao;
import cn.tianqb.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/30 15:17
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentJpaSpecificationExecutorTest {

    @Autowired
    private StudentDao studentDao;


    /**
     * 单个对象的查询
     */
    @Test
    public void findOne1() {
        Student student = studentDao.findOne(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> id = root.get("id");
                Predicate equal = criteriaBuilder.equal(id, 1);
                return equal;
            }
        });
        System.out.println(student);
    }

    /**
     * 多条件拼接查询1
     */
    @Test
    public void findOne2() {
        Student student = studentDao.findOne(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Path<Object> gender = root.get("gender");
                criteriaBuilder.equal(name, "tianqingbo");
                Predicate and = criteriaBuilder.and(criteriaBuilder.equal(name, "tianqingbo"), criteriaBuilder.equal(gender
                        , 1));
                return and;
            }
        });
        System.out.println(student);
    }

    /**
     * 模糊查询
     * like，gt，lt，ge，le需要通过as方法指定参数的类型
     */
    @Test
    public void like1() {
        List<Student> students = studentDao.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                return criteriaBuilder.like(name.as(String.class), "%g%");
            }
        });
        students.forEach(System.out::println);
    }

    /**
     * 主键逆序
     *
     */
    @Test
    public void sort1() {
        List<Student> students = studentDao.findAll(new Sort(Sort.Direction.DESC, "id"));
        students.forEach(System.out::println);
    }

    /**
     * 分页
     *
     */
    @Test
    public void page() {
        Page<Student> page = studentDao.findAll(new PageRequest(0, 3));
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前数据：");
        page.getContent().forEach(System.out::println);
        System.out.println("是否第一页：" + page.isFirst());
        System.out.println("是否最后一页：" + page.isLast());
    }

}
