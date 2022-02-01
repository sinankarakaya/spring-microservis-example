package microservice.controller;



import microservice.entities.User;
import microservice.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserManager userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public User getUser(
            @RequestHeader(value = "id") String userId) {
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping(value = "/secure")
    public String getSecure() {
        return "Secure endpoint available";
    }
}
