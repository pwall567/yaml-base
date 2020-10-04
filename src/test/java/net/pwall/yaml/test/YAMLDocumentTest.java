/*
 * @(#) YAMLDocumentTest.java
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import net.pwall.yaml.YAMLDocument;
import net.pwall.yaml.YAMLString;

public class YAMLDocumentTest {

    @Test
    public void shouldCreateYAMLDocumentWithExplicitVersion() {
        YAMLString yamlString = new YAMLString("testing");
        YAMLDocument yamlDocument = new YAMLDocument(yamlString, 1, 3);
        assertSame(yamlString, yamlDocument.getRootNode());
        assertEquals(1, yamlDocument.getMajorVersion());
        assertEquals(3, yamlDocument.getMinorVersion());
    }

    @Test
    public void shouldCreateYAMLDocumentWithDefaultVersion() {
        YAMLString yamlString = new YAMLString("testing");
        YAMLDocument yamlDocument = new YAMLDocument(yamlString);
        assertSame(yamlString, yamlDocument.getRootNode());
        assertEquals(1, yamlDocument.getMajorVersion());
        assertEquals(2, yamlDocument.getMinorVersion());
    }

    @Test
    public void shouldCreateYAMLDocumentWithNullRootNode() {
        YAMLDocument yamlDocument = new YAMLDocument(null);
        assertNull(yamlDocument.getRootNode());
        assertEquals(1, yamlDocument.getMajorVersion());
        assertEquals(2, yamlDocument.getMinorVersion());
    }

}
