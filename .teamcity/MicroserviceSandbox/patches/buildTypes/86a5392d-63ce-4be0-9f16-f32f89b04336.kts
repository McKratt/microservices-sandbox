package MicroserviceSandbox.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '86a5392d-63ce-4be0-9f16-f32f89b04336' (id = 'MicroserviceSandbox_Build')
accordingly and delete the patch script.
*/
changeBuildType("86a5392d-63ce-4be0-9f16-f32f89b04336") {
    expectSteps {
        maven {
            name = "clean verify"
            goals = "clean verify"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18_x64%"
            coverageEngine = jacoco {
                classLocations = """
                    +:**/target/classes/**
                    -:**/target/classes/**/*Application*
                """.trimIndent()
            }
        }
        maven {
            name = "deploy"
            goals = "install"
            runnerArgs = "-DskipTests"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18_x64%"
        }
        maven {
            name = "Mutation Coverage"
            goals = "pitmp:run"
            pomLocation = "pom.xml"
            workingDir = "case"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18_x64%"
        }
    }
    steps {
        update<MavenBuildStep>(2) {
            pomLocation = "case/pom.xml"
        }
    }
}
