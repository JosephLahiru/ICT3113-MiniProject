# ICT3113-MiniProject
ICT3113 – Advanced programming in Java Mini Project

## General Requirements
  - There are two 02 kind of users for the system
    - Admin – 0nly 01 admin
    - User – Multiple users
  - Your application must allow users to
    - Create accounts by providing
      - Email, Username, Password, Nick Name, Profile Picture
    - Update only their Username, Password, Nick Name, Profile Picture
    - Self-subscribe to chats
    - Self-unsubscribe from chats
  - Your application must allow Admin to
    - Create chats
    - Subscribe users to chats
    - Unsubscribe users to chats
    - Remove users from the application
  - Chat System functionalities
    - When a chat starts by the Admin you must notify it to the subscribed users who have
currently log in to the application and who have subscribed for the chat
    - At the beginning of the chat you must display
      - Chat started at : <time>
    - Only subscribed users can chat in the chat
    - During the chat user profile and Nick Name of the user must be displayed
    - When users are joining to the chat you must display that in the chat as follows
      - "<user’s Nick Name>" has joined : <time>
    - By typing "Bye" users can leave the chat, when users are leaving from the chat you must
display that in the chat as follows
      - "<user’s Nick Name>" left : <time>
