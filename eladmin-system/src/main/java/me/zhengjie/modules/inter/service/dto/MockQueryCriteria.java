package me.zhengjie.modules.inter.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @Auther: le
 * @Date: 2020/2/18 19:48
 * @Description: mock可用的查询条件
 */
@Data
public class MockQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(blurry = "mockName,mockURL")
    private String blurry;

    @Query
    private Boolean enabled;

    @Query(propName = "id", joinName = "dept")
    private Long deptId;

    @Query(propName = "id", joinName = "dept", type = Query.Type.IN)
    private Set<Long> deptIds;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
