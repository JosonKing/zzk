package com.zphzs.zzk.service.api;

import com.zphzs.zzk.pojo.ExpenseAccount;

import java.util.List;

/**
 * Created by root5 on 2017/8/24.
 */
public interface ExpenseAccountService {
    List<ExpenseAccount> getList();

    Boolean add(ExpenseAccount expenseAccount);
}
