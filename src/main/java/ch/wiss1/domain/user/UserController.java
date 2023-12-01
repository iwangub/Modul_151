package ch.wiss1.domain.user;

import ch.wiss1.domain.product.Product;
import ch.wiss1.domain.user.dto.UserDTO;
import ch.wiss1.domain.user.dto.UserMapper;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<User>> retrieveAll(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "3") int pagesize) {
        return new ResponseEntity<>(userService.findAll(PageRequest.of(page, pagesize, Sort.by("firstName").descending())), HttpStatus.OK);
    }

}
