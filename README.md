# Let Trip ✈️

**Let Trip** is a modern Android travel application built with Jetpack Compose, Material 3 design, and clean architecture principles.

---

## 📱 Features

- **Animated Splash Screen**: Features an infinite pulse logo animation, loading state indicator, session validation, and retry error handling.
- **Declarative Jetpack Compose UI**: Modern reactive UI built entirely using Compose and Material 3 components.
- **Custom Navigation**: Powered by Jetpack Navigation Compose (`AppNavHost`) with type-safe route management.
- **Reusable UI Components**: Includes custom components like `ToolAppBar` with support for left/right action icons, badge counters, and scroll behaviors.
- **Dynamic Theming**: Full support for Dark & Light modes with dynamic color adaptation on Android 12+.
- **Localization Ready**: Configured for multi-language support (English, Khmer).

---

## 🛠️ Tech Stack & Architecture

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) & [Material 3](https://developer.android.com/jetpack/compose/designsystems/material3)
- **Architecture**: MVP (Model-View-Presenter) with State-driven UI (`SplashContract`, `SplashPresenter`, `SplashUiState`)
- **Navigation**: [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- **Concurrency**: Kotlin Coroutines (`async`, `launch`, `SupervisorJob`)
- **System APIs**: [AndroidX Core Splashscreen](https://developer.android.com/develop/ui/views/launch/splash-screen)
- **Build System**: Gradle Kotlin DSL (`.gradle.kts`) with Version Catalog (`libs.versions.toml`)

---

## 📁 Project Structure

```
app/src/main/java/com/example/lettrip/
├── common/
│   └── component/
│       └── ToolAppBar.kt      # Reusable Top App Bar component
├── data/
│   └── SessionRepository.kt   # Repository interface & mock implementations
├── home/
│   └── HomeScreen.kt          # Home screen UI
├── navigation/
│   ├── AppNavHost.kt          # Main Navigation Host graph
│   └── Route.kt               # Route constants
├── splashscreen/
│   ├── SplashContract.kt      # MVP View/Presenter interfaces
│   ├── SplashPresenter.kt     # Splash logic and session verification
│   ├── SplashRoute.kt         # Compose state holder & view wiring
│   ├── SplashScreen.kt        # UI representation for Splash
│   └── SplashUiState.kt       # Sealed UI state models
├── ui/
│   └── theme/
│       ├── Color.kt           # Color definitions
│       ├── Theme.kt           # Material 3 LetTripTheme setup
│       └── Type.kt            # Typography configurations
└── MainActivity.kt            # App entry point Activity
```

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Ladybug (2024.2.1) or newer recommended
- **JDK**: Java 11 or higher
- **Minimum SDK**: 33 (Android 13)
- **Target SDK**: 37

### Build & Run

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd "Let Trip Project"
   ```

2. **Open in Android Studio**:
   Open the project directory in Android Studio and let Gradle sync.

3. **Build the Debug APK**:
   ```bash
   ./gradlew :app:assembleDebug
   ```

4. **Run Unit Tests**:
   ```bash
   ./gradlew :app:testDebugUnitTest
   ```

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
