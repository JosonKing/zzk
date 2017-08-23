package com.zphzs.zzk.service.impl;

import com.zphzs.zzk.dao.api.EmployeeDao;
import com.zphzs.zzk.pojo.Employee;
import com.zphzs.zzk.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root5 on 2017/8/23.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getList() {
        return (List<Employee>) employeeDao.getList();
    }
}
