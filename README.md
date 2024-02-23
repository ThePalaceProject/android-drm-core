android-drm-core
=====================

[![Build Status](https://img.shields.io/github/actions/workflow/status/ThePalaceProject/android-drm-core/android-main.yml)](https://github.com/ThePalaceProject/android-drm-core/blob/main/.github/workflows/android-main.yml)
[![Maven Central](https://img.shields.io/maven-central/v/org.thepalaceproject.drm/org.thepalaceproject.drm.core?style=flat-square)](https://repo1.maven.org/maven2/org/thepalaceproject/r2/)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/https/s01.oss.sonatype.org/org.thepalaceproject.drm/org.thepalaceproject.drm.core.svg?style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/org/thepalaceproject/drm/org.thepalaceproject.drm.core/)

![drm](./src/site/resources/drm.jpg?raw=true)

### Usage

Add a dependency on the core API:

```
implementation "org.thepalaceproject.drm:org.thepalaceproject.drm.core:2.0.0"
```

### Compilation

Make sure you clone this repository with `git clone --recursive`. 
If you forgot to use `--recursive`, then execute:

```
$ git submodule init
$ git submodule update --remote --recursive
```

1. Ensure that the location of your Android SDK is specified in `local.properties`.
   For example:

```
$ cat local.properties
sdk.dir=/path/to/android-sdk
```

2. Build the code:

```
$ ./gradlew clean assemble test
```

3. Optionally publish the code to your local Maven repository:

```
$ ./gradlew clean assemble test publishToMavenLocal
```

### Project Structure

|Module|Description|
|------|-----------|
| [org.thepalaceproject.drm.core](https://github.com/ThePalaceProject/android-drm-core/tree/develop/org.thepalaceproject.drm.core) | Core API
| [org.thepalaceproject.drm.core.tests](https://github.com/ThePalaceProject/android-drm-core/tree/develop/org.thepalaceproject.drm.core.tests) | Unit tests

### License

```
© 2015 The New York Public Library, Astor, Lenox, and Tilden Foundations

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing
permissions and limitations under the License.
```
