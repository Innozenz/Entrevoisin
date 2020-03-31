# Entrevoisins
Project 3 Openclassroom

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need Android Studio, about version built see on section "Built With" on Readme file below

On Manifest xml :

    <uses-permission android:name="android.permission.INTERNET" />

About dependencies :

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'com.android.support:recyclerview-v7:28.0.0'


    implementation 'com.jakewharton:butterknife:9.0.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0'

    implementation 'com.github.bumptech.glide:glide:4.9.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'

    // EVENT BUS
    implementation 'org.greenrobot:eventbus:3.1.1'

    // UNIT TEST
    testImplementation 'junit:junit:4.12'
    testImplementation 'org.hamcrest:java-hamcrest:2.0.0.0'
    // INSTRUMENTATION TEST
    androidTestImplementation 'com.android.support.test:rules:1.0.2'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-contrib:3.0.2'


### Installing

you have to use Android Studio to run this application.

copy this link --> https://github.com/Innozenz/Entrevoisin

Open Android Studio
file -> new --> Project from Version Control
Paste the link you copied on the appear windows, on first line
test if it is ok (click on test button at right to ensure that is successful)
you only have to do "next" button on each window, and at the end click on "done" to finish the process.

After that, make sure you are on "app", 
choose your AVD manager device or choose your external device link with your computer
and click on "Run"

On the application, you can see the different persons names on neighbours page, you can scroll it.
When you click on one of this item, a new windows will open, you have more informations about the person. 
You can choose if you want to have this neighbour name on your favorite, you have to just click on the star 
below the image of the person, the star pass to yellow color.
After that, when you go to the favorite page, you can see that you have the neighbour that 
you chose. 
On each page, if you want to delete the neighbours or the favorite, you have to click on the delete button
at the end of each item.


## Running the tests

Have a look on folder for Html test result: P3_01_rapports\html_test_result, contains the Tests Results on Html Version

About the note on pdf file name "note de cadrage.pdf" : "Développez une nouvelle fonctionnalité pour l’application Entrevoisins Note de cadrage.pdf"

            - Phase 1 : Functionality Development as the picture
            
                            Have a look on : 
                                               - Detail.java Activity, with the layout :  activity_details.xml
                            
            - Phase 2 : Make 4 tests of Instrumented Unit Tests
            
                            Have a look on : 
                                               - Package com.openclassrooms.entrevoisins, and on folder ui.neighbour_list : ListNeighbourActivityTest.java
                                               - Package com.openclassroom.entrevoisins, folder neighbour_list : NeighboursListTest.java
                            
            - Phase 3 : Make local Unit Test for each function
            
                            Have a look on : 
                                               - Package com.openclassrooms.entrevoisins.service : NeighbourServiceTest.java

   #For Android Test :
 
 For the file NeighboursListTest.java :
 
 go to folder : Java/com.openclassrooms.entrevoisins/neighbours_list and open "NeighboursListTest.java",
on the left side of "public class NeighboursListTest()" click on the double arrow green button to run all the tests.

  For the file : ListNeighbourActivityTest.java :
  
  go to folder : Java/com.openclassrooms.entrevoisins/ui.neighbour_list and open "ListNeighbourActivityTest.java",
  on the left side of "public class MyNeighbourRecyclerViewAdapterTest" click on the both green button to run all the tests.
  
   #For Local Unit Test :
   
   For the file NeighboursServiceTest.java :
   
   go to folder : Java/com.openclassrooms.entrevoisins.service and open "NeighbourServiceTest",
   on the left side of "public class NeighbourServiceTest" click on the arrow green button to run all the tests. 


### Break down into end to end tests, and coding style tests

To understand the test, an example :

@Test
    public void deleteComplete_Phase2_Number3(){}
    
    You just have to read to understand what the test does. 
    And the information at the end is :"Phase2_Number3" means this is the test asked 
    on page 5 of the pdf file from OpenClassrom (file name "note de cadrage"), this is the third test from phase 2.


## Deployment

Run on Microsoft Windows, sure it will be done on other system too.

## Built With

* [Android Studio Ver 3.5](https://developer.android.com/studio/) - To download the software

## Contributing

Nobody for the moment, coming soon...;-))

## Versioning

I only use Github for the moment for versioning, nothing else

## Authors

* **Maxime Fitzjean** - *Training work* - [Innozenz](https://github.com/Innozenz/Entrevoisin.git)

* **Openclassroom**


