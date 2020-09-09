//  GUI based version of the picktocards app from Chapter 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PickTwoCardsGUI extends JFrame implements ActionListener 
{

// GUI components for this class 
Font mainFont = new Font("Verdana",Font.BOLD,32);
Color myColor =new Color (93,245,66);
JLabel mainTitle = new JLabel("Pick Two Cards");
JLabel comLabel = new JLabel("Computer's card is: ");
JLabel comResult = new JLabel ("");
JLabel playerLabel = new JLabel ("Player card is :");
JLabel playerResult = new JLabel ("");
JLabel endResult = new JLabel ("");
JButton  button = new JButton("Draw Cards");
JLabel panel1 = new JLabel();
JLabel panel2 = new JLabel();
JLabel panel3 = new JLabel();
JLabel panel4 = new JLabel();
JLabel panel5 = new JLabel();




//constructor method for this class

public PickTwoCardsGUI() 
{
	//this the JFrame constructor to structures an object from this class
	super("Two Cards GUI");
	setBounds(600,380,310,300);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	//customize 
	getContentPane().setBackground(myColor);
	mainTitle.setFont(mainFont);
	button.setBackground(Color.RED);
	
// add some components to the JPanels 
 panel1.add(comLabel);
 panel2.add(comResult);
 panel3.add(playerLabel);
 panel4.add(playerResult);	
 panel5.add(button);
// add components to the frame 
	add(mainTitle);
	add(comResult);
	add(comLabel);
	add(playerLabel);
	add(playerResult); 
	add(endResult);
	add(button);
 //add the event listener to the button
button.addActionListener(this);
}


// event handle method for the click event 
@Override
public void actionPerformed (ActionEvent e)
{

// call the playGame() method 
	playGame();
}
	

public void playGame()
{
	// variables and constants
	final int CARDS_IN_SUIT = 13;
	int comValue;
	int userValue;
	String msg;
	Card comCard = new Card();
	Card userCard = new Card();
	// calculation phase
	comValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));
	userValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));

	comCard.setValue(comValue);
	userCard.setValue(userValue);

	// ARRAYS IS UPDATED!
	String[] cardSuits = {"Clubs", "Diamonds","Hearts", "Spades"};
	comCard.setSuit(cardSuits[(int)(Math.random()*4)]);
	userCard.setSuit(cardSuits[(int)(Math.random()*4)]);
	// Determine a winner
	if(comCard.getValue() > userCard.getValue())
	{
		msg = "Sorry, the Computer has won.";
	}
	else
	{
		if(comCard.getValue() < userCard.getValue())
		{
			msg = "Congratulations, you win!";
		}
		else
		{
			msg = "We have a tie!";
		}
	}
	// Output phase
	comResult.setText(comCard.getRank() + " of " + comCard.getSuit());
	playerResult.setText(userCard.getRank() + " of " + userCard.getSuit());
	endResult.setText(msg);
}






	public static void main(String[] args)
	{
		PickTwoCardsGUI frame1 = new PickTwoCardsGUI();
		frame1.setVisible(true);
	}
}