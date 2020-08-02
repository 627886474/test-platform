package me.zhengjie.modules.inter.service;

import me.zhengjie.modules.inter.domain.Mock;
import me.zhengjie.modules.inter.service.dto.MockDto;
import me.zhengjie.modules.inter.service.dto.MockQueryCriteria;
import me.zhengjie.modules.system.service.dto.UserQueryCriteria;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: le
 * @Date: 2020/2/18 17:11
 * @Description:
 */
public interface MockService {
    /**
     * 添加mock数据
     * @param mock
     * @return
     */
    MockDto addMock(Mock mock);

    /**
     * 查询全部
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Object queryAll(MockQueryCriteria criteria, Pageable pageable);

    /**
     * 获取mock数据
     * @param mockURL
     * @return
     */
    MockDto getMockData(String mockURL);
}
