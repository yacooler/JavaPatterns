package identitymap;

import mapper.BaseMapper;
import mapper.entity.Product;
import mapper.entity.User;

import java.util.HashMap;
import java.util.Map;

public class ProductIdentityMap implements IdentityMap<Product, Long> {
    private final Map<Long, Product> productMap = new HashMap<>();
    private final BaseMapper<Product, Long> baseMapper;

    //В спринге была бы инъекция
    public ProductIdentityMap(BaseMapper<Product, Long> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public Product getById(Long aLong) {
        Product product = productMap.get(aLong);
        if (product == null) {
            product = baseMapper.getById(aLong);
            if (product != null) {
                productMap.put(aLong, product);
                return product;
            }
        } else {
            System.out.printf("Продукт id=%s найден в кэше!\n", aLong);
            return product;
        }
        return null;
    }

}
