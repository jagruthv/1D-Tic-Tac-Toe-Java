package New_Resolution;

import java.util.Scanner;

public class tic_tac_toe_1d {
    static String winCheck(String[] game){
        if(game[0].equals(game[1]) && game[1].equals(game[2])){
            if (game[0].equals("X"))
                return "X";
            else return "O";
        }
        if(game[0].equals(game[3]) && game[3].equals(game[6])){
            if(game[0].equals("X"))
                return "X";
            else return "O";
        }
        if(game[3].equals(game[4]) && game[4].equals(game[5])){
            if(game[3].equals("X"))
                return "X";
            else return "O";
        }
        if(game[1].equals(game[4]) && game[4].equals(game[7])){
            if(game[1].equals("X"))
                return "X";
            else return "O";
        }
        if(game[2].equals(game[5]) && game[5].equals(game[8])){
            if(game[2].equals("X"))
                return "X";
            else return "O";
        }
        if(game[6].equals(game[7]) && game[7].equals(game[8])){
            if(game[6].equals("X"))
                return "X";
            else return "O";
        }
        if(game[0].equals(game[4]) && game[4].equals(game[8])){
            if(game[0].equals("X"))
                return "X";
            else return "O";
        }
        if(game[2].equals(game[4]) && game[4].equals(game[6])){
            if(game[2].equals("X"))
                return "X";
            else return "O";
        }
        return "000";
    }

    static void display(String[] game){
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
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] game = new String[9];
        game[0] = "1";
        game[1] = "2";
        game[2] = "3";
        game[3] = "4";
        game[4] = "5";
        game[5] = "6";
        game[6] = "7";
        game[7] = "8";
        game[8] = "9";
        boolean wrongValue = false;
        int choice = 0;
        int moves = 0;
        do{
            do{
                display(game);
                System.out.println("Player 'X', please choose your option to mark");
                choice = sc.nextInt();
                wrongValue = false;
                if(choice < 0 || choice > 9){
                    wrongValue = true;
                    System.out.println("Please enter a vaild input ranging from 1 to 9");
                    display(game);
                }
                if(game[choice - 1].equals("O") || game[choice - 1].equals("X")){
                    System.out.println("This place has already taken, please choose another from remaining places as per image");
                    wrongValue = true;
                }
            }while(wrongValue);
            game[choice - 1] = "X";
            moves++;
            System.out.println("Update game is: ");
            display(game);
            if(winCheck(game).equals("X")){
                System.out.println("Player 'X' won the match");
                break;
            }
            do{
                 System.out.println("Player 'O', please choose your option to mark");
                choice = sc.nextInt();
                wrongValue = false;
                if(choice < 0 || choice > 9){
                    wrongValue = true;
                    System.out.println("Please enter a vaild input ranging from 1 to 9");
                    display(game);
                }
                if(game[choice - 1].equals("O")|| game[choice - 1].equals("X")){
                    System.out.println("This place has already taken, please choose another from remaining places as per image");
                    wrongValue = true;
                    display(game);
                }
            }while(wrongValue);
            game[choice - 1] = "O";
            moves++;
            System.out.println("Update game is: ");
            display(game);
            if(winCheck(game).equals("O")){
                System.out.println("Player 'O' won the match");
                break;
            }
        }while(moves != 9 && winCheck(game).equals("000"));
        if(moves == 9){
            System.out.println("Match Drawn");
        }
        sc.close();
    }
}
