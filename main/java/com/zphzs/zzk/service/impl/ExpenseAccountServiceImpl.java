package com.zphzs.zzk.service.impl;

import com.zphzs.zzk.dao.api.ExpenseAccountDao;
import com.zphzs.zzk.pojo.ExpenseAccount;
import com.zphzs.zzk.service.api.ExpenseAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root5 on 2017/8/24.
 */
@Service
public class ExpenseAccountServiceImpl implements ExpenseAccountService {

    @Autowired
    ExpenseAccountDao expenseAccountDao;

    @Override
    public List<ExpenseAccount> getList() {
        return expenseAccountDao.getList();
    }

    @Override
    public Boolean add(ExpenseAccount expenseAccount) {
        return expenseAccountDao.add(expenseAccount);
    }
}
