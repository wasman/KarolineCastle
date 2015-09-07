# KarolineCastle game

## Hi, this is very simple console game. General the UI part could be easily changed to desktop or web

## Application start: 

Use CastleMain for application main. Here is the example of how to run game

 > java -classpath ./build/KarolineCastle-0.1.0.jar com.dowell.castle.CastleMain

The application build is available in build folder

## Resume game functionality

- Game saving functionality is implemented with standard java serialization.
- User staging file saved based on UserProfile class - all information will be saved as {username}.ser file  
- The *data* folder is required for the application.
- example of saved user is present in {data}/doom.ser doom:doom

## Fight Game functionality
 Very simple implementation for fight - you eat enemies and increase your experience.
 You - circle on the game map. Enemies are rectangles. 


