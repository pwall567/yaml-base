/*
 * @(#) YAMLLongTest.java
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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import net.pwall.yaml.YAMLLong;

public class YAMLLongTest {

    @Test
    public void shouldCreateYAMLLong() {
        YAMLLong yamlLong1 = new YAMLLong(12345L);
        assertEquals(12345L, yamlLong1.getValue());
        YAMLLong yamlLong2 = new YAMLLong(-123456789123456789L);
        assertEquals(-123456789123456789L, yamlLong2.getValue());
    }

    @Test
    public void shouldCreateYAMLLongWithDefaultTag() {
        YAMLLong yamlLong = new YAMLLong(12345L);
        assertEquals(12345L, yamlLong.getValue());
        assertEquals(YAMLLong.defaultTag, yamlLong.getTag());
    }

    @Test
    public void shouldCreateYAMLLongWithCustomTag() {
        String customTag = "tag:yaml.pwall.net,2020:custom";
        YAMLLong yamlLong = new YAMLLong(12345L, customTag);
        assertEquals(12345L, yamlLong.getValue());
        assertEquals(customTag, yamlLong.getTag());
    }

}
