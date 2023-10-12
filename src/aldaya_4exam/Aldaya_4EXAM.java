package aldaya_4exam;

import java.util.Scanner;


public class Aldaya_4EXAM {
    
    private class StackNode{
        String data;
        int num;
        StackNode next;
    }
     private StackNode top;
     private String data;
     private int num;
     
     
     
     private StackNode createNewNode(String element, int number)throws Exception{
         StackNode node = new StackNode();
         if(node == null){
             throw new Exception("Memory is full");
         }else{
             node.data = element;
              node.num = number;
             node.next= null;
             return node;
         }
     }
     
     
     public void push(String element, int number) throws Exception{
         StackNode node = createNewNode(element, number);
       
         if(top== null ){
             top = node;
             
         }else{
             node.next = top;
             top = node;
         }
         return;
     }
     
     
     public String pop() throws Exception{
            if(top ==null){
                throw new Exception("Inventory is Empty");
            }
            String temporary = peek();
            top = top.next;
            
            return temporary;
        }
     
   
     public String peek()throws Exception{
         if(top == null){
             throw new Exception("Inventory is Empty");
         }
         
         return top.data + " " +top.num;
     }
     
     public void display()throws Exception{
         if(top ==null){
             throw new Exception("Inventory is empty");
         }
         StackNode temporary =top;
         
         while (temporary  !=null){
         System.out.println(" " + temporary.data + " "+temporary.num +"->");
         temporary = temporary.next;
     }
         System.out.println("NULL");
     }
     
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Aldaya_4EXAM stack = new Aldaya_4EXAM();
        
        while(true){
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Display Product");
            System.out.println("Enter your choice:");
            String element;
            int number;
           
            
            
            int choice = scn.nextInt();
            
            
            switch(choice){
                case 1:
                    System.out.println("Enter Product");
                    scn.nextLine();
                    element = scn.nextLine();
                    System.out.println("Input Quantity");
                    number = scn.nextInt();
                    stack.push(element, number);
                    System.out.println("\n");
                break;
                case 2:
                    System.out.println("input what to sell");
                    scn.nextLine();
                    element = scn.nextLine();
                    System.out.println("input how many to sell");
                    number = scn.nextInt();
                    
                    System.out.println("Selling "+ stack.pop());
                    System.out.println("\n");
                break;
                case 3:
                     System.out.println(" list Product");
                     stack.display();
                break;
               
                default:
                    throw new AssertionError();
            }
        }
    }
}
