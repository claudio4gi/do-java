package br.com.project.authentication.controller;

import br.com.project.authentication.common.UserFilter;
import br.com.project.authentication.common.UserFilterUtils;
import br.com.project.authentication.infra.security.Privileges;
import br.com.project.authentication.model.User;
import br.com.project.authentication.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Privileges
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public User save(@Valid @RequestBody User entity) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        entity.setPassword(encoder.encode(entity.getPassword()));

        if (StringUtils.isEmpty(entity.getId()))
            entity.setId(ObjectId.get());

        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String objectId) {
        return repository.findById(objectId)
                .orElseThrow(() -> new IllegalArgumentException("Object not found."));
    }

    @Privileges
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String objectId) {
        repository.deleteById(objectId);
    }

    @GetMapping("/search")
    public Page<User> search(@RequestBody UserFilter userFilter) {
        return repository.findAll(UserFilterUtils.ofFilter(userFilter), UserFilterUtils.ofPageable(userFilter));
    }
}
