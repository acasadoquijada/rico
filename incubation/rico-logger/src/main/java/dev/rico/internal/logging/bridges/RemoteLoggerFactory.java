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
package dev.rico.internal.logging.bridges;

import dev.rico.internal.logging.LoggerConfiguration;
import dev.rico.internal.logging.spi.LoggerBridge;
import dev.rico.internal.logging.spi.LoggerBridgeFactory;

public class RemoteLoggerFactory implements LoggerBridgeFactory {

    @Override
    public String getName() {
        return "REMOTE";
    }

    @Override
    public LoggerBridge create(LoggerConfiguration configuration) {
        if(configuration.getRemoteUrl() != null) {
            return new RemoteLogger(configuration);
        }
        return null;
    }
}
