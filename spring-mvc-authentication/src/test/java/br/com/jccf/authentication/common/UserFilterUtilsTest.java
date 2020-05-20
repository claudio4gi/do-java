package br.com.jccf.authentication.common;

import br.com.jccf.authentication.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class UserFilterUtilsTest extends UnitBaseTest {

    @Override
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ofPageable_nullObject_success() {
        PageRequest pageRequest = UserFilterUtils.ofPageable(new UserFilter());

        Assert.assertEquals(pageRequest.getPageNumber(), 0);
        Assert.assertEquals(pageRequest.getPageSize(), 100);
        Assert.assertTrue(pageRequest.getSort().isSorted());

        pageRequest.getSort().get()
                .findFirst()
                .ifPresent(f -> {
                    Assert.assertEquals(f.getProperty(), "name");
                    Assert.assertEquals(f.getDirection(), Sort.Direction.ASC);
                });

        Assert.assertEquals(pageRequest.getSort().get().count(), 1);
    }

    @Test
    public void ofPageable_withObject_success() {
        UserFilter userFilter = new UserFilter();
        userFilter.setAuth(new User());
        userFilter.setPage(10);
        userFilter.setSize(200);
        userFilter.setFields(new String[]{"fields"});
        userFilter.setDirection(Sort.Direction.DESC);

        PageRequest pageRequest = UserFilterUtils.ofPageable(userFilter);

        Assert.assertEquals(pageRequest.getPageNumber(), userFilter.getPage().intValue());
        Assert.assertEquals(pageRequest.getPageSize(), userFilter.getSize().intValue());
        Assert.assertTrue(pageRequest.getSort().isSorted());

        pageRequest.getSort().get()
                .findFirst()
                .ifPresent(f -> {
                    Assert.assertEquals(f.getProperty(), "fields");
                    Assert.assertEquals(f.getDirection(), Sort.Direction.DESC);
                });

        Assert.assertEquals(pageRequest.getSort().get().count(), 1);
    }

    @Test
    public void ofFilter_nullParam_success() {
        Assert.assertNotNull(UserFilterUtils.ofFilter(null));
    }

    @Test
    public void ofFilter_newParam_success() {
        Assert.assertNotNull(UserFilterUtils.ofFilter(new UserFilter()));
    }

    @Test
    public void ofFilter_default_success() {
        Assert.assertNotNull(UserFilterUtils.ofFilter(new UserFilter()));
    }
}