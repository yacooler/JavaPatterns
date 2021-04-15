package builder;

public class MSSQLConnection {
    private String ipV4;
    private String ipV6;
    private String ipv4port;
    private String ipv6port;

    private String login;
    private String password;

    private AuthType authType;

    public enum AuthType{
        WIN_AUTH,
        SQL_AUTH
    }

    public String getIpV4() {
        return ipV4;
    }

    public void setIpV4(String ipV4) {
        this.ipV4 = ipV4;
    }

    public String getIpV6() {
        return ipV6;
    }

    public void setIpV6(String ipV6) {
        this.ipV6 = ipV6;
    }

    public String getIpv4port() {
        return ipv4port;
    }

    public void setIpv4port(String ipv4port) {
        this.ipv4port = ipv4port;
    }

    public String getIpv6port() {
        return ipv6port;
    }

    public void setIpv6port(String ipv6port) {
        this.ipv6port = ipv6port;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }
}
