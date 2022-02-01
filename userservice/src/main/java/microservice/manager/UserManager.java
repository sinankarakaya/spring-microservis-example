package microservice.manager;

import microservice.entities.User;
import microservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserManager {


    private final UserRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserManager(UserRepository repository,
                       RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public User save(User user) {
        return this.repository.save(user);
    }

    public User getById(ObjectId id) {
        return this.repository.findById(id).orElse(null);
    }

    public User getUserWithDepartment(String id) {
        User user = this.getById(new ObjectId(id));
        return  user;
    }
}
