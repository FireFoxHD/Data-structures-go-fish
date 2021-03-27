# Data-structures-go-fish

This project is for a UTECH Data structure course where we are requirted to create a game of Go fish.


## Rules of the game

1)	The game consists of fifty-two (52) cards that are shuffled (randomized) at the beginning of a game 
2)	Each player (two players - the human player and computer (AI)) starts the game with four (4) cards from the deck 
3)	The game should then prompt the user for Heads/Tails before simulating the flipping of a coin. If the user’s choice of Heads/Tails is selected, the user should be allowed to choose which player (user/computer) goes first. Otherwise, the Computer will choose to go first. 
4)	The user with the most pairs of cards at the end of the game wins 

## Gameplay

The player will have the opportunity to play Go Fish against the Computer. Each player will aim to get pairs (a pair consists of two cards of the same value eg. two seven’s (7)) of cards either by asking the other player if a card they currently have is in the other player’s hand. If the card is in the other players hand, the player who asked will collect both cards and add the pair to their personal deck before asking the other player for another card. If the other player did not have the card requested the player must take a card from the top of the deck and place in their hand. If the card (taken from the deck) is the same card that the player just requested from the opponent, the player may add the pair of cards to their personal deck and ask the other player for another card. If the player has 2 cards which could make a pair in their hand, they may add this pair to their deck also. A player’s turn ends when the card they asked for is not in the other player’s hand and they did not draw the same card number from the deck. Whenever a player’s hand is empty, they are allowed to draw four (4) additional cards from the deck until it is empty. The computer AI should not simply keep requesting the first card in its hand but should choose randomly between the options in its hand. The player with the most personal sets of pairs (largest deck) at the end of game wins. When a game ends the user should be prompted if they would like to play again.

### Video explaination : https://www.youtube.com/watch?v=hRpXLSMdve0 

**Please note your game should begin with four (4) cards and players only need two (2) cards to make a pair/book.** 
