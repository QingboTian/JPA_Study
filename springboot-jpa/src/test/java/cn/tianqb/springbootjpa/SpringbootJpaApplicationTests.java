package cn.tianqb.springbootjpa;

import cn.tianqb.springbootjpa.dao.StudentDao;
import cn.tianqb.springbootjpa.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SpringbootJpaApplication.class})
@RunWith(SpringRunner.class)
public class SpringbootJpaApplicationTests {

    @Autowired
    private StudentDao studentDao;


    @Test
    public void test() {
        Student student = new Student();
        student.setName("张三");
        student.setGender(1);
        studentDao.save(student);
    }

}
