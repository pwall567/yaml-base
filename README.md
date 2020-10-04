# yaml-base

Base classes for YAML implementation.

The specification of YAML is contained in a document entitled
[YAML Ain't Markup Language (YAML&trade;) Version 1.2](https://yaml.org/spec/1.2/spec.html), and that document (in
[&sect;1.3. Relation to JSON](https://yaml.org/spec/1.2/spec.html#id2759572)) states "YAML can &hellip; be viewed as a
natural superset of JSON".
Accordingly, each of the classes in this library derives from the equivalent class in the
[`jsonutil`](https://github.com/pwall567/jsonutil) library (and that library is a transitive dependency of this one).
A tree of `YAMLNode` objects can therefore be navigated as if it were a tree of `JSONValue`.

## Dependency Specification

The latest version of the library is 0.1, and it may be obtained from the Maven Central repository.

### Maven
```xml
    <dependency>
      <groupId>net.pwall.yaml</groupId>
      <artifactId>yaml-base</artifactId>
      <version>0.1</version>
    </dependency>
```
### Gradle
```groovy
    testImplementation 'net.pwall.yaml:yaml-base:0.1'
```
### Gradle (kts)
```kotlin
    testImplementation("net.pwall.yaml:yaml-base:0.1")
```

Peter Wall

2020-10-04
