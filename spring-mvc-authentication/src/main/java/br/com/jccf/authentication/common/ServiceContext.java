package br.com.jccf.authentication.common;

import br.com.jccf.authentication.model.User;
import org.springframework.stereotype.Component;

@Component
public class ServiceContext {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
