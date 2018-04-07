TO DO list for this TO DO Project LOL

<b>MUST use Model View Controller Design Pattern</b>
  
<b><u>Classes to Implement</u></b>
  
<i>Please add 3 x's to the classes implemented, we can use this as a checklist </i>
  
<b>Model View Controller Classes</b>

  <i>Required</i>
  
   1. TaskBoardModel ---
   2. ProjectModel ---
   3. TaskModel ---
   
   <i>Suggested by Vidya</i>
   
   4. TaskModelComparator ---
   5. TaskModelListener (ProjectModels would implement this) ---
   
   <b>View Classes</b>
   
   6. LoginView ---
   7. MainScreen ---
   8. TaskView ---
   9. ProjectView ---
   10. File Saving//Loading ---
        - serialization feautre 
   
   11. Class Diagrams ---
   12. Sequence Diagrams ---


<b>Requirements for this Project</b>
 1. Be able to:
    1. Create a new project
       - Will contain multiple tasks for each project
    2. Create a new task
       - Automatically put in the TO DO
    3. Edit task
       - In Progress, Review, Done "boxes"
    4. Load a saved taskboard. 
       - Also have a backlog of everything, I'm assuming is a collection of all the tasks within the project, we can have a button that goes to the log itself

<b>Tasks</b>
 1. Name should be bolded
 2. Description
 3. Due Date
    - We should have a page fold icon on tabs with no due dates so the user could click and add one if there was no due date
 4. Current Status
      - Being in the columns should be the current status, but we could have a view of all the tasks with them being color coded and a legend of all the statuses
      - There could be different sortings too, like from date created, date due, or categorized by setting with to do tasks all at top to done tasks sorted last
          - She requires that when sorting from due date, the tasks without due dates will be at the bottom
 5. Color coded to category, maybe different shades of color would indicate which was more important
      - The darker the color, the more important, can only go up to 3 shades to make colors stand out more
         - We can also sort through these
      - Gold can be done beacause they're WINNERS
        
<b>Login Page</b>
 1. We can make a logo for our whole project and make it appear on this
 2. We should have a create account button too and just route it to go to another page that allows users to sign up with their email
 3. Also adding a forgot password would be cool too
 4. Also if they want to sync their to do list or join an existing one, we should allow that option but idk if we'd need to figure out how to make everything synced.
        - If we wanted to allow a setting where people could sign into a "workspace" with other people, we could have two options after they login, a button for their personal projects, workspaces they're a part of, and adding a workspace that would send an invite to the other workspace> 
              - Also this would be too much work but just throwing out ideas
        
<b>Creating New Project/Task (After the Login page)</b>
 1. After the login, Vidya requires use to have a create project, so we can have some buttons for create project and like a list view of all the other projects they have.
   - If there's a task or project thats same, tell the user there is already one but still be able to allow them to make duplicates
 
<b>Main Screen</b>
<b>Columns</b>
 1. Backlog, TO DO, In Progress, Review, Done
     - Should backlog be a button where you press and a column sort of pops from the left of the screen?
     - Vidya requires we have a + button for creating a new task in that section, and then also on the dashboard too, but that would be a general create new button for project or task
   
<b>Editing a Task</b>
 1. Vidya requires being able to edit the name, description, status, and due date
 2. She also requires the button say "Edit" while the title of the pop up should be "Edit Task"
      - I feel like she'll look for the small requirements she states in the homework and dock off points accordingly
 3. We can add a level of importance edit that would make the color darks as its more important
  
<b>Saving/Loadng a Taskboard</b>
 1. Vidya requires saving a taskboard and asking the user for a filename and saving it
      - We should prompt a question for creating a folder for the TO DO list app to place all the taskboards in
 2. We also need to load the taskboard by asking the user for the filename
  
 <b>Additional Functionality</b>
  1. I already detailed the background color one so if we use that we'll fullfill the requirement for at least one
  2. This wasn't listed, but I also detailed the importance one
  3. We could add more from the list if we have time, the date picker one sounds cool too
  
