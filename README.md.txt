** 
+ You can import this project as a maven project.
+ To run type: mvn spring-boot:run on cmd/bash or eclipse/inteliJ.
+ To test with postman/httpRequest, insert a word a post for the url = http://localhost:4040/palindrome/check
	* If it is a palindrome a 200 status is returned, but if it is not a palindome, a status 400 is returned.
+ Words were "cleared" to filter any special character, only letter [a-z A-Z] were compareted, other characters were discarded.