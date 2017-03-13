# prcGame
Simple Paper-Rock-Scissors game implementation

Game use Angular on frontend with one page and Spring boot at backend.
On backend there is one REST service and GameService, to play
Paper-Rock-Scissors game history for every plyer used, 
Angular controller generate playerId number abd use it for all
game session turns.
Implemented three different plaing strategy:
Just random generator, Linear Prediction stratety and Simple Neural Network.
GameService monitor level of losses on last 4 turns and choose strategy which 
better predict player behaviour.
