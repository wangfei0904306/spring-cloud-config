package com.example.order;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 档口报货单 前端控制器
 * </p>
 *
 * @author fei
 * @since 2017-11-07
 */
@Api(description = "配置中心监控接口")
@RestController
@RefreshScope
@RequestMapping("/order")
public class ConfigActuatorController {

    @Value("${config.center.test}")
    private String testStr;

    @ApiOperation("配置中心测试值：config.center.test")
    @GetMapping("/test")
    public String test() {
        return testStr;
    }


}
