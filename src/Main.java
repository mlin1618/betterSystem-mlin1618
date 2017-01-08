import java.util.*;

public class Main {
    public static void main(String[] args){
        Customer You;
        int mCount = 0;
        int eCount = 0;
        System.out.println("Welcome to the Gym!");
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String n = sc.nextLine();
        System.out.println("What is your SSN?");
        int s = sc.nextInt();
        System.out.println("What is your weight?");
        double w = sc.nextDouble();
        while(true) {
            sc.nextLine();
            System.out.println("Are you a (1) Regular Customer, (2) Member, or (3) Employee? (Enter 1, 2, or 3)");
            String type = sc.nextLine();
            if (type.equals("1")) {
                You  = new Regular(s, n, w);
                break;
            }
            else if(type.equals("2")){
                You  = new Member(s, n, w);
                break;
            }
            else if(type.equals("3")){
                You  = new Employee(s, n, w);
                break;
            }
            else{
                System.out.println("You had one job. 1, 2, or 3. Try again.");
            }
        }
        loop1:while(true){
            System.out.println("What would you like to do?");
            System.out.println("(1) Get Membership \n (2) Class \n (3) Retail \n (4) Aquatics \n (5) Personal Trainer \n (6) Become Employee \n (7) Print Bill \n (8) Print Visit Record \n (9) Print Weight Data  \n (10) Exit");
            String todo = sc.nextLine();
            switch(todo){
                case "1":
                    if(You.prices[0]>0){
                        System.out.println("You spent " + You.prices[0] + " to become a member.");
                        You.getMembership();
                    }
                    else{
                        System.out.println("You are already a member.");
                        mCount++;
                        if(mCount >= 3){
                            System.out.println("Your membership has been revoked for trying to screw with the system.");
                            You.loseMembership();
                            mCount = 0;
                        }
                    }
                    break;
                case "2":
                    System.out.println("How long is the class you want to take?");
                    Scanner sc2 = new Scanner(System.in);
                    double lengthclass = sc2.nextDouble();
                    You.takeClass(lengthclass);
                    System.out.println("You have taken the class for " + You.prices[1] + " dollars.");
                    break;
                case "3":
                    System.out.println("How much money are you spending in retail?");
                    Scanner sc3 = new Scanner(System.in);
                    double saleprice = sc3.nextDouble();
                    You.purchaseRetail(saleprice);
                    System.out.println("You have spent " + (saleprice * (1 + You.prices[2])) + " dollars on retail.");
                    break;
                case "4":
                    System.out.println("How long will you spend doing aquatics (in hours)?");
                    Scanner sc4 = new Scanner(System.in);
                    double aquaticstime = sc4.nextDouble();
                    if(You.prices[3] < 0){
                        System.out.println("UPGRADE TO MEMBERSHIP FOR ACCESS TO AQUATICS.");
                    }
                    else{
                        You.aquatics(aquaticstime);
                        System.out.println("You have spent " + You.prices[3] + " dollars on aquatics.");
                    }
                    break;
                case "5":
                    You.personalTrainer();
                    System.out.println("You have spent " + You.prices[4] + " dollars for a 1 hour personal trainer");
                    break;
                case "6":
                    if(You.employed){
                        System.out.println("You are already employed.");
                        eCount++;
                        if(eCount >= 3){
                            System.out.println("\n You're fired.");
                            You.getFired();
                            eCount = 0;
                        }
                    }
                    else{
                        You.getEmployed();
                        System.out.println("You are now employed.");
                    }
                    break;
                case "7":
                    You.printBill();
                    break;
                case "8":
                    You.printVisits();
                    break;
                case "9":
                    System.out.println("Current weight: " + You.weight + "pounds.");
                    System.out.println("You have lost: " + You.weightLost() + " pounds.");
                    break;
                case "10":
                    System.out.println("Come again!");
                    break loop1;
                default:
                    System.out.println("Invalid, try again.");
                    break;
            }
        }
    }
}
