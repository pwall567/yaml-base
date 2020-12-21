# yaml-base

[![Build Status](https://travis-ci.org/pwall567/yaml-base.svg?branch=main)](https://travis-ci.org/pwall567/yaml-base)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maven Central](https://img.shields.io/maven-central/v/net.pwall.yaml/yaml-base?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.pwall.yaml%22%20AND%20a:%22yaml-base%22)

Base classes for YAML implementation.

The specification of YAML is contained in a document entitled
[YAML Ain't Markup Language (YAML&trade;) Version 1.2](https://yaml.org/spec/1.2/spec.html), and that document (in
[&sect;1.3. Relation to JSON](https://yaml.org/spec/1.2/spec.html#id2759572)) states "YAML can &hellip; be viewed as a
natural superset of JSON".
Accordingly, each of the classes in this library derives from the equivalent class in the
[`jsonutil`](https://github.com/pwall567/jsonutil) library (and that library is a transitive dependency of this one).
A tree of `YAMLNode` objects can therefore be navigated as if it were a tree of `JSONValue`s.

## Reference

### `YAMLNode`

The root interface for all YAML nodes.
It extends `JSONValue`, and it adds a single method:
- `String getTag()`: return the tag associated with the node

Each of the implementing classes has a constructor that takes a tag in the form of a `String`, along with constructors
that supply a default tag name (from the specification
[&sect;10.3. Core Schema](https://yaml.org/spec/1.2/spec.html#id2804923)).
The tag name is immutable and no setter is provided.

### `YAMLScalar`

This is a marker interface, implemented by the implementation classes for the various forms of YAML scalar.
It extends `YAMLNode` and adds no additional methods.

### `YAMLString`

`YAMLString` extends `JSONString` and implements `YAMLScalar`.
The `JSONString.get()` function returns the value.

Example:
```java
        YAMLString yamlString = new YAMLString("Hello!");
        System.out.println(yamlString.get()); // prints Hello!
```

### `YAMLInt`

`YAMLInt` extends `JSONInteger` and implements `YAMLScalar`.
The `JSONInteger.get()` function returns the value.

Example:
```java
        YAMLInt yamlInt = new YAMLInt(3 * 3 * 3);
        System.out.println(yamlInt.get()); // prints 27
```

### `YAMLLong`

`YAMLLong` extends `JSONLong` and implements `YAMLScalar`.
The `YAMLLong.get()` function returns the value.

Example:
```java
        YAMLLong yamlLong = new YAMLLong(1234567812345678L);
        System.out.println(yamlLong.get()); // prints 1234567812345678
```

### `YAMLDecimal`

`YAMLDecimal` extends `JSONDecimal` and implements `YAMLScalar`.
The `YAMLDecimal.get()` function returns the value.

Example:
```java
        YAMLDecimal yamlDecimal = new YAMLDecimal(new BigDecimal("123.45"));
        System.out.println(yamlDecimal.get()); // prints 123.45
```

### `YAMLBoolean`

`YAMLBoolean` extends `JSONBoolean` and implements `YAMLScalar`.
The `YAMLBoolean.get()` function returns the value.

Example:
```java
        YAMLBoolean yamlBoolean = YAMLBoolean.TRUE;
        System.out.println(yamlBoolean.get()); // prints true
```

### `YAMLSequence`

`YAMLSequence` extends `JSONSequence<YAMLNode>` and implements `YAMLNode`.
`JSONSequence<YAMLNode>` implements `List<YAMLNode>`, so all of the functionality of the `List` interface is available
to access the members of the sequence.

Example:
```java
        YAMLSequence yamlSequence = new YAMLSequence(Arrays.asList(new YAMLString("Hello"), new YAMLString("World")));
        for (YAMLNode node : yamlSequence)
            System.out.println(node); // prints Hello (first time), World (second time)
```

### `YAMLMapping`

`YAMLMapping` extends `JSONMapping<YAMLNode>` and implements `YAMLNode`.
`JSONMapping<YAMLNode>` implements `Map<String, YAMLNode>`, so all of the functionality of the `Map` interface is
available to access the members of the mapping.

Example:
```java
        Map<String, YAMLNode> map = new HashMap<>();
        map.put("greeting", new YAMLString("Hello"));
        map.put("who", new YAMLString("World"));
        YAMLMapping yamlMapping = new YAMLMapping(map);
        System.out.println(yamlMapping.get("greeting")); // prints Hello
        System.out.println(yamlMapping.get("who")); // prints World
```

### `YAMLDocument`

`YAMLDocument` is a container to hold the results of a YAML parse operation.
It contains the root node of the parsed document, along with the version number from the `%YAML` directive (if
provided).

Constructors:
- `YAMLDocument(YAMLNode rootNode, int majorVersion, int minorVersion)`
- `YAMLDocument(YAMLNode rootNode)` (defaults majorVersion to 1 and minorVersion to 2)

Functions:
- `YAMLNode getRootNode()`
- `int getMajorVersion()`
- `int getMinorVersion()`

## Dependency Specification

The latest version of the library is 1.1, and it may be obtained from the Maven Central repository.

### Maven
```xml
    <dependency>
      <groupId>net.pwall.yaml</groupId>
      <artifactId>yaml-base</artifactId>
      <version>1.1</version>
    </dependency>
```
### Gradle
```groovy
    testImplementation 'net.pwall.yaml:yaml-base:1.1'
```
### Gradle (kts)
```kotlin
    testImplementation("net.pwall.yaml:yaml-base:1.1")
```

Peter Wall

2020-12-21
