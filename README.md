# API Buildout excersice : Job site micro service

this is a small weekend project that implements 2 API endpoints in Spring boot.
1) PUT endpoint to post new job opportunities
     PUT /jobs/
2) GET endpoint (with location and skills arguments) to find available job opportunitis
     GET  /jobs/{location}/{[search-term1, skill-term2, skill-term3]}

## Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.

To run inside docker container, use below commands

To build docker image, use the command below - `docker build -t your_tag_name  .`

To run the generated container, use this command - `docker run -p8080:8080 your_tag_name`. This will run the server on 8080 port.. You can change the ports as per your needs. 


## License
While this repository is licensed under APACHE 2.0 license, It is mandatory for users to share the readme.md and License file along with the changes they do in the contents.
