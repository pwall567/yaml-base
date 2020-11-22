/*
 * @(#) YAMLString.java
 *
 * yaml-base  Base classes for YAML implementation
 * Copyright (c) 2020 Peter Wall
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.pwall.yaml;

import net.pwall.json.JSONString;

/**
 * A YAML string scalar.
 *
 * @author  Peter Wall
 */
public class YAMLString extends JSONString implements YAMLScalar {

    public static final String defaultTag = "tag:yaml.org,2002:str";

    private final String tag;

    /**
     * Construct a {@code YAMLString} with the given value and tag.
     *
     * @param   value   the value
     * @param   tag     the tag
     */
    public YAMLString(String value, String tag) {
        super(value);
        this.tag = tag;
    }

    /**
     * Construct a {@code YAMLString} with the given value and the default tag.
     *
     * @param   value   the value
     */
    public YAMLString(String value) {
        this(value, defaultTag);
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object other) {
        return other == this ||
                other instanceof YAMLString && super.equals(other) && tag.equals(((YAMLString)other).tag);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ tag.hashCode();
    }

}
