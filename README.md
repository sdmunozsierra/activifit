# Activifit
##Activity Tracker System
Developed on Java.  :shipit:

##Features

###Heartbeat
Measure the heartbeat of the subject according to the age and activity index.

###Steps
This feature will be generated with a random step generation along with with the age of the user and a preset value on how active the person is during the day.

###Temperature
Temperature will be affected mainly on how active is the user, and depending on the time of the day, a normal person varies in temperature about 0.5 celsius, being lower on the mornings and higher on the afternoon. This feature can identify if the user has any anomalies in the temperature such as (hypothermia, fever or hyperthermia). Information can be represented in celsius or fahrenheit degrees. 

###Sleep Quality
Sleep quality measurements are not standardized because there is not a “correct” way in how to measure it, therefore in this project we will measure sleep quality with three key states: REM, light and deep sleep. Monitoring the heart rate and body temperature, the product will be able to determinate in which state the user is. An algorithm will determine the quality.


###Share

##Software Design
###Main
The main method will be called from runMVC class which translates to Model, View, and Controller.

The purpose of the class will be to have _sensitive_ data at the topmost level which is the __Model__.

__View__ is basically the GUI which is in the _gui_package_.

__Controller__ has all the actions that the program will perform, in this project they are contained in the _action_package_.

###Packages
All custom action listeners are in the package ActionPackage.
There include actions for calling different screens and validating data.

Generators: Will provide ‘random’ but credible information about the many activities that the user is “generating”. Each generator will have their own class and will have inheritance from a main Generator which will pull the personal data of the current user (logged-in). They are included in the _user_package_ until they become large enough to be placed in their own package, most of the data is backend, thus giving the user a clean interface.

__Charts__: It is under _gui_package_ and it creates... charts!
###Resources
__Plugins (Eclipse):__ 

_eGit:_ Is used to maintain compatibility with online repositories from Github, commits and history are the main functionalities.

_e(fx)clipse:_ Because some machines do not have compatibility with JavaFX (mainly used to create charts and scenes), e(fx)clipse is a great tool that works flawlessly.
 
###Extra Information
__Current Number of Classes Per Package__

_action_package_ __21__

_chart_package_ __7__

_generator_package_ __7__

_gui_package_ __6__

_user_package_ __3__

Resources:
https://www.materialui.co/

Resources: Useful clases, and resources for the project, also some icons are included.

###Commented from Eclipse IDE
