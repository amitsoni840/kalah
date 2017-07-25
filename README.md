# kalah
Kalah Game

##Kalah Game rules
Each of the two players has six pits in front of him/her. To the right of the six pits, each player has a larger pit, his Kalah or house. At the start of the game, six stones are put In each pit.
 
The player who begins picks up all the stones in any of their own pits, and sows the stones on to the right, one in each of the following pits, including his own Kalah. No stones are put in the opponent's' Kalah. If the players last stone lands in his own Kalah, he gets another turn. This can be repeated any number of times before it's the other player's turn.

when the last stone lands in an own empty pit, the player captures this stone and all stones in the opposite pit (the other players' pit) and puts them in his own Kalah.

The game is over as soon as one of the sides run out of stones. The player who still has stones in his/her pits keeps them and puts them in his/hers Kalah. The winner of the game is the player who has the most stones in his Kalah.

##Application Features
The application implemented and tested for 6 stones Kalah game but extensible to support multiple combinations of pits and stones.

##Game API's
The application exposes Rest API to start a game,reset a game and playing the game.

The applicaiton exposes Rest API documentation using Swagger 2.0 online documentation tool as well as a static HTMl file.

##JUnit's

Application contains Junit test cases covering most of the rules and conditions specified as per game requirements.

Application uses jacoco to generate the code coverage reports for junit testcases.

##Javadocs support
Javadocs can be generated as and when required.

##Build
Maven build tool has been used to build ,run the test cases and generate code coverage reports.