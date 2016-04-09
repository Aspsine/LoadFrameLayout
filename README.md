# LoadFrameLayout
Android loading FrameLayout

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
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/loadFrameLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:emptyView="@layout/layout_empty"
    app:errorView="@layout/layout_error"
    app:loadingView="@layout/layout_loading"
    tools:context=".apps.AppsActivity">

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
