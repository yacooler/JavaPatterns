package identitymap;

import mapper.BaseMapper;
import mapper.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserIdentityMap implements IdentityMap<User, Long> {

    private final Map<Long, User> userMap = new HashMap<>();
    private final BaseMapper<User, Long> baseMapper;


    //В спринге была бы инъекция
    public UserIdentityMap(BaseMapper<User, Long> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public User getById(Long aLong) {
        User user = userMap.get(aLong);
        if (user == null) {
            user = baseMapper.getById(aLong);
            if (user != null) {
                userMap.put(aLong, user);
                return user;
            }
        } else {
            System.out.printf("Пользователь id=%s найден в кэше!\n", aLong);
            return user;
        }
        return null;
    }
}
