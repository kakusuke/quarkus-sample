plugins {
    java
    id("io.quarkus")
    id("org.seasar.doma.compile") version "1.1.0"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    val domaVersion: String by project
    val quarkusVersion: String by project
    val domaQuarkusVersion: String by project
    annotationProcessor("org.seasar.doma:doma-processor:$domaVersion")
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:${quarkusVersion}"))
    implementation("io.quarkus:quarkus-jdbc-postgresql:${quarkusVersion}")
    implementation("io.quarkus:quarkus-resteasy:${quarkusVersion}")
    implementation("io.quarkus:quarkus-resteasy-jsonb:${quarkusVersion}")
    implementation("org.seasar.doma:doma-core:$domaVersion")
    implementation("org.seasar.doma:doma-quarkus-deployment:$domaQuarkusVersion")
    testImplementation("io.quarkus:quarkus-junit5:${quarkusVersion}")
    testImplementation("io.rest-assured:rest-assured:4.3.1")
}

tasks {
    val encoding = "UTF-8"
    
    compileJava {
        options.encoding = encoding
        options.compilerArgs.add("-parameters")
    }

    compileTestJava {
        options.encoding = encoding
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
