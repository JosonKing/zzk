package com.zphzs.zzk.controller;

import com.zphzs.zzk.pojo.Employee;
import com.zphzs.zzk.service.api.EmployeeService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by root5 on 2017/8/23.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String list(HttpServletRequest request){
        List<Employee> employees = employeeService.getList();
        logger.debug("employees:{}", employees);

        JSONObject obj = new JSONObject();
        obj.put("data", employees);
        return obj.toString();
    }

    @RequestMapping(value = "/list1")
//    @ResponseBody
    public ModelAndView list1(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = employeeService.getList();
        logger.debug("employees:{}", employees);

        modelAndView.addObject("employees", employees);
        modelAndView.setViewName("list");
        return modelAndView;
    }


}
