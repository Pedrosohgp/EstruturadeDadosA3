import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

enum ConditionSeverity {
    LOW, MEDIUM, HIGH, EMERGENCY
 }

public class main {
    public static void main(String[] args) {
       Queue<Patient> hospitalQueue = new PriorityQueue<>();
       Scanner scanner = new Scanner(System.in);


       int option;
       do {
           displayMenu();
           option = scanner.nextInt();
           scanner.nextLine(); 


           switch (option) {
               case 1:
                   addPatient(scanner, hospitalQueue);
                   System.out.println();


                   break;
               case 2:
                   removePatient(hospitalQueue);
                   System.out.println();


                   break;
               case 3:
                   if (!hospitalQueue.isEmpty()) {
                       showQueue(hospitalQueue);
                   } else {
                       System.out.println("The queue is empty.");
                   }
                   System.out.println();


                   break;
               case 4:
                   System.out.println("Exiting the system...");
                   System.out.println();


                   break;
               default:
                   System.out.println("Invalid option.");
                   System.out.println();


                   break;
           }
       } while (option != 4);
       scanner.close();
    }
 
 
    private static void displayMenu() {
        System.out.println("1 - Add patient to the queue");
        System.out.println("2 - Remove patient from the queue");
        System.out.println("3 - Show the queue");
        System.out.println("4 - Exit");
        System.out.println("Choose an option: ");
        System.out.println();
    }
 
 
    private static void addPatient(Scanner scanner, Queue<Patient> hospitalQueue) {
        System.out.println("Enter the patient's name:");
        String name = scanner.nextLine();
 
 
        System.out.println("Enter the patient's age:");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        ConditionSeverity conditionSeverity;
        while (true) {
            System.out.println("Enter the patient's condition severity:");
            System.out.println("1 - LOW");
            System.out.println("2 - MEDIUM");
            System.out.println("3 - HIGH");
            System.out.println("4 - EMERGENCY");
 
 
            int severity = scanner.nextInt();
            scanner.nextLine(); 
            switch (severity) {
                case 1:
                    conditionSeverity = ConditionSeverity.LOW;
                    break;
                case 2:
                    conditionSeverity = ConditionSeverity.MEDIUM;
                    break;
                case 3:
                    conditionSeverity = ConditionSeverity.HIGH;
                    break;
                case 4:
                    conditionSeverity = ConditionSeverity.EMERGENCY;
                    break;
                default:
                    System.out.println("Invalid severity level. Please try again.");
                    continue;
           }
           break;
       }


       hospitalQueue.add(new Patient(name, age, conditionSeverity));
       System.out.println("Patient added to the queue.");
   }


   private static void removePatient(Queue<Patient> hospitalQueue) {
       if (!hospitalQueue.isEmpty()) {
           Patient patient = hospitalQueue.poll();
           System.out.println("Patient removed from the queue:");
           System.out.println("Name: " + patient.getName());
           System.out.println("Age: " + patient.getAge());
           System.out.println("Condition severity: " + patient.getConditionSeverity());


       } else {
           System.out.println("The queue is empty.");
       }
   }


   private static void showQueue(Queue<Patient> hospitalQueue) {
       System.out.println("Patients in the hospital queue:");
             for (Patient patient : hospitalQueue) {
           System.out.println("Name: " + patient.getName());
           System.out.println("Age: " + patient.getAge());
           System.out.println("Condition severity: " + patient.getConditionSeverity());
           System.out.println();


       }
   }
}


