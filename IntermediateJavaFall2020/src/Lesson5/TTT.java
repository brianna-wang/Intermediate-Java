package Lesson5;

import java.util.Scanner;

public class TTT {
    static char[][]board=new char[3][3];
    static char currentPlayer='X';
    static void initBoard(char[][] b){
        for(int r=0;r<b.length;r++){
            for(int c=0;c<b[r].length;c++){
                b[r][c]='_';
            }
        }
    }
    public static void main (String[] args){
        System.out.println("Welcome to my awesome TTT!");
        initBoard(board);
        printBoard();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("Player " + currentPlayer + ", " + "enter row number and column number to place your piece (0/1/2)");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] != '_') {
                System.out.println("space is taken");
                continue;
            }
            board[row][col] = currentPlayer;
            if (checkWin(row,col)) {
                System.out.println(currentPlayer + ", you won!");
                break;
            }
            if(checkTie()){
                System.out.println("It's a tie");
                break;
            }
            printBoard();
            if(currentPlayer=='X'){
                currentPlayer='O';
            }
            else{
                currentPlayer='X';
            }
        }
    }

    static boolean checkTie(){
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                if(board[r][c]=='_'){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkWin(int r, int c){
        if(board[r][0]!='_'&&board[r][0]==board[r][1]&&board[r][0]==board[r][2]){
            return true;
        }
        if (board[0][c]!='_'&&board[0][c]==board[1][c]&&board[0][c]==board[2][c]){
            return true;
        }
        if(board[1][1]!='_'&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]){
            return true;
        }
        if (board[1][1]!='_'&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]){
            return true;
        }
        return false;
    }
    static void printBoard(){
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    }
}
