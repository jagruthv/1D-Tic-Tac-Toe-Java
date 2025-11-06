import java.util.Scanner;

public class tic_tac_toe_1d {
    static String winCheck(String[] game){ // check 3 consecutive spots to decide the winner
        
        if(game[0].equals(game[1]) && game[1].equals(game[2]) && !game[0].matches("[1-9]")){ // check row - 1
            return game[0];
        }

        if(game[3].equals(game[4]) && game[4].equals(game[5]) && !game[3].matches("[1-9]")){ // check row - 2
            return game[3];
        }
        
        if(game[6].equals(game[7]) && game[7].equals(game[8]) && !game[6].matches("[1-9]")){ // check row - 3
            return game[6];
        }

        if(game[0].equals(game[3]) && game[3].equals(game[6]) && !game[0].matches("[1-9]")){ // check column - 1
            return game[0];
        }

        if(game[1].equals(game[4]) && game[4].equals(game[7]) && !game[1].matches("[1-9]")){ // check column - 2
            return game[1];
        }

        if(game[2].equals(game[5]) && game[5].equals(game[8]) && !game[2].matches("[1-9]")){ // check column - 3
            return game[2];
        }
        
        if(game[0].equals(game[4]) && game[4].equals(game[8]) && !game[0].matches("[1-9]")){ // check diagonal - 1(left to right)
            return game[0];
        }

        if(game[2].equals(game[4]) && game[4].equals(game[6]) && !game[2].matches("[1-9]")){ // check diagonal - 2(right to left)
            return game[2];
        }
        return "000"; // tells none won yet
    }

    static void display(String[] game){ // displaying method
        System.out.println("|---|---|---|");
        int count = 0;
        for(String val : game){
            count++;
            System.out.print("|-");
            System.out.print(val + "-");
            if(count == 3){
                System.out.println("|");
                System.out.println("|---|---|---|");
                count = 0; 
            }
        }
        System.out.println();
    }

    static int input (String s, String[] game, Scanner sc){ // input from user
        System.out.println("Player '"+ s + "', please choose your option to mark\n");
        int num = 0;
        while(true){
            try{
                num = sc.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("\n" + e + " found.\n");
                System.out.println("Please enter a valid input ranging from 1 to 9\n");
                display(game);
                sc.next();
            }
        }
        return num;
    }

    static boolean checkInput(int choice, String[] game){ // checks wheather the input is valid or not 
        if(choice < 1 || choice > 9){ // check if input is less than 1 or greater than 9
            System.out.println("Please enter a valid input ranging from 1 to 9\n");
            return true;
        }
        if(game[choice - 1].equals("O") || game[choice - 1].equals("X")){ // checks the selected spot is vacant or filled.
            System.out.println("This place has already taken, please choose another from remaining places as per image\n");
            return true;
        }
        return false;
    }

    static boolean player_turn(String player, String[] game, Scanner sc){
        boolean wrongValue = false;
        int choice = 0;
        do{
            display(game);
            choice = input(player, game, sc); // takes input from player X from input function
            wrongValue = checkInput(choice, game);
        }while(wrongValue);
        game[choice - 1] = player;
        System.out.println("Update game is: \n"); // displays before input and after winning.
        if(winCheck(game).equals(player)){
            display(game);
            System.out.println("Player '"+player+"' won the match");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] game = new String[9];
        for(int i = 0; i < 9; i++){
            game[i] = Integer.toString(i+1); // table initialization
        }
        int moves = 0;
        while(moves < 9 && winCheck(game).equals("000")){
            if(player_turn("X", game, sc)) break;
            moves++;
            if(moves < 9){
                if(player_turn("O", game, sc)) break;
                moves++;
            }
        }
        if(moves == 9){
            display(game);
            System.out.println("Match Drawn");
        }
        sc.close();
    }
}