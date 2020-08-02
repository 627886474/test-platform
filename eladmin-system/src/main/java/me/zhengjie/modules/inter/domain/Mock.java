package me.zhengjie.modules.inter.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: le
 * @Date: 2020/2/18 16:24
 * @Description: mock实体类
 */
@Entity
@Data
@Table(name = "tt_mock")
public class Mock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "mock名称不能为空")
    @Column(unique = true)
    private String mockName;

    @NotBlank(message = "mockURL地址")
    @Column(name = "mock_url",unique = true)
    private String mockURL;

    @NotBlank(message = "mock数据不能为空")
    private String mockData;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
