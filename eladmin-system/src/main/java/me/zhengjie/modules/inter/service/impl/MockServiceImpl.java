package me.zhengjie.modules.inter.service.impl;

import me.zhengjie.exception.EntityExistException;
import me.zhengjie.modules.inter.domain.Mock;
import me.zhengjie.modules.inter.repository.MockRepository;
import me.zhengjie.modules.inter.service.MockService;
import me.zhengjie.modules.inter.service.dto.MockDto;
import me.zhengjie.modules.inter.service.dto.MockQueryCriteria;
import me.zhengjie.modules.inter.service.mapper.MockMapper;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: le
 * @Date: 2020/2/18 19:01
 * @Description:
 */
@Service
public class MockServiceImpl implements MockService {

    @Autowired
    MockMapper mockMapper;

    @Autowired
    MockRepository mockRepository;

    @Override
    public MockDto addMock(Mock mock) {
        String nameExit = mock.getMockName();
        String urlExit = mock.getMockURL();
        if (mockRepository.findByMockName(nameExit)!=null){
            throw new EntityExistException(Mock.class,"mockName",mock.getMockName());
        }
        if (mockRepository.findByMockURL(urlExit)!=null){
            throw new EntityExistException(Mock.class,"mockURL",mock.getMockURL());
        }
        mock.setCreateTime(new Date());
        mock.setUpdateTime(new Date());
        return mockMapper.toDto(mockRepository.save(mock));
    }

    @Override
    public Object queryAll(MockQueryCriteria criteria, Pageable pageable) {
        Page<Mock> page = mockRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(mockMapper::toDto));
    }

    @Override
    public MockDto getMockData(String mockURL) {
        return mockMapper.toDto(mockRepository.findByMockURL(mockURL));
    }


}
