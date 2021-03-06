/*
 * Copyright 2018-2019 Karakun AG.
 * Copyright 2015-2018 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.rico.integrationtests.server.remoting.enterprise;

import dev.rico.integrationtests.remoting.enterprise.EnterpriseTestBean;
import dev.rico.integrationtests.server.TestConfiguration;
import dev.rico.remoting.Property;
import dev.rico.server.remoting.test.ControllerUnderTest;
import dev.rico.server.remoting.test.SpringTestNGControllerTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static dev.rico.integrationtests.remoting.enterprise.EnterpriseTestConstants.ENTERPRISE_CONTROLLER_NAME;

@SpringBootTest(classes = TestConfiguration.class)
public class EnterpriseTestControllerTest extends SpringTestNGControllerTest {

    private ControllerUnderTest<EnterpriseTestBean> controller;

    @BeforeMethod
    public void init() {
        controller = createController(ENTERPRISE_CONTROLLER_NAME);
    }

    public void destroy() {
        controller.destroy();
    }

    @Test
    public void testPostConstructCalled() {
        Assert.assertTrue(controller.getModel().getPostConstructCalled());
        destroy();
    }

    @Test
    public void testInjection() {
        Assert.assertTrue(controller.getModel().getEventBusInjected());
        destroy();
    }

    @Test
    public void testPreDestroyCalled() {
        Property<Boolean> preDestroyCalledProperty = controller.getModel().preDestroyCalledProperty();
        destroy();
        Assert.assertTrue(preDestroyCalledProperty.get());
    }

}
