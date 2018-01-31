package com.example.order.base;

import com.example.order.OrderApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 基础测试类
 *
 * @author stylefeng
 * @Date 2017/5/21 16:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
@WebAppConfiguration
//@Transactional //测试之后数据可回滚
public class BaseJunit {

}
