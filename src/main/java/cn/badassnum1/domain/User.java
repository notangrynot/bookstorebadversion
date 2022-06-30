package cn.badassnum1.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private int account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
