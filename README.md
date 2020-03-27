# CustomProgressbar
## Solid/stroke circular progressbar
[![](https://jitpack.io/v/miladsalimiiii/CustomProgressbar.svg)](https://jitpack.io/#miladsalimiiii/CustomProgressbar)
### Preview
![20200327_022657](https://user-images.githubusercontent.com/31917346/77782904-9dd9c280-7075-11ea-9662-2b37e98394cf.gif),![20200327_023006](https://user-images.githubusercontent.com/31917346/77783022-cc579d80-7075-11ea-8180-0cd3bc9c9b6e.gif)
![20200327_023306](https://user-images.githubusercontent.com/31917346/77783154-00cb5980-7076-11ea-8acf-333119bafdf1.png),![20200327_023352](https://user-images.githubusercontent.com/31917346/77783237-1c366480-7076-11ea-8d3a-dc30a943b6b4.png)
### Dependency

### Step 1
Add the JitPack repository to your build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
        
```
### Step 2
Add the dependency on module build.gradle:
```
	dependencies {
	        implementation 'com.github.miladsalimiiii:CustomProgressbar:Tag'
	}
```        

### Quickstart

```
    <com.milad.customprogressbar.SolidCircularProgressbar
        android:id="@+id/progressbar_main_solid"
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:color="@color/colorAccent"
        app:timeInterval="30000"/>
```
In default we have fill progressbar , if you want to use stroke use ``` app:isStroke="true"```.

Pay attention time unit is miliSecond.

Happy Coding . . .
