/*
 * Copyright 2013 Basho Technologies Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.basho.riak.client.operations.datatypes;

import com.basho.riak.client.query.crdt.types.CrdtElement;

public abstract class DatatypeConverter<T extends RiakDatatype>
{

    public abstract T convert(CrdtElement element);

    public static DatatypeConverter<RiakCounter> asCounter()
    {
        return new DatatypeConverter<RiakCounter>()
        {
            @Override
            public RiakCounter convert(CrdtElement element)
            {
                return new RiakCounter(element.getAsCounter());
            }
        };
    }

    public static DatatypeConverter<RiakMap> asMap()
    {
        return new DatatypeConverter<RiakMap>()
        {
            @Override
            public RiakMap convert(CrdtElement element)
            {
                return new RiakMap(element.getAsMap());
            }
        };
    }

    public static DatatypeConverter<RiakSet> asSet()
    {
        return new DatatypeConverter<RiakSet>()
        {
            @Override
            public RiakSet convert(CrdtElement element)
            {
                return new RiakSet(element.getAsSet());
            }
        };
    }

}
