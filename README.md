# Mohamed_Khalfallah_XKH11TN

Java Spring Test

This is a Spring Data Mongo project that provides a RESTful API for managing and retrieving data related to students (etudiants). 
The project is secured with JSON Web Tokens (JWT) for authentication and authorization purposes.

Prerequisites

Before running the project, make sure you have completed the following steps:


1 - Update the application.properties file:    
* Replace the placeholder <YOUR_MONGO_ATLAS_URI> with your own MongoDB Atlas URI. This URI will be used to establish a connection with the MongoDB database.
       
2 - Build the project with Maven: 
* Navigate to the project directory and Open a terminal or command prompt.
* Execute the following command to build the project: 
                
                  mvn clean install -DskipTests.
        
==> The application will start running on PORT = 2023
API Endpoints

The following are the API endpoints provided by this project:

     - Secured API to retrieve filtered student data:
       * Endpoint: http://localhost:2023/api/etudiants/retrieve-etudiants-filtered
       * Method: GET
       * Headers: Include the JWT token in the Authorization header.
       * Query Parameters:
             - page: Page number for pagination (optional)
             - size: Number of items per page (optional)
             - classe: student's class NAME (optional,STRING)
             - enseignant: teacher's FULLNAME (optional,STRING)


      - User Registration:
        * Endpoint: http://localhost:2023/api/auth/signup
        * Method: POST
        * Request Body: Include the following fields in the request body as JSON:
             - username: User's username
             - fullname: User's fullname
             - email: User's email address
             - password: User's password

    - User Login:
      * Endpoint: http://localhost:2023/api/auth/signin
      * Method: POST
      * Request Body: Include the following fields in the request body as JSON:
          - username: User's username
          - password: User's password
          => Response: The API will return a generated JWT token, which will be used for subsequent authenticated requests.

    - User Profile Details:
      * Endpoint: http://localhost:2023/api/test/profile
      * Method: GET
      * Headers: Include the JWT token in the Authorization 
          => Response: The API will return the details of the authenticated user.
        
