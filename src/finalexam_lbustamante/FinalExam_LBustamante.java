
package finalexam_lbustamante;

import java.util.Scanner;


public class FinalExam_LBustamante {

    
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
        friendsBaTalaga fbt = new friendsBaTalaga(15);

        while (true) {
            System.out.println("\nOPTIONS: \n");
            System.out.println("Press 1 to Add User");
            System.out.println("Press 2 to Add Friendship");
            System.out.println("Press 3 to Print Network");
            System.out.println("Press 4 to Get Friend Recommendations");
            System.out.println("Press 5 to Exit");
            System.out.print("Your Input: ");
            int select = scn.nextInt();
            scn.nextLine(); 

            switch (select) {
                case 1:
                    System.out.print("Enter user name: ");
                    String user = scn.nextLine();
                    fbt.addUser(user);
                    break;

                case 2:
                    System.out.print("Enter user one's name: ");
                    String user1 = scn.nextLine();
                    System.out.print("Enter user two's name: ");
                    String user2 = scn.nextLine();
                    fbt.addFriendship(user1, user2);
                    break;

                case 3:
                    fbt.RedString();
                    break;

                case 4:
                    System.out.print("Which user would you like to recommend? ");
                    String userForReco = scn.nextLine();
                    String[] recomm = fbt.getFriendReco(userForReco);
                    if (recomm.length == 0) {
                        System.out.println("No recommendation");
                    } else {
                        System.out.println("Friend recommendation:");
                        for (String recommend : recomm) {
                            System.out.println(recommend);
                        }
                    }
                    break;

                case 5:
                    scn.close(); 
                    return;
            }
        }
    }
    
}
