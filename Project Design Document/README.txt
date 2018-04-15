011935326 (Melesse, Alemnew)
011199630 (Shira, Gurdev)
011195639 (Finer, Zackary)

Instructions:
1. Please find the relevant sequence diagrams in the folder titled "Sequence Diagrams" in the same directory this readme file is located in.
These files are labled according to what process they portray (i.e. the sequence diagram for loading a task board will be titled "Load Task Board.jpg").

2. Please find the relevant class diagrams in the folder titled "Class Diagrams" in the same directory this readme file is located in. The main class
which contains all classes and how they relate to each other is tittled "Main Class Diagram". Other Diagrams show relationships between different classes
according to context (i.e. "Project Class Diagram" will display all classes associated with projects)

Notes:

APPLICATION DESIGN OVERVIEW

An MVC (Model-View-Controller) design pattern will be employed in order to streamline flow of data between UI elements and associated model classes
(tasks,projects,boards .etc). An interface for views will be created to reduce duplicate code for the controller classes. For the sake of intuitiveness
we decided as a group to create seperate classes for the view and controller. We also did this because it is likely that having both GUI and controller
code in the same files will reduce code readibility in the long run. TaskBoardModel (and possibly project model, although we have not decided yet)
will be a serializable class. This will serve as the primary mechanism for file loading and saving.

The main screen will serve as the window which contains all views whenever they are selected. It will contain a few buttons associated with saving/loading
taskboards from file. It will also contain buttons for selecting projects in the currently loaded taskboard. On start up however, the main screen
will contain only the login view.

The GUI library we will be using for this project is swing. This was selected because we felt it was the library we had the most experience using. Project view
will be responsible for displaying the project currently selected in the main view. It will be a type of JPanel and when displayed will be contained within
the main screen window. The project view will be responsible for both editing existing projects. It will also contain a dialog which will be used for creating
new projects in an existing taskboard.

Task View will exist as a dialog, which is opened whenver the user selects a task in the project view. This dialog will also open when the user hits
the add task button in the project view.