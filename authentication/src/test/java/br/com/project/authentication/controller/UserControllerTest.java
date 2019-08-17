package br.com.project.authentication.controller;

import br.com.project.authentication.common.UnitBaseTest;
import br.com.project.authentication.common.UserFilter;
import br.com.project.authentication.common.UserFilterUtils;
import br.com.project.authentication.model.User;
import br.com.project.authentication.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserControllerTest extends UnitBaseTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserController userController;

    @Override
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save_defaultSave_success() {
        User user = new User();
        user.setId(ObjectId.get());
        user.setName("Name");
        user.setEmail("email@email.com");
        user.setPassword("pass");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User output = userController.save(user);

        Assert.assertNotNull(output);
        Mockito.verify(userRepository, Mockito.only()).save(user);
    }

    @Test
    public void get_withReturn_success() {
        Mockito.when(userRepository.findById("id")).thenReturn(Optional.of(new User()));

        Assert.assertNotNull(userController.get("id"));
        Mockito.verify(userRepository, Mockito.only()).findById("id");
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_withReturn_fail() {
        userController.get("id");
    }

    @Test
    public void delete_default_success() {
        userController.delete("id");

        Mockito.verify(userRepository, Mockito.only()).deleteById("id");
    }

    @Test
    public void search_default_success() {
        UserFilter userFilter = new UserFilter();

        Mockito.when(userRepository.findAll(UserFilterUtils.ofFilter(userFilter), UserFilterUtils.ofPageable(userFilter)))
                .thenReturn(null);

        Assert.assertNull(userController.search(userFilter));
    }
}