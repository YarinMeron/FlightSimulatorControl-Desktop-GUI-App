
FlightSimulatorControl

In this project we created  a JavaFX Desktop Application made for Advanced Software Development course at the College of Management Academic Studies. conducted by Dr. Eliahu Khalastchi.

Project goal is to build a desktop application that connecting to FlightGear flight simulator and gets all the flight data and writing back to FlightGear server with our custom script language.



![alt text](https://github.com/YarinMeron/FlightSimulatorControl-GUI/issues/2#issue-791844225)








Server-
In this section we designed generic server that can be reuse in other applications.





We used the Bridge Design patten  to separate between the objects that solve the problems and the objects that represents the problems. 


Client  -
In this section we implemented MVVM design. The mvvm design patten that facilitates the separation of the development of the interface (the view) – be it via a markup language or GUI code – from the development of the business logic or back end logic.

Model – Responsible for our business logic, such as algorithms and data access.
View Model – It passes commands from the View to the Model, and its purpose is to separate the View from the Model.
Data Binding – Implemented by Observer & Observable design patten. 


































