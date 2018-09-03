
To run the two applications: add 'question_tree.xml' as a command-line argument,
without the quotation marks!

A new swing class for me was used: JOptionPane! I used it to make pop-up windows for displaying the list 
of answers the game could give, as well as for prompting the user for information when 
it came to the unrestricted version. I would've used JDialog for that second bit but 
I figured why not just make JOptionPane work, because it's the tiniest bit
simpler! I also used JRadioButtons, which felt like something new to learn!

I figured modifying the tree for the unrestricted game would would be something like the 
little illustration below:

	(Old Answer)   ->   			(New Question)
					       /              \
				    (New Answer)	        (Old Answer)
				    
(the position of the new and old answers would be change depending on the
yes/no answer to the new question!)

:)
