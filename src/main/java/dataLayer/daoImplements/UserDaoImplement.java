package dataLayer.daoImplements;

import businessObjects.User;
import businessObjects.UserRequest;
import dataLayer.daoInterfaces.UserDao;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.UUID;



@Service
@Repository
@AllArgsConstructor
public class UserDaoImplement implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImplement.class);
    private Map<Integer,User> inMemoryDB = new HashMap<>();

    @Override
    public int addUser(UserRequest userRequest) {
        int generateUid = UUID.randomUUID().variant();
        LOG.info("Adding New User with ID "+generateUid);
        User user = new User(generateUid,userRequest.getName(),userRequest.getAge());
        inMemoryDB.put(generateUid,user);
        return generateUid;
    }

    @Override
    public void deleteByid(int id) {
        LOG.info("Try delete user with id:"+id);
        inMemoryDB.remove(id);
        LOG.info("User with id:"+id + "is deleted");

    }

    @Override
    public List<User> getUserList(String namePrefix, float olderThan) {
        LOG.info("getting users list with namePrefix="+namePrefix +" and older than"+olderThan);
        return inMemoryDB
                .values()
                .stream()
                .filter(user -> user.getAge()>olderThan)
                .filter(user -> user.getName().startsWith(namePrefix))
                .collect(Collectors.toList());

    }
}
