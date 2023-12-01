package ch.wiss1.domain.user;

import ch.wiss1.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        Page<User> pagedUsers = repository.findAll(pageable);
        return pagedUsers.hasContent() ? pagedUsers.getContent() : List.of();
    }
}
