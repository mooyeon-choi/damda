package damda.back.controller;


import damda.back.dto.UserDto;
import damda.back.entity.Users;
import damda.back.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login/{id}")
    ResponseEntity<Users> getUser(@PathVariable String id) {
        return userService.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    ResponseEntity<Users> saveUser(@RequestBody UserDto userDto) {
        Users user = Users.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .build();
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/login")
    ResponseEntity<Users> updateUser(@RequestBody UserDto userDto) {
        Users user = Users.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .build();
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/login/{id}")
    ResponseEntity<Users> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
