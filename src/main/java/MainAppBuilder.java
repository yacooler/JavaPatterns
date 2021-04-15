import builder.MSSQLConnection;
import builder.MSSQLConnectionBuilder;

public class MainAppBuilder {
    public static void main(String[] args) {
        MSSQLConnectionBuilder builder = new MSSQLConnectionBuilder();
        MSSQLConnectionBuilder builderFail = new MSSQLConnectionBuilder();

        MSSQLConnection mssqlConnection = builder
                .setIPV4("127.0.0.1")
                .setIPV4Port("1433")
                .setLogin("sa")
                .setPassword("")
                .setAuthType(MSSQLConnection.AuthType.SQL_AUTH)
                .build();

        MSSQLConnection mssqlConnectionFail = builderFail
                .setIPV4("localhost")
                .setLogin("sa")
                .setPassword("")
                .setAuthType(MSSQLConnection.AuthType.SQL_AUTH)
                .build();

    }
}
