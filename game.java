import java.util.Scanner;
class game{
	public static void main(String args[]){
	String number;
	boolean flag = false;
	Scanner sc=new Scanner(System.in);
	boolean[] positionTaken = new boolean[9]; 

	String[][] g={{"a","b","c"},
				  {"d","e","f"},
				  {"g","h","i"}};

	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(g[i][j] +" | ");
		}
	System.out.println();
	}

	String a = " ";
	while (!a.equals("o") && !a.equals("x")) {
		System.out.println("Enter user 1 requirement from o and x: ");
        	a = sc.next();
        	if (!a.equals("o") && !a.equals("x")) {
        		System.out.println("Invalid input: Please enter 'o' or 'x'");
            	}
        }

	String b = " ";
	while (!b.equals("o") && !b.equals("x") || b.equals(a)) {
		System.out.println("Enter user 2 requirement from o and x (cannot be the same as user 1): ");
       		b = sc.next();
        	if (!b.equals("o") && !b.equals("x")) {
        		System.out.println("Invalid input: Please enter 'o' or 'x'");
            		} else if (b.equals(a)) {
                		System.out.println("Invalid input. Symbol already chosen by user 1. Please choose another symbol.");
           	}
	}


	System.out.println("user 1: " + a);
	System.out.println("user 2: " + b);

	System.out.println("--------------------------------------------------------");
	System.out.println("NOTE: If you want to exit the game: Just type exit ");
	System.out.println("--------------------------------------------------------");

	for(int n=0;n<10;n++){
		try{
			String cp1 = (n % 2 == 0) ? a : b;
			System.out.println("=================================================================");
			System.out.print("User " + (n%2 +1) + ": Enter the alphabet (a-i) to replace: ");
			number=sc.next();
			System.out.println("=================================================================");

	if(number.equals("exit")){
		System.out.println("EXIT..........");
		break;
	}

	if (!number.matches("[a-i]")) {
		System.out.println("Invalid input: Enter a letter from 'a' to 'i'");
       		n--;                                                                                                                                        
        	continue;                                                                        
	}

	int index = number.charAt(0) - 'a';                   
	if (positionTaken[index]) {                            
		System.out.println("The position is already occupied. Choose another position.");
        	n--;                                                              
       		continue;                                                    
	}

	positionTaken[index] = true;                           

	switch(number){
		case "a":
			g[0][0]=cp1;
			break;
		case "b":
			g[0][1]=cp1;
			break;
		case "c":
			g[0][2]=cp1;
			break;
		case "d":
			g[1][0]=cp1;
			break;
		case "e":
			g[1][1]=cp1;
			break;
		case "f":
			g[1][2]=cp1;
			break;
		case "g":
			g[2][0]=cp1;
			break;
		case "h":
			g[2][1]=cp1;
			break;
		case "i":
			g[2][2]=cp1;
			break;
		default:
			System.out.println("ERROR !!!!!!!!   ->   Enter number between a-i");
			System.out.println();
	}

	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(g[i][j] +" | ");
		}
		System.out.println();
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
            if (j + 2 < 3 && g[i][j].equals(cp1) && g[i][j+1].equals(cp1) && g[i][j+2].equals(cp1)) {
            System.out.println("=================================================================");
            System.out.println(cp1 + " is winner " + "** Congratulations! ");
            System.out.println("=================================================================");
            flag = true;
        break;
        }
			else if(i + 2 < 3 && j + 2 < 3 && g[i][j].equals(cp1) && g[i + 1][j +1].equals(cp1) && g[i + 2][j + 2].equals(cp1)){
			System.out.println("=================================================================");
            System.out.println(cp1 + " is winner " + "** Congratulations! ");
            System.out.println("=================================================================");
            flag = true;
          break;
		} 
		else if(i + 2 < 3 && g[i][j].equals(cp1) && g[i +1][j].equals(cp1) && g[i+2][j].equals(cp1)){
			System.out.println("=================================================================");
            System.out.println(cp1 + " ** is winner " + "** Congratulations! ");
            System.out.println("=================================================================");
            flag = true;
            break;
		} 
			else if(i + 2 < 3 && j + 2 < 3 && g[i][j+2].equals(cp1) && g[i +1][j +1].equals(cp1) && g[i+2][j].equals(cp1)){
			System.out.println("=================================================================");
            System.out.println( cp1 + " is winner " + "** Congratulations! ");
            System.out.println("=================================================================");
            flag = true;
            break;
		} 
        }
	}
		if (flag==true){
        break;
    }
			if(n==8 && flag==false){
			System.out.println("=================================================================");
			System.out.println("DRAW!!!!!!!");
			System.out.println("=================================================================");
			break;
			}
		}
 	catch (Exception e) {
        e.printStackTrace();
        }
        }
    }
}