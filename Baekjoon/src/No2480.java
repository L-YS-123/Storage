import java.util.Arrays;

class No2480 {
    public static void main(String[] args) {
        
        int[] numbers = new int[3];
       
        for(int i=0; i<3; i++) {
            numbers[i]=(int)(Math.random()*6+1);
            
        }
        System.out.println(new String(Arrays.toString(numbers)));
        
    }
}