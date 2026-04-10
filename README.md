# Module 11<br>Api test

We pretend that "https://jsonplaceholder.typicode.com/users" is part of the sauce demo site.

## Tests
UserApiTest class: contains a _wide range_ of api tests (3)<br>UserCRUDTest class: smoke tests, only verifying the 4 basic operations work.

## Changes compared to the previous task
- refactor to accommodate api tests
  - separate ui and api package in test package
  - testdata.ui and testdata.api section in the .properties files
- made "normal" the default environment
- (added ThreadLocal to WebDriverProvider - completely unnecessary, but I wanted to test it)