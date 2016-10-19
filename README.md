# Activifit GUI
This is a prototype of the GUI that the final version will consider. 

This project now has more than GUI so it has to be moved to either another branch or merge to master when applicable.

###Main
The main method will be called from runMVC class which translates to Model, View, and Controller.

The purpose of the class will be to have _sensitive_ data at the topmost level which is the __Model__.

__View__ is basically the GUI which is in the _gui_package_.

__Controller__ has all the actions that the program will perform, in this project they are contained in the _action_package_.

###Packages
All custom action listeners are in the package ActionPackage.
There include actions for calling different screens and validating data.

Generators: Will provide ‘random’ but credible information about the many activities that the user is “generating”. Each generator will have their own class and will have inheritance from a main Generator which will pull the personal data of the current user (logged-in). They are included in the _user_package_ until they become large enough to be placed in their own package, most of the data is backend, thus giving the user a clean interface.


Resources:
https://www.materialui.co/

###Commented from Eclipse IDE
