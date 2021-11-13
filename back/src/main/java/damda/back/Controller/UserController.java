package damda.back.Controller;


import damda.back.Dto.UserDto;
import damda.back.Entity.User;
import damda.back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login/{id}")
    ResponseEntity<User> getUser(@PathVariable String id) {
        return userService.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    ResponseEntity<User> saveUser(@RequestBody UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .build();
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/login")
    ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .build();
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/login/{id}")
    ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
