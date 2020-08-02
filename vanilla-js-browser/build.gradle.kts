plugins {
  kotlin("js") version "1.3.72"
}

group = "com.developerlife"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-js"))
  testImplementation(kotlin("test-js"))
}

// Add npm deps: https://kotlinlang.org/docs/reference/js-project-setup.html#npm-dependencies

kotlin.target.browser {
  // Test on multiple browsers other than Chrome using: https://kotlinlang.org/docs/reference/js-project-setup.html#configuring-test-task
  // testTask { useKarma { useSafari() } }
}