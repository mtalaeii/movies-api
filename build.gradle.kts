// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (GradleDependencies.build_tools)
        classpath (GradleDependencies.kotlin_gradle_plugin)
        classpath(GradleDependencies.app_metrica)
        classpath(GradleDependencies.navigation_safe_args)
//        classpath(GradleDependencies.hilt_navigation_fragment)
//        classpath(GradleDependencies.gradleDep)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
tasks.register("clean").configure {
    delete("build")
}