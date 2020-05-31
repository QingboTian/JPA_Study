package cn.tianqb.springbootjpa.dao;

import cn.tianqb.springbootjpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 22:05
 * @Version v1.0
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

}
