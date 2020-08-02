package me.zhengjie.modules.inter.service.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: le
 * @Date: 2020/2/18 17:14
 * @Description:
 */
@Data
public class MockDto {

    private Long id;

    private String mockName;

    private String mockURL;

    private String mockData;

    private Date createTime;

}
