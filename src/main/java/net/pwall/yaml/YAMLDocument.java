/*
 * @(#) YAMLDocument.java
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

/**
 * A parsed YAML document.
 *
 * @author  Peter Wall
 */
public class YAMLDocument {

    public static final int defaultMajorVersion = 1;
    public static final int defaultMinorVersion = 2;

    private final YAMLNode rootNode;
    private final byte majorVersion;
    private final byte minorVersion;

    /**
     * Construct a {@code YAMLDocument} with the supplied root node, major version number and minor version number
     *
     * @param   rootNode        The root node
     * @param   majorVersion    The major version number
     * @param   minorVersion    The minor version number
     */
    public YAMLDocument(YAMLNode rootNode, int majorVersion, int minorVersion) {
        this.rootNode = rootNode;
        this.majorVersion = (byte)majorVersion;
        this.minorVersion = (byte)minorVersion;
    }

    /**
     * Construct a {@code YAMLDocument} with the supplied root node and default version numbers
     *
     * @param   rootNode        The root node
     */
    public YAMLDocument(YAMLNode rootNode) {
        this(rootNode, defaultMajorVersion, defaultMinorVersion);
    }

    /**
     * Get the root node of the document.
     *
     * @return  the root node
     */
    public YAMLNode getRootNode() {
        return rootNode;
    }

    /**
     * Get the major version number.
     *
     * @return  the major version number
     */
    public int getMajorVersion() {
        return majorVersion;
    }

    /**
     * Get the minor version number.
     *
     * @return  the minor version number
     */
    public int getMinorVersion() {
        return minorVersion;
    }

}
