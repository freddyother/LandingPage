# RENTAL&SALES

## Architecture overview.

## Project setup.

# Prerequisites.

* [JDK 17](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://docs.docker.com/engine/install/)

### Installing project dependencies
After cloning the project it is necessary to run the following command to get all the dependencies required for the project.
```
mvn install
```

### Start the DB.
The project includes for development purposes a script to setup a docker container to run the DB. To start it run the script: _database.sh_ or execute directly the command in your terminal:
```
docker run -d \
    --name data-postgres \
    -e POSTGRES_PASSWORD=TesterU53R! \
    -e POSTGRES_USER=test_user \
    -e POSTGRES_DB=postgres \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v `pwd`/deploy/app/data:/var/lib/postgresql/data \
    -p 5433:5432 \
    postgres:alpine
```
In the case you would prefer to setup the DB in your local machine, you only have to update the properties in the [application-local.properties](./src/main/resources/application-local.properties) file.

### Run it on local
After installing the project dependencies and making sure the DB is running, you should be able to start the application running the following command:
```
mvn spring-boot:run 
```
### Run the project on a docker container.
You can run the project on a conteinerized way using docker-compose. The first step is to buld the API:
```
docker-compose build
```
Then you need to turn the services up:
```
docker-compose up -d
```

To turn the services down:
```
docker-compose down
```

These commands will build and turn up two containers one for the database and the other one for the API. This method is pretty convenient if you need the latest code to test front-end changes.

If you require to modify the ports defined  in the docker-compose configuration it is recommended to create a docker-compose.override.yml file and then overwrite the ports that you need.

## Project collaboration

### Branching strategy
We'll follow the following strategy to contribute to the project. There will be two main stages: integration and release.

First start creating your feature branch from release, using the following structure:
```
git checkout -b feature/<release_number>/<ticket_number>
```

Once your feature is ready for integration test you can merge your feature into integration branch.

Then, when your feature passes all the tests in integration branch your feature is ready and you can create a [Pull Request (PR)](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request) to the appropriate release.

![system overview](./docs/diagrams/branching.svg)

## API documentation - Swagger URL:

```
/swagger-ui/index.html#/
```