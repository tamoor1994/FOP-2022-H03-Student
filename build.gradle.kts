import org.sourcegrade.submitter.submit

plugins {
  java
  application
  id("com.github.johnrengelman.shadow") version "7.1.0"
  id("org.sourcegrade.submitter") version "0.4.0"
}

submit {
  assignmentId = "h03" // do not change assignmentId
  studentId = "Upper"
  firstName = "Moon"
  lastName = "1"
  // Optionally require tests for prepareSubmission task. Default is true
  requireTests = true
}

// !! Achtung !!
// Die studentId (TU-ID) ist keine Matrikelnummer
// Richtig z.B. ab12cdef
// Falsch z.B. 1234567

repositories {
  mavenCentral()
}

dependencies {
  // FOPBot available in all source sets
  implementation("org.sourcegrade:fopbot:0.3.0")
  // JUnit only available in "test" source set (./src/test)
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

application {
  mainClass.set("h03.Main")
}

tasks {
  withType<JavaCompile> {
    options.encoding = "UTF-8"
  }
  jar {
    enabled = false // only enable shadowJar
  }
  shadowJar {
    archiveFileName.set("h03-nicht-abgeben.jar")
  }
  test {
    useJUnitPlatform()
  }
}
