package com.flare.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//创建驱动器
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sell?characterEncoding=utf-8&useSSL=false", "root", "root");//这是数据库的路径，并且还有输入账号（一般默认是root），密码之前创建用户时的那个
            con = DriverManager.getConnection("jdbc:mysql://47.99.106.79:3306/sell?characterEncoding=utf-8&useSSL=false",
                    "root", "root");//这是数据库的路径，并且还有输入账号（一般默认是root），密码之前创建用户时的那个
            pst = con.prepareCall("select * from product_category");//输入的是要在MySQL中执行的代码
            rs = pst.executeQuery();//获得执行上面代码后的结果集
            while (rs.next()) {
                System.out.print(rs.getString(1));//我创建的表有五个属性，所以会有五个输出，然后跳行
                System.out.print(rs.getString(2));
                System.out.print(rs.getString(3));
                System.out.print(rs.getString(4) + "  ");
                System.out.println(rs.getString(5));
            }//最后还有关闭连接
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            con.close();
        }
    }
}

