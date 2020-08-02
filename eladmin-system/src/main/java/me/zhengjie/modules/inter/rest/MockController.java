package me.zhengjie.modules.inter.rest;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.aop.log.Log;
import me.zhengjie.config.DataScope;
import me.zhengjie.modules.inter.domain.Mock;
import me.zhengjie.modules.inter.service.MockService;
import me.zhengjie.modules.inter.service.dto.MockDto;
import me.zhengjie.modules.inter.service.dto.MockQueryCriteria;
import me.zhengjie.modules.system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @Auther: le
 * @Date: 2020/2/18 19:18
 * @Description:
 */
@Api(tags = "mock数据：mock管理")
@RestController
@RequestMapping("/api/inter/mock")
public class MockController {

    @Autowired
    MockService mockService;

    private final DataScope dataScope;


    public MockController(MockService mockService, DataScope dataScope) {
        this.mockService = mockService;
        this.dataScope = dataScope;
    }

    @Log("查询mock数据")
    @ApiOperation("查询mock数据")
    @GetMapping(value = "/list")
    @PreAuthorize("@el.check('mock:list')")
    public ResponseEntity<Object> list(MockQueryCriteria criteria, Pageable pageable){
        criteria.setDeptIds(dataScope.getDeptIds());
        return new ResponseEntity<>(mockService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增mock数据")
    @ApiOperation("新增mock数据")
    @PostMapping(value = "/add")
    @PreAuthorize("@el.check('mock:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Mock resources){
        return new ResponseEntity<>(mockService.addMock(resources),HttpStatus.CREATED);
    }

    @Log("访问mock数据")
    @ApiOperation("访问mock数据")
    @AnonymousAccess
    @GetMapping("/{mockURL}")
    public ResponseEntity<Object> getMockData(@PathVariable("mockURL")String mockURL){
        MockDto mockDto = mockService.getMockData(mockURL);
        String mockData = mockDto.getMockData();
        return new ResponseEntity<>(JSONObject.parseObject(mockData),HttpStatus.OK);
    }


}
