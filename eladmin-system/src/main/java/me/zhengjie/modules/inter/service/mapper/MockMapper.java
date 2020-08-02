package me.zhengjie.modules.inter.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.inter.domain.Mock;
import me.zhengjie.modules.inter.service.dto.MockDto;
import org.mapstruct.Mapper;


/**
 * @Auther: le
 * @Date: 2020/2/18 19:07
 * @Description:
 */
@Mapper(componentModel = "spring")
public interface MockMapper extends BaseMapper<MockDto, Mock> {

    @Override
    MockDto toDto(Mock mock);
}
