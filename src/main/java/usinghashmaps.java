import java.util.HashMap;
import java.util.Map;
public class usinghashmaps {

    public static void main() {

        // Create HashMap to store key-value pairs
        Map<String, String> employeeDetails = new HashMap<>();

        // Put data into the map
        employeeDetails.put("Name", "Amit");
        employeeDetails.put("Designation", "QA Head");
        employeeDetails.put("Company", "TOI");

        // Print individual values
        System.out.println("Name: " + employeeDetails.get("Name"));
        System.out.println("Designation: " + employeeDetails.get("Designation"));
        System.out.println("Company: " + employeeDetails.get("Company"));

        // (Optional) Print all key-value pairs using for-each
        System.out.println("\nAll entries in map:");
        for (Map.Entry<String, String> entry : employeeDetails.entrySet()) {  // entrySet iteration[web:61][web:63]
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
