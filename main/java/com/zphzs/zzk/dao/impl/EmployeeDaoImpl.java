package com.zphzs.zzk.dao.impl;

import com.zphzs.zzk.dao.api.EmployeeDao;
import com.zphzs.zzk.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root5 on 2017/8/23.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee get(int id) {
        String sql="SELECT id, lastName,email FROM employee WHERE id=?";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
        Employee employee=jdbcTemplate.queryForObject(sql, rowMapper,id);

        return employee;
    }

    @Override
    public List<Employee> getList() {
        String sql="SELECT id, lastName,email FROM employee";
        RowMapper<Employee> rowMapper= ParameterizedBeanPropertyRowMapper
                .newInstance(Employee.class);
        List<Employee> employees = (List<Employee>) jdbcTemplate.query(sql, rowMapper);

        System.out.println("*************************employeeDao employees:" + employees);
        logger.debug("employeeDao employees:{}", employees);

        return (List<Employee>) employees;
    }


}
