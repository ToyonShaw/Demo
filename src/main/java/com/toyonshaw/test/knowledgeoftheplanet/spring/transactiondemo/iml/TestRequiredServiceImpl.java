package com.toyonshaw.test.knowledgeoftheplanet.spring.transactiondemo.iml;

import com.toyonshaw.test.knowledgeoftheplanet.spring.transactiondemo.TestRequireNewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @author toyon
 * @since 2022/9/23
 */
@Slf4j
@Service
public class TestRequiredServiceImpl implements TestRequireNewService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    @Lazy
    private TestRequireNewService requireNewService;

//    @PostConstruct
//    public void init() {
//        log.info("------------ init -------------");
//        requireNewService.test();
//    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void test() {
        String statementSql = "insert into test_user(name,create_time)values(?,?)";
        int id = jdbcTemplate.update(statementSql, "张三", new Date());
        log.info("------------ test new id :{}", id);
        try {
            this.test2();
        } catch (Exception e) {
            log.error("---------- test error ---------", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void test2() {
        String statementSql = "insert into test_user(name,create_time)values(?,?)";
        int id = jdbcTemplate.update(statementSql, "李四",new Date());
        log.info("------------ test2 new id :{}", id);
        throw new NullPointerException();
    }


}
