package mapper;

import mapper.entity.Product;

import java.sql.Connection;

public class ProductMapper implements BaseMapper<Product, Long> {
    private Connection connection;

    public ProductMapper(Connection connection) {
        this.connection = connection;
    }

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
