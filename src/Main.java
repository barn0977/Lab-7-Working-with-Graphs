import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 Want Graph Text File Converted Into Graph");
            System.out.println("2 Exit The Program");
            System.out.print("Enter A Number Choice: ");

            String in = scanner.nextLine();

            if (in.equals("1")) {
                System.out.print("Enter The File's Names: ");
                String fileName = scanner.nextLine();
                String filePath = "datafiles/" + fileName;

                //This just makes sure that the file that is being called actually exists
                //This was for testing purpose for finding what to call for getting the file
//                System.out.println("Trying To Read: "+ new java.io.File(filePath).getAbsolutePath());
//                System.out.println("File Exists: " + new java.io.File(filePath).exists());

                AdjList adjL = new AdjList();
                AdjMatrix adjM = new AdjMatrix();

                GraphReader reader = new GraphReader();
                boolean success = reader.readGraph(filePath, adjL, adjM);

                if (success) {
                    System.out.println("_______The_Adjacency_List_______");
                    adjL.printGraph();
                    System.out.println("_______The_Adjacency_Matrix_______");
                    adjM.printGraph();
                    System.out.println("_______The_Breadth_First_Search_______");
                    String startVertex = reader.getStartVertex(adjL);
                    BreadthFirst.BreadthFirstSearch(adjL, startVertex);
                    System.out.println();
                }
            } else if (in.equals("2")) {
                System.out.println("Exiting The Program");
                break;
            }
            else {
                System.out.println("Try Again, Select From One Of The Numbers");
            }
        }
        scanner.close();
    }
}