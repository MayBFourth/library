package com.librabymanagement.DAO;

import com.librabymanagement.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
//    CRUD
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String CREATE_USER = "INSERT INTO user VALUES(?,?,?,?,?)";
    private static final String UPDATE_NAME_BY_ID = "UPDATE user SET name = ? WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param id: ID of User
     * @return: User
     */
    public User getUserById(Long id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try{
            ps = connection.prepareStatement(GET_USER_BY_ID);
            ps.setLong(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User createUser(User user){
        PreparedStatement ps = null;
        ResultSet rs = null;
        User newUser = null;
        try{
            ps = connection.prepareStatement(CREATE_USER);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
            newUser = new User();
            newUser.setId(user.getId());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
        return newUser;
    }

    private boolean updateNameById(String name, Long id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            ps = connection.prepareStatement(UPDATE_NAME_BY_ID);
            ps.setString(1, name);
            ps.setLong(2, id);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void deleteNameById(Long id){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE_USER_BY_ID);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
