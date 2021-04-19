/*
 * @(#) YAMLMappingTest.java
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

package net.pwall.yaml.test;

import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import net.pwall.util.ListMap;
import net.pwall.yaml.YAMLInt;
import net.pwall.yaml.YAMLMapping;
import net.pwall.yaml.YAMLNode;
import net.pwall.yaml.YAMLString;

public class YAMLMappingTest {

    @Test
    public void shouldCreateYAMLMapping() {
        Map<String, YAMLNode> map = new ListMap<>();
        map.put("key1", new YAMLString("value1"));
        map.put("key2", new YAMLInt(123));
        YAMLMapping yamlMapping1 = new YAMLMapping(map);
        assertEquals("value1", ((YAMLString)yamlMapping1.get("key1")).getValue());
        assertEquals(123, ((YAMLInt)yamlMapping1.get("key2")).getValue());
    }

    @Test
    public void shouldCreateYAMLMappingWithDefaultTag() {
        Map<String, YAMLNode> map = new ListMap<>();
        map.put("key1", new YAMLString("value1"));
        map.put("key2", new YAMLInt(123));
        YAMLMapping yamlMapping = new YAMLMapping(map);
        assertEquals("value1", ((YAMLString)yamlMapping.get("key1")).getValue());
        assertEquals(123, ((YAMLInt)yamlMapping.get("key2")).getValue());
        assertEquals(YAMLMapping.defaultTag, yamlMapping.getTag());
    }

    @Test
    public void shouldCreateYAMLMappingWithCustomTag() {
        String customTag = "tag:yaml.pwall.net,2020:custom";
        Map<String, YAMLNode> map = new ListMap<>();
        map.put("key1", new YAMLString("value1"));
        map.put("key2", new YAMLInt(123));
        YAMLMapping yamlMapping = new YAMLMapping(map, customTag);
        assertEquals("value1", ((YAMLString)yamlMapping.get("key1")).getValue());
        assertEquals(123, ((YAMLInt)yamlMapping.get("key2")).getValue());
        assertEquals(customTag, yamlMapping.getTag());
    }

}
