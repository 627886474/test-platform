package me.zhengjie.modules.inter.repository;

import me.zhengjie.modules.inter.domain.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: le
 * @Date: 2020/2/18 17:04
 * @Description:
 */
public interface MockRepository extends JpaRepository<Mock,Long>,JpaSpecificationExecutor<Mock> {
    /**
     * 通过mock名查找
     * @param mockName
     * @return
     */
    Mock findByMockName(String mockName);

    /**
     * 通过url查找
     * @param mockUrl
     * @return
     */
    Mock findByMockURL(String mockUrl);
}
