# robot-apocalypse
This is a REST API developed for my Screening Assignment for the position of a Sr Java Developer. It is a Java Webservice that exposes EJB Local Interfaces as REST end points.
Download and extract the project zip file to your netbean project folder. Open it as a project from you Netbeans. Make sure you have created the database "apocalypse" in your MySql Server. The project was deployed for Glassfish Server 4.1 as the Web server. Also create jdbc/Apocalypse_Datasource on the Glassfish server.
# The resource URI are as follows:
<div>
            <h3>To add a survivor to database</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/add</p>
        </div>
        <div>
            <h3>To update a survivor's last location:</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/{id}/location</p>
        </div>
        <div>
            <h3>To flag a survivor as infected:</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/{id}?infected=true</p>
        </div>
        <div>
            <h3>To search survivors:</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/search</p>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/search/{id}</p>
        </div>
        <div>
            <h3>Get a list of robots from CPU:</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/robots/search</p>
        </div>
        <div>
            <h3>To get a report:</h3>
            <p>http://localhost:8080/ApocalypseWebservice/apocalypse/survivors/report</p>
        </div>
