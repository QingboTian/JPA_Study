package cn.tianqb.dao;

import cn.tianqb.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description:
 *      JpaRepository : 简单查询
 *      JpaSpecificationExecutor ： 复杂查询
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/28 13:18
 * @Version v1.0
 */
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {


    @Query("from Student order by id desc")
    List<Student> findAllOrderByIdDesc();

    /**
     * 参数位置默认从前往后对应
     * 起始位置1
     * @param name
     * @return
     */
    @Query("from Student where name like ?1")
    List<Student> nameLike(String name);

    @Query("from Student where gender = ?2 and name = ?1")
    List<Student> findByNameAndGender(String name, int gender);

    /**
     * nativeQuery : 是否使用SQL
     * false ： JPQL
     * true ： SQL
     * @param gender
     * @return
     */
    @Query(value = "select * from student where gender = ?", nativeQuery = true)
    List<Student> findByGender(int gender);

    /**
     * 更新操作需要指定Modifying
     * :#{#} 通过对象属性进行赋值
     * @param student
     */
    @Query("update Student set name = :#{#student.name}, gender = :#{#student.gender} where " +
            "id = :#{#student.id}")
    @Modifying
    int updateById(@Param("student") Student student);
}
