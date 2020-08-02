# gradle-kotlin-js-browser

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Vanilla JS apps in Kotlin (no React)](#vanilla-js-apps-in-kotlin-no-react)
- [Information from the JetBrains language guide](#information-from-the-jetbrains-language-guide)
- [Information from the JetBrains tutorials](#information-from-the-jetbrains-tutorials)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## 🔥🔥🔥 Next steps 🔥🔥🔥

Complete all the steps in the left sidebar of the
[tutorials section](https://kotlinlang.org/docs/tutorials/javascript/dev-server-continuous-compilation.html)

1. [ ] Using npm packages
2. [ ] Debugging Kotlin in the browser
3. [ ] Running tests
4. [ ] Using the browser API & DOM
5. [ ] Use the typesafe HTML DSL

Then,

1. [ ] Watch the [KotlinConf JS video](https://www.youtube.com/watch?v=L4DRD9eWKXo)
   - Here's the [github repo](https://github.com/kotlin-hands-on/web-app-react-kotlin-js-gradle) for it
2. [ ] Complete this codelab
       [Building Web Applications with React and Kotlin/JS](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)
3. [ ] Complete this codelab
       [Building a Full Stack Web App with Kotlin Multiplatform ](https://play.kotlinlang.org/hands-on/Full%20Stack%20Web%20App%20with%20Kotlin%20Multiplatform/01_Introduction?_ga=2.164377407.1871836875.1596324376-857316911.1593315987)

## Vanilla JS apps in Kotlin (no React)

This project is an exploration of using Kotlin to write vanilla JS browser apps. This does not use React or any other
framework. It was build using IDEA itself, following this JetBrains language guide on
[how to setup a Kotlin/JS project in IDEA](https://kotlinlang.org/docs/reference/js-project-setup.html#configuring-test-task).
Basically by using: "File -> New -> Gradle > Kotlin/JS for browser (uncheck Java)"

Here are some notes on my journey to creating this project.

1. I used the Kotlin DSL for build.gradle, instead of Groovy, and currently (as of IDEA 2020.2) this does not setup the
   empty project correctly. So I had to do it in Groovy and then copy the stuff back into this project.
2. The JetBrains tutorials section is really good, and so are the codelabs. The Language Guide section is good for
   reference but not good for how to guides, or getting started in the first place.
3. I created some run configuration targets to make it easy to run the devserver w/ hot reload, build, and clean w/
   gradle.

## Information from the JetBrains tutorials

1. [Kotlin Tutorial for JavaScript](https://kotlinlang.org/docs/tutorials/javascript/setting-up.html)
2. [Great Kotlin & React Tutorial for JavaScript](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/02_Setting_up)
   - [GitHub Repo for getting started](https://github.com/kotlin-hands-on/web-app-react-kotlin-js-gradle/tree/master)

## Information from the JetBrains language guide

[Kotlin Language Guide for JavaScript](https://kotlinlang.org/docs/reference/js-project-setup.html)

- The entire project is managed using gradle. There are tasks which end up orchestrating what webpack, Karma, npm, etc.
  are all doing! JetBrains wrapped all this stuff into gradle tasks for central management in `build.gradle.kts`.
- [Loading npm deps using `build.gradle.kts`](https://kotlinlang.org/docs/reference/js-project-setup.html#npm-dependencies)
- [Calling JS code from Kotlin](https://kotlinlang.org/docs/reference/js-interop.html)
- To run webpack dev server use:
  - `./gradlew run --continuous` - start webpack dev server (w/ hot reloading)
  - `./gradlew run` - start webpack dev server
- [Testing w/ Karma](https://kotlinlang.org/docs/reference/js-project-setup.html#configuring-test-task)
  - JS testing is enabled out of the box using Karma
  - To run tests use `./gradlew check`
- [Configure webpack bundling](https://kotlinlang.org/docs/reference/js-project-setup.html#configuring-webpack-bundling)
  - To change these settings, use `kotlin.target.browser.webpackTask` in `build.gradle.kts` file
  - For more drastic settings configuration, create a `webpack.config.d` folder in the root of the project, and you can
    add `.js` files to add these webpack settings.
  - Here are some commands to generate webpack artifacts manually:
    - `./gradlew browserDevelopmentWebpack` - generates development artifacts
    - `./gradlew browserProductionWebpack` - generates production artifacts
- [Distribution target directory](https://kotlinlang.org/docs/reference/js-project-setup.html#distribution-target-directory)
  - By default these are in `/build/distribution` folder under project root.
  - You can change it using the `kotlin.target.browser` rule in `build.gradle.kts`.
