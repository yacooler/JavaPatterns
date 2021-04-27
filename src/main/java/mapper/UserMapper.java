package mapper;

import mapper.entity.User;

public class UserMapper implements BaseMapper<User, Long> {
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
