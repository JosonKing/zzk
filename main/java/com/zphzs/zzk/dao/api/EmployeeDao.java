package com.zphzs.zzk.dao.api;

import com.zphzs.zzk.pojo.Employee;

import java.util.List;

/**
 * Created by root5 on 2017/8/23.
 */
public interface EmployeeDao {

    Employee get(int id);

    List<Employee> getList();
}
