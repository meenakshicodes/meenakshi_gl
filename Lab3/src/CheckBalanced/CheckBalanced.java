package CheckBalanced;
import java.util.*;
import java.util.Scanner;

public class CheckBalanced {

	static boolean AreBracketsBalanced(String expr) {
		// TODO Auto-generated constructor stub
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i=0; i<expr.length(); i++) {
			char x = expr.charAt(i);
			
			if(x == '(' || x == '{' || x == '[') {
				stack.push(x);
				continue;
			}
			
			if (stack.isEmpty()) 
				return false;
		
                
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
		return (stack.isEmpty());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Input expression: ");
		String expression = inp.nextLine();
		
		
		
        if (AreBracketsBalanced(expression))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }



}
