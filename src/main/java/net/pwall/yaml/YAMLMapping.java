/*
 * @(#) YAMLMapping.java
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

import java.util.Map;

import net.pwall.json.JSONMapping;

/**
 * A YAML mapping.
 *
 * @author  Peter Wall
 */
public class YAMLMapping extends JSONMapping<YAMLNode> implements YAMLNode {

    public static final String defaultTag = "tag:yaml.org,2002:map";

    private final String tag;

    public YAMLMapping(Map<String, YAMLNode> map, String tag) {
        super(map);
        this.tag = tag;
    }

    public YAMLMapping(Map<String, YAMLNode> map) {
        this(map, defaultTag);
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object other) {
        return other == this ||
                other instanceof YAMLMapping && super.equals(other) && tag.equals(((YAMLMapping)other).tag);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ tag.hashCode();
    }

}
