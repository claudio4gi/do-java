package br.com.project.authentication.common;

import br.com.project.authentication.model.User;
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
