package com.hukangjin.dao;

import com.hukangjin.model.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into hkj values(?,?,?,?,?,?) ";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,user.getId());
        pre.setString(2,user.getUsername());
        pre.setString(3,user.getPassword());
        pre.setString(4,user.getEmail());
        pre.setString(5,user.getGender());
        pre.setDate(6, (java.sql.Date) user.getBirthDate());
        pre.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete * from hkj where id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,user.getId());
        return pre.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "insert into hkj values(?,?,?,?,?,?) ";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,user.getId());
        pre.setString(2,user.getUsername());
        pre.setString(3,user.getPassword());
        pre.setString(4,user.getEmail());
        pre.setString(5,user.getGender());
        pre.setDate(6, (java.sql.Date) user.getBirthDate());
        return pre.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from hkj where id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,id);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from hkj where username='"+username+"' and password='"+password+"'";
        PreparedStatement st= con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;

        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from hkj where username=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,username);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from hkj where password=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,password);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from hkj where email=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,email);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from hkj where gender=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,gender);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from hkj where birthdate=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setDate(1,(java.sql.Date) birthDate);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from hkj";
        PreparedStatement pre = con.prepareStatement(sql);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }
}
