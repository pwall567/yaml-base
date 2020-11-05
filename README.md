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

## Dependency Specification

The latest version of the library is 0.2, and it may be obtained from the Maven Central repository.

### Maven
```xml
    <dependency>
      <groupId>net.pwall.yaml</groupId>
      <artifactId>yaml-base</artifactId>
      <version>0.2</version>
    </dependency>
```
### Gradle
```groovy
    testImplementation 'net.pwall.yaml:yaml-base:0.2'
```
### Gradle (kts)
```kotlin
    testImplementation("net.pwall.yaml:yaml-base:0.2")
```

Peter Wall

2020-11-05
