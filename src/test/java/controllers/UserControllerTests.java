package controllers;

import businessObjects.User;
import businessObjects.UserRequest;
import dataLayer.daoImplements.UserDaoImplement;
import infra.MemoryDB;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;



public class UserControllerTests {
    private UserDaoImplement userDaoImplement;

    @BeforeClass
    public void createServiceObject() {
        userDaoImplement=new UserDaoImplement();
    }

    @BeforeMethod
    public void createMockDB() {
        MemoryDB.inMemoryDB.put(1,new User(1,"John",25));
        MemoryDB.inMemoryDB.put(2,new User(2,"Stiv",20));
        MemoryDB.inMemoryDB.put(3,new User(3,"Danny",15));
        MemoryDB.inMemoryDB.put(4,new User(4,"Robert",32));
    }

    @Test(groups = {"userServvice"})
    public void getByPrefixAndAge() {
        List<User> response = userDaoImplement.getUserList("Da",10);
        Assert.assertEquals(response.size(),1);
        Assert.assertEquals(response.get(0).getName(),"Danny");
    }

    @Test(groups = {"userServvice"})
    public void addNewUser() {
        UserRequest user=new UserRequest("Eric",38);
        userDaoImplement.addUser(user);
        Assert.assertEquals(MemoryDB.inMemoryDB.size(),5);
        Assert.assertEquals((int) MemoryDB.inMemoryDB
                .values()
                .stream()
                .filter(usern -> usern.getName().equals("Eric")).count(),1);

    }

    @Test(groups = {"userServvice"})
    public void deleteUserById() {
        userDaoImplement.deleteByid(1);
        Assert.assertEquals(MemoryDB.inMemoryDB.size(),3);
        Assert.assertEquals((int) MemoryDB.inMemoryDB
                .values()
                .stream()
                .filter(user -> user.getName().equals("John")).count(),0);
    }


}
