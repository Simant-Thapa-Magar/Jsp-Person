package dao;

public interface UserDao<T> {
    boolean verifyLogin(String userName,String password);
}
