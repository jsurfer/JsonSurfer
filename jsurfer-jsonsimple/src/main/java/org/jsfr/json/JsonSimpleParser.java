/*
 * The MIT License
 *
 * Copyright (c) 2017 WANG Lingsong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jsfr.json;

import org.json.simple.parser.JSONParser;

import java.io.Reader;
import java.io.StringReader;

public class JsonSimpleParser implements JsonParserAdapter {

    public static final JsonSimpleParser INSTANCE = new JsonSimpleParser();

    private JsonSimpleParser(){}

    @Override
    public void parse(Reader reader, SurfingContext context) {
        JSONParser parser = new JSONParser();
        try {
            parser.parse(reader, new JsonSimpleHandlerAdapter(context));
        } catch (Exception e) {
            context.getConfig().getErrorHandlingStrategy().handleParsingException(e);
        }
    }

    @Override
    public void parse(String json, SurfingContext context) {
        parse(new StringReader(json), context);
    }

}
