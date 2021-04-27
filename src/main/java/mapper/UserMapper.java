package mapper;

import mapper.entity.User;

import java.sql.Connection;

public class UserMapper implements BaseMapper<User, Long> {

    private Connection connection;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getById() {
        return null;
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
