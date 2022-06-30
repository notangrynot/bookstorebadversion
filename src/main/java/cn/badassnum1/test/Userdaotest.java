package cn.badassnum1.test;

import cn.badassnum1.dao.Userdao;
import cn.badassnum1.domain.User;
import org.junit.Test;

public class Userdaotest {
    @Test
    public void testLogin() {
        User loginuser = new User();

        loginuser.setUsername("xkl");
        loginuser.setPassword("955000");

        Userdao dao = new Userdao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
