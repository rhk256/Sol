package vapor.sol;
import java.util.Stack;

/**
 * This class contains the methods and infrastructure for the 7
 * piles players move cards around within. It is distinguished 
 * from suit pile because of move rules.
 */

  class PlayPile{
	 
	 Stack<Card> pile;
   /*
    * Constructor
    */
   PlayPile(){
     pile = new Stack<Card>();
   }
   /*
    * The upcoming methods handle movement, using a target pile
    * as the source for a card to move to the play pile the method is called on. 
    * This method handles a play pile target.
    * @param p	the target play pile
    */
   public void addCard(PlayPile p){
     Card c = p.pile.peek();
     Card val;
     //if the pile is empty it can go there regardless
     if(pile.empty() && c.getValue() == 13){
       pile.add(p.pile.pop());
     }
     //else it has something to peek at and check
     else if(!pile.empty()){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
         pile.add(p.pile.pop());
       }
     }
   }
   /*
    * This method handles a suit pile target.
    * @param s	target suit pile
    */
   public void addCard(SuitPile s){
     Card c = s.pile.peek();
     Card val;
     //if the pile is empty it can go there regardless
     if(pile.empty() && c.getValue() == 13){
       pile.add(s.pile.pop());
     }
     //else it has something to peek at and check
     else if(!pile.empty()){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
         pile.add(s.pile.pop());
       }
     }
   }
   /*
    * This method handles a draw pile target.
    * @param d target draw pile
    */
   public void addCard(DrawPile d){
     Card c = d.q.peek();
     Card val;
     //if the pile is empty it can go there regardless
     if(pile.empty() && c.getValue() == 13){
       pile.add(d.q.remove());
     }
     //else it has something to peek at and check
     else if(!pile.empty()){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
         pile.add(d.q.remove());
       }
     }
   }
 }
