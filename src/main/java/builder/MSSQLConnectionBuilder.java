package builder;

public class MSSQLConnectionBuilder {
    private final MSSQLConnection mssqlConnection;

    public MSSQLConnectionBuilder() {
        mssqlConnection = new MSSQLConnection();
    }

    public MSSQLConnectionBuilder setIPV4(String ipv4){
        mssqlConnection.setIpV4(ipv4);
        return this;
    };

    public MSSQLConnectionBuilder setIPV6(String ipv6){
        mssqlConnection.setIpV6(ipv6);
        return this;
    }

    public MSSQLConnectionBuilder setIPV4Port(String ipv4Port){
        mssqlConnection.setIpv4port(ipv4Port);
        return this;
    }

    public MSSQLConnectionBuilder setIPV6Port(String ipv6Port){
        mssqlConnection.setIpv4port(ipv6Port);
        return this;
    }

    public MSSQLConnectionBuilder setLogin(String login){
        mssqlConnection.setLogin(login);
        return this;
    }

    public MSSQLConnectionBuilder setPassword(String password){
        mssqlConnection.setPassword(password);
        return this;
    }

    public MSSQLConnectionBuilder setAuthType(MSSQLConnection.AuthType authType){
        mssqlConnection.setAuthType(authType);
        return this;
    }

    public MSSQLConnection build(){
        StringBuilder stringBuilder = new StringBuilder();
        if (isNullOrEmpty(mssqlConnection.getIpV4()) && isNullOrEmpty(mssqlConnection.getIpV6())){
            stringBuilder.append("IPV4 or IPV6 is required!\n");
        }

        if (!isNullOrEmpty(mssqlConnection.getIpV4()) && isNullOrEmpty(mssqlConnection.getIpv4port())){
            stringBuilder.append("IPV4 port is required!\n");
        }

        if (!isNullOrEmpty(mssqlConnection.getIpV6()) && isNullOrEmpty(mssqlConnection.getIpv6port())){
            stringBuilder.append("IPV6 port is required!\n");
        }

        if (isNullOrEmpty(mssqlConnection.getLogin())) {
            stringBuilder.append("Login is required!\n");
        }

        //PWD может быть пустым или с пробелами
        if (mssqlConnection.getPassword() == null) {
            stringBuilder.append("Password is required!\n");
        }


        if (mssqlConnection.getAuthType() == null) {
            stringBuilder.append("AuthType is required!\n");
        }

        if (stringBuilder.length() > 0){
            throw new RequeredArgsMSSQLConnectionBuilderException("Unable to build MS SQL Connection!\n" + stringBuilder.toString());
        }

        return mssqlConnection;

    }

    private boolean isNullOrEmpty(String checked){
        return  (checked == null || checked.isBlank());
    }


}
