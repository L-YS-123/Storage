import java.util.Scanner;

class No2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstHourAndMinute = sc.nextLine();
        String[] temp = firstHourAndMinute.split(" ");
        int[] Elements = new int[2];
        
        for(int i=0; i<2; i++) {
            Elements[i] = Integer.parseInt(temp[i]);
        }
        
        
        
        
        int h1 = Elements[0];
        int m1 = Elements[1];
        
        int m2 = sc.nextInt();
        

        if((m1+m2)<=59) {
        	
        	System.out.println(
        			h1 + " " + (m1+m2)
        			);
        	
        } 
        
        else if((m1+m2)>59) {
          
        	if((h1+(m1+m2)/60)<=23) {
        		System.out.println(
        				h1+(m1+m2)/60
        				+ " " 
        				+(m1+m2)%60
        				);
        		
        	} 
        	else if((h1+(m1+m2)/60)>23) {
        		System.out.println(
        				(h1+(m1+m2)/60)-24
        				+ " "
        				+(m1+m2)%60
        				);
        	}
        }
        sc.close();
    }
}