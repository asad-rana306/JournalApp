package net.engineeringdigest.journalApp.controller;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController{
    @Autowired
    private UserService userService;

    @GetMapping
    public String healthCheck(){
        return "Ok";
    }
    @PostMapping("/create-user")
    public boolean createUser(@RequestBody User user){
        userService.saveNewUser(user);
        return true;
    }
}