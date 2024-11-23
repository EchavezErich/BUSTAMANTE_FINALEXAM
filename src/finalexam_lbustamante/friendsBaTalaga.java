
package finalexam_lbustamante;


public class friendsBaTalaga {
    private String[] users;         
    private String[][] friendships; 
    private int userCount;          
    private int maxUsers;           

    public friendsBaTalaga(int maxUsers) {
        this.maxUsers = maxUsers;
        this.users = new String[maxUsers];
        this.friendships = new String[maxUsers][maxUsers];
        this.userCount = 0;
    }

    public void addUser(String user) {
        if (userCount < maxUsers) {
            users[userCount++] = user;
            System.out.println(user + " is added.");
        } else {
            System.out.println("Cannot add another user");
        }
    }

    public void addFriendship(String user1, String user2) {
        int index1 = getIndex(user1);
        int index2 = getIndex(user2);

        if (index1 != -1 && index2 != -1) {
            addFriend(index1, user2);
            addFriend(index2, user1);
            System.out.println("Friendship between " + user1 + " and " + user2 + "is added");
        } else {
            System.out.println("Cannot find user");
        }
    }

    public String[] getFriendReco(String user) {
        int userIndex = getIndex(user);
        if (userIndex == -1) {
            System.out.println("Cannot find user");
            return new String[0];
        }

        String[] direct = friendships[userIndex];
        boolean[] isDirectFriend = new boolean[maxUsers];
        for (String friend : direct) {
            if (friend != null) {
                int friendIndex = getIndex(friend);
                isDirectFriend[friendIndex] = true;
            }
        }

        int[] mutualCounts = new int[maxUsers];
        for (String friend : direct) {
            if (friend != null) {
                int friendIndex = getIndex(friend);
                for (String commonFriend : friendships[friendIndex]) {
                    if (commonFriend != null) {
                        int potentialFriendIndex = getIndex(commonFriend);
                        if (!commonFriend.equals(user) && !isDirectFriend[potentialFriendIndex]) {
                            mutualCounts[potentialFriendIndex]++;
                        }
                    }
                }
            }
        }

        String[] reco = new String[maxUsers];
        int recoCount = 0;

        for (int i = 0; i < maxUsers; i++) {
            if (mutualCounts[i] > 0) {
                reco[recoCount++] = users[i];
            }
        }
        
        String[] finalRecommend = new String[recoCount];
        System.arraycopy(reco, 0, finalRecommend, 0, recoCount);
        return finalRecommend;
    }

    private void addFriend(int userIndex, String friend) {
        for (int i = 0; i < friendships[userIndex].length; i++) {
            if (friendships[userIndex][i] == null) {
                friendships[userIndex][i] = friend;
                break;
            }
        }
    }

    private int getIndex(String user) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(user)) {
                return i;
            }
        }
        return -1; 
    }

    public void RedString() {
        System.out.println("Friendship Connections:");
        for (int i = 0; i < userCount; i++) {
            System.out.print(users[i] + "==>");
            for (String frenny : friendships[i]) {
                if (frenny != null) {
                    System.out.print(frenny + " ");
                }
            }
            System.out.println();
        }
    }
}
