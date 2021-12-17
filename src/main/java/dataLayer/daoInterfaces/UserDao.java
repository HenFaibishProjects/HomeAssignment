package dataLayer.daoInterfaces;


import businessObjects.User;
import businessObjects.UserRequest;

import java.util.List;

public interface UserDao {

    int addUser(UserRequest userRequest);
    void deleteByid(int id);
     List<User> getUserList(String name, float age);
}
