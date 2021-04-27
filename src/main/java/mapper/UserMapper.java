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
        if (user.getId() == null) {
            try (PreparedStatement statement = connection.prepareStatement("insert into pattern_user(user_name, user_pass, is_active) values (?, ?, ?)")) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getIsActive());
                statement.executeUpdate();
                user.setId(statement.getGeneratedKeys().getLong("id"));
            } catch (SQLException exception) {
                throw new RuntimeException("SQL insert error", exception);
            }
        } else {
            try (PreparedStatement statement = connection.prepareStatement("update pattern_user set user_name = ?, user_pass = ?, is_active = ? where id = ?")) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getIsActive());
                statement.setLong(4, user.getId());
                statement.executeUpdate();
            } catch (SQLException exception) {
                throw new RuntimeException("SQL update error", exception);
            }
        }
        return user;
    }

    @Override
    public void deleteById(Long aLong) {
        try (PreparedStatement statement = connection.prepareStatement("delete pattern_user where id = ?")) {
            statement.setLong(1, aLong);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("SQL delete error", exception);
        }
    }

    @Override
    public User getByName(String name) {
        try (PreparedStatement statement = connection.prepareStatement("select id, user_pass, is_active from pattern_user where user_name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new User(
                        resultSet.getLong("id"),
                        name,
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
}
