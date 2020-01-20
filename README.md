# testng-gradle-example

A sample Gradle project to run TestNG tests with different command line args

### Usage

#####Look into testsetup.gradle file custom tasks for more info.
  
- a. Using gradle java exec plugin 
   ```
   ./gradlew -PmainClass=com.ritchiebros.k8s.KubernetesClusterCheck clean execute
   ```
- b. Using gradle testExec custom task built on java exec plugin as a custom wrapper to TestNG cli options. 
   ```
   ./gradlew clean testExec
   ./gradlew clean testExec -Pgroups=main # run tests from src/main/java folder
   ./gradlew clean testExec -Pgroups=test # run tests from src/test/java folder
   ./gradlew clean testExec -Pgroups=unit # run unit tests
   ./gradlew clean testExec -Pgroups=unit,int # run tests from multiple groups
   ./gradlew clean testExec -PdefaultListeners # run tests without custom listener setup
   ./gradlew clean testExec -Denv=test # run tests against specific test env
   ./gradlew clean testExec -Psuites=smoke.xml # run tests with specific xml
   ./gradlew clean testExec -Psuites=regression.xml,smoke.xml # run tests with multiple xml 
   ./gradlew clean testExec -Pthreads=5 # run parallel test methods with specified thread count
   ./gradlew clean testExec -Pthreads=3 -Pparallel=classes # run parallel test classes with set of threads 
   ./gradlew clean testExec -Denv=test -Pthreads=5 -Pgroups=main -Psuite=smoke.xml # run tests using multiple cli options

   # run a single specific test class
   ./gradlew clean testExec -Ptestclasses=com.features.demo.FeatureCTest
   
   # run multiple specific test classes
   ./gradlew clean testExec \
    -Ptestclasses=ccom.features.demo.FeatureCTest,com.features.demo.FeatureATest
   
   # run single test method
   ./gradlew clean testExec \
    -Ptestmethods=com.features.demo.FeatureCTest.testC1
   
   # run multiple test methods
   ./gradlew clean testExec \
   -Ptestmethods=com.features.demo.FeatureCTest.testC1,com.features.demo.FeatureATest.testA2

   # run tests from listed xml classes with only specified test groups
   ./gradlew clean testExec -Psuites=regression.xml -Pgroups=main
   
   # run tests from listed xml classes with only specified parallel tests collection with specified thread count
   ./gradlew clean testExec -Psuites=regression.xml -Pthreads=2 -Pparallel=tests   
   ```
- c. Using testRun custom task built on gradle test plugin as a custom wrapper to run testNG tests
   ```
   ./gradlew clean testRun --tests com.features.demo.FeatureCTest
   ```
- d. Using testGroups custom task built on gradle test plugin as a custom wrapper to run testNG groups based tests
   ```
   ./gradlew testGroups -Pgroups=main
   ./gradlew testGroups -Pgroups=main,unit,int
   ```
