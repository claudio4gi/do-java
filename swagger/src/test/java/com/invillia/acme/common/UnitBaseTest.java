package com.invillia.acme.common;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public abstract class UnitBaseTest {

    @Before
    public abstract void setUp();
}
