package game;

import java.awt.Component;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/* 
 * SuDoKu
 * Group Members: Alexander Fields, Jared Dean, Najee Simmons, Tony Andrews, Ike Ukwu
 * only Art is done so far
 * Add numbers
 * add linear search algorithm
 * add static numbers that cant be removed
 * add easy medium hard
 */


public class gameProject extends Application {
	
	private GridPane gp = new GridPane();
	private Rectangle r = null;
	private Component frame;
	int[][]userInput = new int[9][9];
	int[][] solution  = new int[][]{
		{2,9,5,7,4,3,8,6,1},
		{4,3,1,8,6,5,9,2,7},
		{8,7,6,1,9,2,5,4,3},
		{3,8,7,4,5,9,2,1,6},
		{6,1,2,3,8,7,4,9,5},
		{5,4,9,2,1,6,7,3,8},
		{7,6,3,5,3,4,1,8,9},
		{9,2,8,6,7,1,3,5,4},
		{1,5,4,9,3,8,6,7,2}
	};
	public static void main(String[] args) {
		
		launch();

	}

	public void start(Stage primaryStage) throws Exception {
			
		addGridPane(); // the numbers are IN the grid
		//addNumbers(); //was a bad idea adding numbers on top of the grid
		
		// Create HBox and buttons
		HBox hb = new HBox();
		hb.setPadding(new Insets(5,5,5,5));
		hb.setSpacing(100);
		hb.setAlignment(Pos.CENTER);
		Button btnInstructions = new Button("Rules");
		Button btnNewGame = new Button("New Game");
		Button btnExit = new Button("Exit");
		btnInstructions.setOnAction(new InstructionsHandler());
		btnNewGame.setOnAction(new NewGameHandler());
		btnExit.setOnAction(new ExitHandler());
		hb.getChildren().addAll(btnInstructions,btnNewGame, btnExit);
				
		//BorderPane
				BorderPane bp = new BorderPane();
				bp.setBottom(hb);
				bp.setAlignment(hb, Pos.CENTER);
				bp.setCenter(gp); 
				bp.setCenter(gp); 
			
		//create a scene
				Scene s = new Scene(bp, 359, 400);			
				//add to the stage
				primaryStage.setScene(s);
				//show the stage
				primaryStage.show();
				primaryStage.setResizable(false);
				
		// Arbitrary tri lines just to show the user the 3x3 
				
				//horizontal lines
				Line line1 = new Line(0, 124, 400,124);
			    line1.setStroke(Color.BLUE);
			    Line line2 = new Line(0, 245, 400, 245);
			    line2.setStroke(Color.BLUE);
			    bp.getChildren().addAll(line1, line2);
			    //vertical lines
			    Line line3 = new Line(245, 0, 245, 369);
			    line3.setStroke(Color.BLUE);
			    Line line4 = new Line(124, 0, 124, 369);
			    line4.setStroke(Color.BLUE);
			    bp.getChildren().addAll(line3, line4);
			    
	} 
	//end of primary stage
	// 3 gridpanes for each game type
	private void addGridPane() {
		//create GridPane for the board

				for(int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						Rectangle r1 = new Rectangle(40, 40);
						
						//allows for different coloration
						if(row%2==0 && col%2 ==0) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else if (row%2==1 && col%2==1) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}
						TextField text = new TextField();
						if(initialShow(row,col)){
							text.setText(String.valueOf(solution[row][col]));
							text.setEditable(false);
						}
						//these two are adding the border pane and the text to the primary stage
						r1.setOnMouseClicked(new SquareEventHandler());
						gp.add(r1, row, col);
						gp.add(text, row, col);
						
					}
					
				}
	}
	
	//for medium game
	private void addGridPane2() {
		//create GridPane for the board

				for(int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						Rectangle r1 = new Rectangle(40, 40);
						
						//allows for different coloration
						if(row%2==0 && col%2 ==0) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else if (row%2==1 && col%2==1) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}
						TextField text = new TextField();
						if(mediumShow(row,col)){
							text.setText(String.valueOf(solution[row][col]));
							text.setEditable(false);
						}
						//these two are adding the border pane and the text to the primary stage
						r1.setOnMouseClicked(new SquareEventHandler());
						gp.add(r1, row, col);
						gp.add(text, row, col);
						
					}
					
				}
	}
	//for hard game
	private void addGridPane3() {
		//create GridPane for the board

				for(int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						Rectangle r1 = new Rectangle(40, 40);
						
						//allows for different coloration
						if(row%2==0 && col%2 ==0) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else if (row%2==1 && col%2==1) {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}else {
							r1.setFill(Color.LIGHTBLUE);
							r1.setStroke(Color.WHITE);
						}
						TextField text = new TextField();
						if(hardShow(row,col)){
							text.setText(String.valueOf(solution[row][col]));
							text.setEditable(false);
						}
						//these two are adding the border pane and the text to the primary stage
						r1.setOnMouseClicked(new SquareEventHandler());
						gp.add(r1, row, col);
						gp.add(text, row, col);
						
					}
					
				}
	}
	
	//mechanics of the game  and handlers
	
	// this will serve as easy
	public boolean initialShow(int row, int col){
		int i = (int)(Math.random()*2);
		if(i==0)return true;
		else return false;
	}
	
	public boolean mediumShow(int row, int col){
		int i = (int)(Math.random()*6);
		if(i==0)return true;
		else return false;
	}
	
	public boolean hardShow(int row, int col){
		int i = (int)(Math.random()*12);
		if(i==0)return true;
		else return false;
	}
	
	class NumberEventHandler implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent e) {
			//int row = gp.getRowIndex();
			//int col = gp.getColumnIndex();
			
			//gp.getChildren().remove(n);
			//gp.add(c, col,  row-1);
		}
	}//end of NumberHandler
	
	 class SquareEventHandler implements EventHandler<MouseEvent>{
			@Override
			public void handle(MouseEvent e) {
				r = (Rectangle)e.getSource();
				int Rrow = gp.getRowIndex(r);
				int Rcol = gp.getColumnIndex(r);
				
				JOptionPane.showMessageDialog(frame, "This is : " + '\n' +  "Row " +(Rrow+1) + '\n' + "Column " + (Rcol+1) + ". " + '\n');
			}
	 }

	
	//the 3 event handler buttons are below
	class InstructionsHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame,
					
				    "The classic game of ??(SuDoKu) involves a grid of 81 squares."
				    + '\n' + "the grid if divided into nine blocks, each containing nine squares."
				    
				   	+ '\n' +   '\n' + "Rules:" + " " + '\n'
				   	
				   	+ '\n' + "each of the nine blocks has to contain all the numbers 1-9 within the squares."
				   	+ '\n' + "each number can only appear once in a row column or box"
				   	+ '\n' + "all boxes msut be filled in order to complete the game.",
		
				    
				    "Instructions",
				    JOptionPane.PLAIN_MESSAGE);
			
		}
	}
	 class NewGameHandler implements EventHandler<ActionEvent> {
		 //new and improved allows new board layouts
	@Override
    public void handle(ActionEvent arg0) {
    Object[] options = {"Easy",
    					"Medium",
                        "Hard",
    					"No"
                        		};
			int n = JOptionPane.showOptionDialog(frame,
					"Are You sure You'd like to reset the entire game or use a new board?",
					"RESET WARNING",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,     //do not use a custom Icon
					options,  //the titles of buttons
					options[0]); //default button title
			if (n == JOptionPane.YES_OPTION) {	
				addGridPane();
				}
            else if (n == JOptionPane.NO_OPTION) {

				addGridPane2();
            }
            else if (n == JOptionPane.CANCEL_OPTION) {
				addGridPane3();
            }
            else {
            //hitting No just hits the event handler making nothing happen 
            //no need for the else handler is causing problems in that case make try catches in here
            }
	
			}
			
		}//end of NewGameHandler
	
	class ExitHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Object[] options = {"Yes", "No"};
			int n = JOptionPane.showOptionDialog(frame,
					"Are You sure You'd like to Exit?",
					"EXIT WARNING",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,     //do not use a custom Icon
					options,  //the titles of buttons
					options[0]); //default button title
			if (n == JOptionPane.YES_OPTION) {
				System.exit(0); 
			}
			
		}
	}//end of Exit Handler
	

}//end of gameProject class	


