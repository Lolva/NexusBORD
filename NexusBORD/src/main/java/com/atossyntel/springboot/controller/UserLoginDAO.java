
package com.atossyntel.springboot.controller;

import javax.sql.DataSource;


public interface UserLoginDAO {
    public void setDataSource(DataSource ds);
    public boolean checkPassword(UserLogin e);
}
