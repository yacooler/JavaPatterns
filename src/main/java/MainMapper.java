import identitymap.ProductIdentityMap;
import identitymap.UserIdentityMap;
import mapper.ProductMapper;
import mapper.UserMapper;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainMapper {
    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/mapper_base", "sa", null).load();
        // Start the migration
        flyway.migrate();

        test();
    }

    public static void test(){
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:h2:file:./target/mapper_base", "sa","");

            ProductMapper productMapper = new ProductMapper(conn);
            UserMapper userMapper = new UserMapper(conn);

            //В спринге это была бы инъекция зависимостей
            ProductIdentityMap productIdentityMap = new ProductIdentityMap(productMapper);
            UserIdentityMap userIdentityMap = new UserIdentityMap(userMapper);

            System.out.println(productIdentityMap.getById(1L));
            System.out.println(productIdentityMap.getById(2L));
            //Из кэша
            System.out.println(productIdentityMap.getById(1L));

            System.out.println(userMapper.getByName("sa"));



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Unable use h2 database", e);
        }



    }
}
