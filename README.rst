Description
===========
In this project, I would like to implement one very popular casino game named **Slot Machine**. 
The aim of the game is to check out with the largest amount of coins (equivalent to money).
The slot machine has three reels.
On each reel, there is a banana, lemon, orange, apple, melon and a joker.
The payouts are as follows: 
- Three jokers (Joker|Joker|Joker) wins 30 coins.
- Any three similar fruits (example: Lemon|Lemon|Lemon) wins 10 coins.
- Any two jokers win 4 coins.
- Any one joker wins 1 coin.
You have three trials or lives. 
There will be a button to check out at any point of the game. After this button will be pressed, the checkout window will appear. Your total score will reduce proportionately, as more trials you need. The highest score will be saved in the file. The highest score can be reset. 
There will be three difficulty levels. A number of coins can be set manually. Both settings will be saved in the file. 
The program will check each time if the files (highest score and settings) are corrupted (was manipulated by the user) and rewrite the file if needed.  

Functions
---------
As the program starts, the settings and highest score files will be loaded. If it contains corrupted data or the data in it was manipulated, it will be rewritten with default settings. The score file will be reset to zero. Files will be checked separately. 
Each time the different random reel combination will be generated according to a level of difficulty set in the settings.
The amount of the coins lost or won will be shown each time after a play. A number of coins added to a total sum or deducted from it will depend also on the difficulty set in the settings. The total amount left will be updated after each play.
At the beginning, there are 3 trials or lives available. They will be shown as the stars at the top of the slot machine. 
According to trials/lives played, the score will be calculated proportionately. The more trials/lives are played, the smaller is the score. There will be a specific formula for this calculation. 
There will be a button to check out at any point of the game. After this button will be pressed, the checkout/payment window will appear.
The checkout/payment window will also appear if you are in your last life and you lost all your coins. 
At least three different checkout windows will be implemented according to a situation (won / lost / equal amount of coins).
In the settings, three difficulties can be set manually. 
Each difficulty will represent varying probability to win. 
Besidens that a number of coins to win is also different. E.g. in the 'Real Life' difficulty 30 coins will be win in case of 3 jokers. In the 'Fun' difficulty you would win 300 coins.
In the settings, a number of coins can be set manually. Only digits will be accepted.
In the highest score menu, the highest score will be shown.
The highest score can be manually reset to zero.


Windows
-------
At the beginning of the game, there will be a menu with five options to choose from: 'New Game', 'Highest Score', 'Rules', 'Settings' and 'Exit game'.

**New Game**
When the new game is started, the windows will appear with the slot machine. At the top right corner, there will be stars, which will represent a number of lives/trials left. Initially, there will be three stars. At the right bottom corner, there will be the total number of coins left. At the beginning, it will be the amount that was set manually in the settings, e.g. 5 coins. After the game will be initiated, the combination of reels will be shown. Depending on the combination at the bottom left corner the information will be shown how many coins you won or lost. At any point of the game, there is the possibility to checkout with a number of coins you possess. The detailed checkout/payment window will be shown in this case. There will be three situations in case of the manual quitting: 

Situation 1. A person is checking out with more coins than he had at the beginning, this means he won. In this case in the payment/checkout window will be shown, how many coins the person actually won. The message will appear “Congratulations! You have earned xxx coins“.
Additionally, the score will be calculated. The score is calculated accordingly to trials that you needed. For example, at the beginning, you have three trials. Let’s say the first trial was not successful, and you lost everything. After this, the second trial will begin. If you win this time, the score will be less than if you won that at your first trial. There will be a specific formula for this calculation. 
At this point, the game will check if the score is higher than saved in the highest score file. If so, it will overwrite the achievement. If not, it will do nothing. In both cases, the player will be informed about the procedure, if his achievement was absolutely the highest and is going to be saved or not.  

Situation 2. A person is checking out with an equal amount of coins. This is the situation when there is no need to rewrite the highest achievement. The game will show the message “Good! You didn’t win or lose anything.”

Situation 3. A person is checking out with less amount of coins than he had at the beginning, this means he lost. As with the situation above, no need to rewrite the achievement. The message will appear “You have lost xxx coins“.

If the person will not press a quit button, the game will be played as follows. The player starts for example with five coins. At the first trial, he will lose all the coins, so the second trial will be started. And so on. At the end, the checkout/payment windows will appear with according information.

** Highest score **
The highest score will be shown. The score is saved in the file. There will be a reset button to reset the score. Each time the program starts the file will be checked if the file is corrupted. If so, the program will rewrite the file with its default.

** Rules **
The rules and short explanations will be shown.

** Settings **
There will be two things, which can be changed. First one, a number of coins you have at the beginning. Only numeric entries will be accepted. Second, the difficulty. There will be three levels of difficulty: 'Real Life', 'Normal' and 'Fun'. Each difficulty will have its own different reel. This means, the probability to get two or three similar fruits or jokers will be different. Besides, there will be 3 different sets win situations - e.g. how many coins well be granted in the case of 3 jokers. 
The settings will be saved in the file. The file will be checked every time the program starts. If the file is corrupted, it will be rewritten with default settings. It is possible to change settings manually in the file and they should load normally if the format is the same. 

** Exit game **
No specific message will be shown. All settings and high scores are saved automatically.

Schedule
--------

- 5. week: UI mockup
- 6. week: core implementation of the game, generation of reels
- 7. week: score calculation
- 8. week: live/trials realization
- 9. week: JavaFX UI realization
- 10. week: game UI + settings
- 11. week: high score
- 12. week: bonus/bugfix

Points
------
8 points
