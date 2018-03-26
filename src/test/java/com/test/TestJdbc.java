/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jdbc/dataSource-test.xml"})
public class TestJdbc {
        private static Log logger = LogFactory.getLog(TestJdbc.class);
        
        @Autowired
        private JdbcTemplate jdbcTemplate; //new JdbcTemplate
        
        @Test
        public void TestJdbc(){
           long numero= jdbcTemplate.queryForObject("select count(*) from persona", Long.class);
            logger.info("numero de perfsonas:-->"+numero);
        }

    
}
