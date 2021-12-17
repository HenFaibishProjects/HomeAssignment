package dataLayer.daoImplements;

import businessObjects.User;
import businessObjects.UserRequest;
import dataLayer.daoInterfaces.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserDaoImplement implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImplement.class);
    private Map<Integer,User> inMemoryDB = new HashMap<>();

    @Override
    public int addUser(UserRequest userRequest) {
        int generateUid = 1;
        User user = new User(generateUid,userRequest.getName(),userRequest.getAge());
        inMemoryDB.put(generateUid,user);
        return generateUid;
    }

    @Override
    public void deleteByid(int id) {
        inMemoryDB.remove(id);
    }

    @Override
    public List<User> getUserList(String namePrefix, float olderThan) {
        return inMemoryDB
                .values()
                .stream()
                .filter(user -> user.getAge()>olderThan)
                .filter(user -> user.getName().startsWith(namePrefix))
                .collect(Collectors.toList());

    }
}
