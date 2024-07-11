//Assignment 5 Sasha Basova
// Using a stack to evaluate an expression in postfix notation
import java.util.Scanner;

public class PostfixEvaluator {
   public static void main( String[] args ) {
     // get postfix expression from the user
     System.out.print("Postfix Evaluator Program" + "\n");
     System.out.println();
     System.out.print("Enter your postfix expression: ");
     Scanner input = new Scanner(System.in);
    
     StringBuffer sb = new StringBuffer();
     sb.append(input.nextLine());
     sb.append(')');
     System.out.println();
    
     // evaluate postfix expression by calling "evaluatePostfixExpression" method and print the result
     System.out.print("The result of the evaluation is " + evaluatePostfixExpression(sb));

   } 

   // evaluate the postfix notation
   public static int evaluatePostfixExpression( StringBuffer expr ) {
      
	//create a stack and use it to evaluate the postfix notation
   StackComposition<Integer> stack = new StackComposition<>();

	int position = 0;
      while(expr.charAt(position) != ')') {
         
         char nextChar = expr.charAt(position);
         if(String.valueOf(nextChar).matches("\\S")) {
            System.out.print("NextChar is: " + nextChar + "\n");
            if(String.valueOf(nextChar).matches("[a-zA-Z]")) {
               System.out.print("Non-digit characters don't participate in evaluation!" + "\n");
            }
         }
         
         String next = "";

         if(String.valueOf(nextChar).matches("\\d")) {
            next = "variable";
         } else {
            next = String.valueOf(nextChar);
         }

         switch(next) {
            case("variable"):
               stack.push(Character.getNumericValue(nextChar));
               break;
            case "+"  : case "-" : case "*" : case "/" : case "%":
               stack.print();
               int operandTwo = stack.pop();
               int operandOne = stack.pop();
               int result = calculate(operandOne, operandTwo, nextChar);
               System.out.print("Two top values get popped from the stack:" + "\n");
               stack.print();
               stack.push(result);
               System.out.print("After calculation the result gets pushed to the stack:" + "\n");
               stack.print();
               break;
            default: break;
         }
         position++;

      }

      return (int)stack.pop();

   } 

   // do the calculation
   private static int calculate( int op1, int op2, char oper ) {
     int result = 0;
     
      switch(oper) {
         case '+' :
         result = op1 + op2;
         break;
         case '-' :
         result = op1 - op2;
         break;
         case '*' :
         result = op1 * op2;
         break;
         case '/':
         result = op1 / op2;
         break;
         case '%':
         result = op1 % op2;
         break;
         default: 
         result = 0;
         break;
      }

      return result;
      
   } 

} 


