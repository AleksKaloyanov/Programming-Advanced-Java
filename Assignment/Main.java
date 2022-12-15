//package Assignment;
//
//import javax.swing.text.DateFormatter;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//        String path = "C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\Assignment\\input.csv";
//        BufferedReader reader = null;
//
//        try {
//            reader = new BufferedReader(new FileReader(path));
//
//            List<Employee> employees = new ArrayList<>();
//
//            String line = "";
//            reader.readLine();
//
//            while ((line = reader.readLine()) != null) {
//                String[] tokens = line.split(",");
//                String empID = tokens[0];
//                String projectID = tokens[1];
//                DateFormatter df = new DateFormatter("dd-MM-yyyy");
//                LocalDate dateFrom = LocalDate.parse(tokens[2]);
//                LocalDate dateTo;
//                if (tokens[3].equals("NULL")) {
//                    dateTo = LocalDate.now();
//                } else {
//                    dateTo = LocalDate.parse(tokens[3]);
//                }
//
////                Project project = new Project(projectID, dateFrom, dateTO);
//
//                if (employeeExists(employees, empID)) {
////                    addProject(employees, empID, project);
//                } else {
//                    Employee employee = new Employee(empID);
////                    employee.addProject(project);
//                    employees.add(employee);
//                }
//            }
//            System.out.println();
//            ;
//            for (int i = 0; i < employees.size() - 1; i++) {
//                Employee current = employees.get(i);
//                for (int j = i + 1; j < employees.size(); j++) {
//                    Employee next = employees.get(j);
//                    for (Project project : current.getProjects()) {
//                        for (Project nextProject : next.getProjects()) {
//                        }
//                    }
//                }
//            }
//
//        } catch (IOException exception) {
//            System.err.println("bad document");
////        } catch (ParseException e) {
////            throw new RuntimeException(e);
//        }
//    }
//
//    private static void addProject(List<Employee> employees, String empID, Project project) {
//        for (Employee employee : employees) {
//            if (employee.getId().equals(empID)) {
//                employee.addProject(project);
//            }
//        }
//    }
//
//    private static boolean employeeExists(List<Employee> employees, String empID) {
//        for (Employee employee : employees) {
//            if (employee.getId().equals(empID)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
