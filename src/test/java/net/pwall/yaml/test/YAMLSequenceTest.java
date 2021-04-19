/*
 * @(#) YAMLSequenceTest.java
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

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import net.pwall.yaml.YAMLNode;
import net.pwall.yaml.YAMLSequence;
import net.pwall.yaml.YAMLString;

public class YAMLSequenceTest {

    @Test
    public void shouldCreateYAMLSequence() {
        YAMLSequence yamlSequence1 = new YAMLSequence(createList("hello", "world"));
        assertEquals("hello", ((YAMLString)yamlSequence1.get(0)).getValue());
        assertEquals("world", ((YAMLString)yamlSequence1.get(1)).getValue());
    }

    @Test
    public void shouldCreateYAMLSequenceWithDefaultTag() {
        YAMLSequence yamlSequence = new YAMLSequence(createList("one", "two"));
        assertEquals("one", ((YAMLString)yamlSequence.get(0)).getValue());
        assertEquals("two", ((YAMLString)yamlSequence.get(1)).getValue());
        assertEquals(YAMLSequence.defaultTag, yamlSequence.getTag());
    }

    @Test
    public void shouldCreateYAMLSequenceWithCustomTag() {
        String customTag = "tag:yaml.pwall.net,2020:custom";
        YAMLSequence yamlSequence = new YAMLSequence(createList("un", "deux"), customTag);
        assertEquals("un", ((YAMLString)yamlSequence.get(0)).getValue());
        assertEquals("deux", ((YAMLString)yamlSequence.get(1)).getValue());
        assertEquals(customTag, yamlSequence.getTag());
    }

    private List<YAMLNode> createList(String ... strings) {
        List<YAMLNode> list = new ArrayList<>(strings.length);
        for (String string : strings)
            list.add(new YAMLString(string));
        return list;
    }

}
