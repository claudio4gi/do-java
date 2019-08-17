package br.com.project.authentication.common;

import br.com.project.authentication.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class UserFilterUtils {

    private UserFilterUtils() {
    }

    public static PageRequest ofPageable(UserFilter userFilter) {
        return PageRequest.of(userFilter.getPage() == null ? 0 : userFilter.getPage(),
                userFilter.getSize() == null ? 100 : userFilter.getSize(),
                userFilter.getDirection() == null ? Sort.Direction.ASC : userFilter.getDirection(),
                userFilter.getFields() == null ? new String[]{"name"} : userFilter.getFields());
    }

    public static Example<User> ofFilter(UserFilter userFilter) {
        User auth = new User();

        if (userFilter == null || userFilter.getAuth() == null) return Example.of(auth);

        auth.setName(userFilter.getAuth().getName());
        auth.setEmail(userFilter.getAuth().getEmail());
        auth.setAddress(userFilter.getAuth().getAddress());
        auth.setPhone(userFilter.getAuth().getPhone());
        auth.setProfile(userFilter.getAuth().getProfile());

        return Example.of(auth);
    }
}
