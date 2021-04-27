package mapper;

import mapper.entity.Product;

import java.sql.*;

public class ProductMapper implements BaseMapper<Product, Long> {
    private Connection connection;

    public ProductMapper(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product getById(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("select name, price from product where id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Product(id, resultSet.getString("name"), resultSet.getBigDecimal("price") );
            } else {
                return null;
            }
        }
        catch (SQLException exception) {
            throw new RuntimeException("SQL select error", exception);
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {

        if (product.getId() == null) {
            try (PreparedStatement statement = connection.prepareStatement("insert into products(name, price) values (?, ?)")) {
                statement.setString(1, product.getName());
                statement.setBigDecimal(2, product.getPrice());
                statement.executeUpdate();
                product.setId(statement.getGeneratedKeys().getLong("id"));
            } catch (SQLException exception) {
                throw new RuntimeException("SQL insert error", exception);
            }
        } else {
            try (PreparedStatement statement = connection.prepareStatement("update products set name = ?, price = ? where id = ?")) {
                statement.setString(1, product.getName());
                statement.setBigDecimal(2, product.getPrice());
                statement.setLong(3, product.getId());
                statement.executeUpdate();
            } catch (SQLException exception) {
                throw new RuntimeException("SQL update error", exception);
            }
        }
        return product;
    }

    @Override
    public void deleteById(Long aLong) {
        try (PreparedStatement statement = connection.prepareStatement("delete products where id = ?")) {
            statement.setLong(1, aLong);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("SQL delete error", exception);
        }
    }

    @Override
    public Product getByName(String name) {
        try (PreparedStatement statement = connection.prepareStatement("select id, price from product where name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Product(resultSet.getLong("id"), name, resultSet.getBigDecimal("price") );
            } else {
                return null;
            }
        }
        catch (SQLException exception) {
            throw new RuntimeException("SQL select error", exception);
        }
    }
}
