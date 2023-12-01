package ch.wiss1.domain.user;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> findAll(Pageable pageable);
}
