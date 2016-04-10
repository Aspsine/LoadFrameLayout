# LoadFrameLayout
Android loading FrameLayout

### Demo
[Download](https://github.com/Aspsine/LoadFrameLayout/blob/master/art/demo.apk?raw=true)

### ScreenShot
![screen shot](https://github.com/Aspsine/LoadFrameLayout/blob/master/art/screenshot.gif?raw=true)

### How to use
Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Step 2. Add the dependency
```groovy
dependencies {
  compile 'com.github.Aspsine:LoadFrameLayout:-SNAPSHOT'
}
```
Step 3. Coding
```xml
<com.aspsine.loadframelayout.LoadFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/loadFrameLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:emptyView="@layout/layout_empty"
    app:errorView="@layout/layout_error"
    app:loadingView="@layout/layout_loading">

    <Your content view/>

</com.aspsine.loadframelayout.LoadFrameLayout>
```
```java
LoadFrameLayout loadFrameLayout = (LoadFrameLayout) findViewById(R.id.loadFrameLayout);

// show loading
loadFrameLayout.showLoadingView();

// show empty
loadFrameLayout.showEmptyView();

// show error
loadFrameLayout.showErrorView();

// show content
loadFrameLayout.showContentView();
```

### License

    Copyright 2016 Aspsine. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
