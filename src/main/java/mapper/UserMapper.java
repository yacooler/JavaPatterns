package mapper;

import mapper.entity.Product;
import mapper.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements BaseMapper<User, Long> {

    private Connection connection;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getById(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("select user_name, user_pass, is_active from pattern_user where id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new User(id,
                                resultSet.getString("user_name"),
                                resultSet.getString("user_pass"),
                                resultSet.getInt("is_active"));
            } else {
                return null;
            }
        }
        catch (SQLException exception) {
            throw new RuntimeException("SQL select error", exception);
        }
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public User getByName(String name) {
        return BaseMapper.super.getByName(name);
    }
}
