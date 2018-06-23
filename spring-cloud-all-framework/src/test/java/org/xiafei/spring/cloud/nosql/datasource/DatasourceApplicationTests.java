package org.xiafei.spring.cloud.nosql.datasource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiafei.spring.cloud.nosql.datasource.mybatis.EmployeeMapper;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class DatasourceApplicationTests {
    @Resource
    private
    EmployeeMapper employeeMapper;

    @Resource
    private
    MongoTemplate mongoTemplate;

    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    private RedisConnection redisConnection;

    @Before
    public void init() {
        redisConnection = jedisConnectionFactory.getConnection();
    }


    @Test
    public void testRedis() {
        redisConnection.set("name".getBytes(), "xiafei".getBytes());
        String value = new String(redisConnection.get("name".getBytes()));
        System.out.println(value);
        Assert.assertEquals("xiafei", value);
    }

    @Test
    public void testMybatis() {
        System.out.println(employeeMapper.selectAll().size());
    }

    @Test
    public void testMongo() {
        for (String collectionName : mongoTemplate.getCollectionNames()) {
            System.out.println(collectionName);
        }
    }

    @Test
    public void contextLoads() {

    }


}
