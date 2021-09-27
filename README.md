# IMDB clone
let user register, see, and rate films;
recommendations may be added in the future;
rest calls are used

## architecture
see written notes at the end from me

- frontend:
  - thymeleaf as template engine
  - javascript + AJAX for asynchronous rest calls (not implemented)
- backend:
  - spring boot
  - h2 db

## datamodel
user---n--------rates-------m---movie
TODO see notes written by me, add them later on, at least half an hour before end

## tech stack
- spring boot
- jpa
- spring security rudimentary functionality
- H2 (for rapid prototyping, without setting up docker mysql db)
- lombok, removing boilerplate
- logging sl4j2 at the moment, may be replaced with
  log4j2

- rest assured for testing rest calls
- junit 5 + mockito + assertJ for testing

# steps to take:
1. set up project with h2 db, logging etc.
2. set up database filling
3. write tests for rest calls
4. write services fulfilling functionality required by the rest calls
5. set up security
6. set up registering possibility
7. 