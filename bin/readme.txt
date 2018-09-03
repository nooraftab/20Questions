Hi! This is the read me for the 20 Question final project!

To run the two applications: add 'question_tree.xml' as a command-line argument,
without the quotation marks!

New Class Used: JOptionPane! I used it to make pop-up windows for displaying the list 
of answers the game could give, as well as for prompting the user for information when 
it came to the unrestricted version. I would've used JDialog for that second bit but 
I figured why not just make JOptionPane work, because it's the tiniest bit
simpler! I also used JRadioButtons, which I can't remember if I used before, but felt 
like something new to learn!

I wasn't sure how modifying the tree for the unrestricted version was supposed to work
so after a bit of consulting with my GEM, I figured it would be something like the 
little illustration below:

	(Old Answer)   ->   			(New Question)
						      /                \
				    (New Answer)				(Old Answer)
				    
(the position of the new and old answers would be change depending on the
yes/no answer to the new question!)

Hopefully that was how it was meant to be implemented!

Have a wonderful summer! It's been an A+ experience :)