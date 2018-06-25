package org.xiafei.spring.cloud.nosql.datasource.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiafei.spring.cloud.nosql.datasource.mybatis.EmployeeMapper;

/**
 * @author 夏飞
 */
@RestController
public class ShowController {


    private final EmployeeMapper employeeMapper;

    private final MongoTemplate mongoTemplate;

    private final RedisConnection redisConnection;

    public ShowController(EmployeeMapper employeeMapper, MongoTemplate mongoTemplate, JedisConnectionFactory jedisConnectionFactory) {
        this.employeeMapper = employeeMapper;
        this.mongoTemplate = mongoTemplate;
        this.redisConnection=jedisConnectionFactory.getConnection();
    }

    @RequestMapping("/mybatis")
    public Object mybatis(){
        return employeeMapper.selectAll();
    }

    @RequestMapping("/mongodb")
    public Object mongodb(){
        return mongoTemplate.getCollectionNames();
    }

    @RequestMapping("/redis")
    public Object redis(){
        redisConnection.set("name".getBytes(), "xiafei".getBytes());
        return new String(redisConnection.get("name".getBytes()));
    }

}
