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
package dev.rico.remoting.client.javafx;

import org.apiguardian.api.API;

import static org.apiguardian.api.API.Status.MAINTAINED;

/**
 * Defines a converter for a bidirectional binding. This converter type can be used to bind a JavaFX property
 * bidirectional to a remoting property that defines a different data type.
 * @param <T> data type of the first property
 * @param <U> data type of the second property
 */
@API(since = "0.x", status = MAINTAINED)
public interface BidirectionalConverter<T, U>  extends Converter<T, U> {

    /**
     * Converts a value of the second data type to a value of the first data type.
     * @param value the given value
     * @return the converted value.
     */
    T convertBack(U value);

    /**
     * Creates a new {@link BidirectionalConverter} with inverted data types.
     * @return a new {@link BidirectionalConverter} with inverted data types.
     */
    default BidirectionalConverter<U, T> invert() {
        final BidirectionalConverter<T, U> converter = this;
        return new BidirectionalConverter<>() {
            @Override
            public U convertBack(final T value) {
                return converter.convert(value);
            }

            @Override
            public T convert(final U value) {
                return converter.convertBack(value);
            }
        };
    }
}
