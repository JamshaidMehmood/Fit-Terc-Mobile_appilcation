
# jamshaid_s_application7

Built with AndroidX Support

Requires Android Studio Arctic Fox | 2020.3.1 or higher.

Current Kotlin Version 1.7.20


### SDK Versions

compileSdkVersion 33

buildToolsVersion "30.0.3"

minSdkVersion 23

targetSdkVersion 33


### Libraries

1. Retrofit- REST API Call
https://square.github.io/retrofit/
2. Glide - Image Loading and caching.
https://github.com/bumptech/glide
3. Material Design Components - Google's latest Material Components.
https://material.io/develop/android
4. koin - Dependency Injection
https://insert-koin.io/

### Figma design guideline for better accuracy

Read our guidelines to increase the accuracy of design conversion to code by optimizing Figma designs. 
https://docs.dhiwise.com/docs/Designguidelines/intro .

### App Navigation

Check your app\'s UI from the AppNavigation screens of your app.

### Package Structure


```
├── appcomponents       
│ ├── di                 - Dependency Injection Components 
│ │ └── MyApp.kt
│ ├── network            - REST API Call setup
│ │ ├── ResponseCode.kt
│ │ └── RetrofitProvider.kt
│ └── ui                 - Data Binding Utilities
│     └── CustomBindingAdapter.kt
├── constants            - Constant Files
│ ├── IntegerConstants.kt
│ └── StringConstants.kt
├── extensions           - Kotlin Extension Function Files
│ └── Strings.kt
├── modules              - Application Specific code
│ └── example            - A module of Application 
│  ├── ui                - UI handling classes
│  └── data              - Data Handling classes
│    ├── viewmodel       - ViewModels for the UI
│    └── model           - Model for the UI
└── network              - REST API setup
  ├── models             - Request/Response Models
  ├── repository         - Network repository
  ├── resources          - Common classes for API
  └── RetrofitService.kt
```
### Fonts
We were unable to find following Fonts, Please add manually to ```app/src/main/res/font``` and uncomment code in respective font family XML files.

```
circularstdmedium
circularstdbold
circularstdbook
proximanovasemibold
```

NOTE:
to use this application work properly the jango server must be on 
i have a separate repository for that purpose named CRUD server for Fit Terc having link 
https://github.com/JamshaidMehmood/CRUD_SERVER-for-Fit-Terc
also one more thing you first have to ipconfig you ip address on cmd and the IPV4 you get by this action should be addef to settings.py in server side and also in eveery where in 
the activity classes where the retrofit api is called. 