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
package dev.rico.internal.projection.notifications;

import dev.rico.internal.projection.base.AbstractProjectableBean;
import dev.rico.internal.projection.message.Message;
import dev.rico.internal.projection.message.MessageType;
import dev.rico.remoting.Property;
import dev.rico.remoting.RemotingBean;

@RemotingBean
public class NotificationBean extends AbstractProjectableBean implements Message {

    private Property<MessageType> messageType;

    private Property<String> description;

    private Property<String> title;

    @Override
    public Property<MessageType> messageTypeProperty() {
        return messageType;
    }

    @Override
    public Property<String> descriptionProperty() {
        return description;
    }

    @Override
    public Property<String> titleProperty() {
        return title;
    }
}
