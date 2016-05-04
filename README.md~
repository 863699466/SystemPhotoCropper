# System-Photo-Cropper
Android System Photo Cropper
使用系统原生的剪裁库，完美适配魅族等机型


### Step 1

First you need a ``sysPhotoCropper`` to handle the activity results of cropping photos.

```java
 @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        sysPhotoCropper.handlerOnActivtyResult(requestCode, resultCode, data);
    }
```



### Step 2

Make sure you implemented these methods:

```java
 sysPhotoCropper = new SysPhotoCropper(this, new PhotoCropCallBack() {
            @Override
            public void onFailed(String message) {
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPhotoCropped(Uri uri) {
                ivResult.setImageURI(null);
                ivResult.setImageURI(uri);
            }
        });
```


### Step 3

Launch a request to crop photos.

#### Crop from camera

```java
sysPhotoCropper.cropForCamera();
```

#### Crop from gallery

```java
sysPhotoCropper.cropForGallery();
```
