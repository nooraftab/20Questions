This Java application implements a loose version of 20 questions/a guessing game in two ways - restricted and unrestricted (where new questions/answers can be added) - using data structures like linked lists and a binary tree!

## Instructions

### Restricted

1) Download `GuessingGame.jar` and `question_tree.xml`
2) Use terminal to navigate to the folder containing it
3) Type and run `java -jar GuessingGame.jar question_tree.xml` in your terminal!

Choose one of the word options given in the pop up screen and answer the yes/no questions given until the program (hopefully) guesses it!

### Unrestricted

1) Download `UnrestrictedGuessGame.jar` and `question_tree.xml` 
2) Use terminal to navigate to the folder containing it
3) Type and run `java -jar UnrestrictedGuessingGame.jar question_tree.xml` in your terminal!

You have the option to think of an astronomy or physics related term or to just pick one from the given list! Answer the yes/no questions as accurately as you can! At the end, the program will ask if the guessed answer is the answer you were thinking of! 

If it is not, the program gives you the option to make a new 'branch' in the tree to include the new term you're thinking of, after which the program restarts itself with this new branch (of a question and answers) included in the question tree (you can choose to reanswer the questions in the same way to see this change more clearly)! 

Otherwise, the game ends!

(Making a new 'branch' includes giving the program the term you're thinking of, a yes/no question for the term, and a yes/no answer to the question, after which the binary tree used for the game edits itself to include this node. Instructions will be given in the pop-up window!)
