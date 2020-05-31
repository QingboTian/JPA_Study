package cn.tianqb.dao;

import cn.tianqb.pojo.Linkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Author tianqb
 * @Mail tianqingbo@tianqb.cn
 * @Date 2020/5/31 20:13
 * @Version v1.0
 */
public interface LinkmanDao extends JpaRepository<Linkman, Integer>, JpaSpecificationExecutor<Linkman> {

}
