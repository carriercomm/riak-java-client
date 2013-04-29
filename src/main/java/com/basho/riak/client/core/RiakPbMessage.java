/*
 * Copyright 2013 Basho Technologies Inc.
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
package com.basho.riak.client.core;

import com.basho.riak.client.core.converters.RiakResponseConverter;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Brian Roach <roach at basho dot com>
 * @since 2.0
 */
public final class RiakPbMessage implements RiakResponse
{
    private final byte code;
    private final byte[] data;
    
    public RiakPbMessage(byte code, byte[] data)
    {
        this.code = code;
        this.data = data;
    }
    
    public byte getCode()
    {
        return code;
    }
    
    public byte[] getData()
    {
        return data;
    }
 
    @Override
    public <T> T convertResponse(RiakResponseConverter<T> converter) throws ExecutionException
    {
        return converter.convert(code, data);
    }
}
