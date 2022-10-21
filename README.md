# Mediscreen
Project given to me by my teacher Jean-César Bazin aiming at illustrating the concept of microservices. Thus, this app contains multiple Maven microservices which all work together :
- `Mediscreen-webapp` is the web interface for CRUD actions on mock patient information and medical consultation notes.
- `Mediscreenbackend` is the MySQL back-end for all fields except notes
- `Mediscreen-notes` is the NoSQL MongoDB back-end persisting notes relating to each and every patient.
For the application to function at a basic level, it requires `backend` and `webapp` containers, along with a (optionally also containerized) MySQL database to be running. The `notes` microservice not running is non-blocking, to illustrate one of the strong parts of microservice architecture.
