plugins {
    id("java")
}

group = "ru.serj.learn"
version = "1.0"

repositories {
    mavenLocal()
    maven {
        url = uri("/home/serg/.m2/repository")
    }
    mavenCentral()
}


dependencies {
    implementation("ru.serj.learn:learn-dependency-inversion-core:1.2")
}

