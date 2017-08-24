package com.zphzs.zzk.controller;

import com.zphzs.zzk.pojo.ExpenseAccount;
import com.zphzs.zzk.service.api.ExpenseAccountService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;



/**
 * Created by root5 on 2017/8/24.
 * 订单CURD
 */
@Controller
@RequestMapping(value = "ecpenseaccount")
public class ExpenseAccountController {
    @Autowired
    ExpenseAccountService expenseAccountService;

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(ExpenseAccountController.class);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String list(HttpServletRequest request){
        JSONObject obj = new JSONObject();
        List<ExpenseAccount> expenseAccountList = null;
        try {
            expenseAccountList = expenseAccountService.getList();
        } catch (Exception e) {
            throw new RuntimeException("程序异常");
        }
        String message = (expenseAccountList == null) ? "查询成功" : "查询失败";
        Integer code = (expenseAccountList == null) ? 0 : 1;
        obj.put("code", code);
        obj.put("data", expenseAccountList);
        obj.put("message", message);
        return obj.toString();
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(HttpServletRequest request) throws ParseException {
        JSONObject obj = new JSONObject();
        String name = request.getParameter("name");
        String type = request.getParameter("type");

        String sTime = request.getParameter("time");
        Timestamp time = new Timestamp(System.currentTimeMillis());
        if(sTime != null) {
            time = Timestamp.valueOf(sTime);
        }

        String desc = request.getParameter("desc");
        String photo = request.getParameter("photo");

        ExpenseAccount expenseAccount = new ExpenseAccount(name, type, time, desc, photo);

        Boolean result = expenseAccountService.add(expenseAccount);

        String message = (result) ? "提交成功" : "提交失败";
        Integer code = (result) ? 0 : 1;
        obj.put("code", code);
        return obj.toString();
    }
}
