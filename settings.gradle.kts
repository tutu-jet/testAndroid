pluginManagement {
    repositories {
        maven(url = "https://maven.aliyun.com/repository/central") {
            isAllowInsecureProtocol = true
        }
        maven(url = "https://maven.aliyun.com/repository/public") {
            isAllowInsecureProtocol = true
        }
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin") {
            isAllowInsecureProtocol = true
        }
        maven(url = "https://maven.aliyun.com/repository/apache-snapshots") {
            isAllowInsecureProtocol = true
        }
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://www.jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "testAndroid"
include(":app")
 