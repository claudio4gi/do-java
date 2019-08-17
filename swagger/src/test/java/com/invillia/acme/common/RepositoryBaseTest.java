package com.invillia.acme.common;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"DB_TYPE = H2"})
public abstract class RepositoryBaseTest {

    @After
    public abstract void cleanUp();
}
