package memento;

import org.flywaydb.core.Flyway;

public class MainMapper {
    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/mapper_base", "sa", null).load();

        // Start the migration
        flyway.migrate();
    }
}
