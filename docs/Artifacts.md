# 一份用于构建的Artifacts

```
<component name="ArtifactManager">
  <artifact type="jar" build-on-make="true" name="CatPawServer">
    <output-path>$PROJECT_DIR$/../CatPawRunTime</output-path>
    <root id="archive" name="CatPawServer.jar">
      <element id="module-output" name="CatPawServer" />
      <element id="file-copy" path="$PROJECT_DIR$/src/main/resources/config.yml" />
      <element id="file-copy" path="$PROJECT_DIR$/src/main/resources/log4j2.xml" />
      <element id="directory" name="libs">
        <element id="library" level="project" name="Maven: org.yaml:snakeyaml:1.27" />
        <element id="library" level="project" name="Maven: commons-lang:commons-lang:2.6" />
        <element id="library" level="project" name="Maven: org.java-websocket:Java-WebSocket:1.5.1" />
        <element id="library" level="project" name="Maven: org.slf4j:slf4j-api:1.7.25" />
        <element id="library" level="project" name="Maven: org.apache.logging.log4j:log4j-api:2.13.3" />
        <element id="library" level="project" name="Maven: org.apache.logging.log4j:log4j-core:2.13.3" />
        <element id="library" level="project" name="Maven: org.apache.logging.log4j:log4j-web:2.13.3" />
        <element id="library" level="project" name="Maven: org.apache.logging.log4j:log4j-slf4j-impl:2.13.3" />
        <element id="library" level="project" name="Maven: org.xerial:sqlite-jdbc:3.32.3.2" />
        <element id="library" level="project" name="Maven: mysql:mysql-connector-java:5.1.49" />
        <element id="library" level="project" name="Maven: com.google.code.gson:gson:2.8.6" />
      </element>
      <element id="directory" name="data">
        <element id="file-copy" path="$PROJECT_DIR$/src/main/resources/data/catnote.db" />
      </element>
      <element id="directory" name="language">
        <element id="file-copy" path="$PROJECT_DIR$/src/main/resources/language/en_US.yml" />
        <element id="file-copy" path="$PROJECT_DIR$/src/main/resources/language/zh_CN.yml" />
      </element>
    </root>
  </artifact>
</component>
```

