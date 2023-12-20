plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "com.tomaszz"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("com.tomaszz.DayOfMonthExpressionKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.tomaszz.DayOfMonthExpressionKt"
    }

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // Setting the destination directory to the project root folder
    destinationDirectory.set(file("$projectDir"))
}
