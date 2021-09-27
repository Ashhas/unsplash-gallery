# Unsplash Gallery

:camera: Simple gallery app with Unsplash API. Here I experiment with some Modern Android development tools & concepts - (Kotlin, MVVM, Dependecy Injection, Architecture Components)

## Screenshots
<p>
  <img src="https://github.com/Ashhas/unsplash-gallery/blob/main/screenshots/app-walkthrough.gif" width="225">
  <img src="https://github.com/Ashhas/unsplash-gallery/blob/main/screenshots/Screenshot_20210927-123721.jpg" width="225"> 
  <img src="https://github.com/Ashhas/unsplash-gallery/blob/main/screenshots/Screenshot_20210927-002703.jpg" width="225">
 </p>

## Made With 🛠
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) 
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) 
- [Dagger-Hilt](https://dagger.dev/hilt/)
- [Retrofit](https://square.github.io/retrofit/)
- [GSON Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
- [OkHttp3](https://github.com/square/okhttp)
- [Glide](https://github.com/bumptech/glide) 

## How to Build

Note that in order to access the Unsplash API, you must:

- Create a developer account at: [https://unsplash.com/developers](https://unsplash.com/developers)
- Copy your app access key

Then add it to this file `Constants.kt`:

```
const val AUTH_HEADER_KEY = "Client-ID <Access Key>"
```
