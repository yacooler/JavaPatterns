package mapper;

import mapper.entity.Product;

public class ProductMapper implements BaseMapper<Product, Long> {
    @Override
    public Product getById() {
        return null;
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Product getByName(String name) {
        return BaseMapper.super.getByName(name);
    }
}
