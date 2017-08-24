package com.zphzs.zzk.dao.impl;

import com.zphzs.zzk.dao.api.ExpenseAccountDao;
import com.zphzs.zzk.pojo.ExpenseAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by root5 on 2017/8/24.
 */
@Repository
public class ExpenseAccountDaoImpl implements ExpenseAccountDao {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseAccountDaoImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ExpenseAccount> getList() {
        String sql="SELECT id, name, type, time, desc, photo FROM zzk_expense_account";
        logger.debug("ExpenseAccountDaoImpl.getList:{}", sql);
        RowMapper<ExpenseAccount> rowMapper= ParameterizedBeanPropertyRowMapper
                .newInstance(ExpenseAccount.class);
        List<ExpenseAccount> expenseAccountList = jdbcTemplate.query(sql, rowMapper);
        return expenseAccountList;
    }

    @Override
    public Boolean add(final ExpenseAccount expenseAccount) {
        try {
            String sql = new String("insert into zzk_expense_account (name, type, time, desc, photo) values(?,?,?,?,?)");
            int affectLines=0;
            affectLines = jdbcTemplate.update(sql, new PreparedStatementSetter() {

                @Override
                public void setValues(java.sql.PreparedStatement pstmt)
                        throws SQLException {
                    pstmt.setObject(1, expenseAccount.getName());
                    pstmt.setObject(2, expenseAccount.getType());
                    pstmt.setObject(3, expenseAccount.getTime());
                    pstmt.setObject(4, expenseAccount.getDesc());
                    pstmt.setObject(5, expenseAccount.getPhoto());
                }});
            System.out.println("affectLines:" + affectLines);
            if(affectLines > 0 ){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return false;
    }
}
