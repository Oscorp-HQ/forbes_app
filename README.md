# Forbes App

A native Android application that replicates the Forbes news app interface with mock data. The app features breaking news, latest stories, and magazine sections with a modern UI design.

## Features

- Breaking News horizontal scrollable section
- Latest Stories section
- Magazine section
- Clean MVVM architecture
- Mock data repository
- Appium test support with test IDs

## Setup

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

## Testing

The app includes Appium tests that can be run using the following steps:

1. Start the Appium server:
```bash
appium
```

2. Run the tests:
```bash
./gradlew connectedAndroidTest
```

## Architecture

The app follows MVVM architecture pattern:

- **Model**: Data classes and repository
- **View**: Activities and adapters
- **ViewModel**: Manages UI state and business logic

## Dependencies

- AndroidX Core KTX
- AndroidX AppCompat
- Material Design Components
- Glide for image loading
- Kotlin Coroutines
- Appium for testing

## Test IDs

The app includes test IDs for UI automation:

- `breaking_news_title`: Breaking News section title
- `breaking_news_list`: Breaking News RecyclerView
- `breaking_news_item`: Individual breaking news items
- `latest_tab`: Latest tab
- `magazine_tab`: Magazine tab
- `search_button`: Search action button
- `settings_button`: Settings action button

## License

This project is for demonstration purposes only. 