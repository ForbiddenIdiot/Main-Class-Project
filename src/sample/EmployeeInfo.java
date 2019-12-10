/*
 * Angel Molina
 * 12/8/19
 * Contains code for EmployeeInfo class (Class project)
 */

package sample;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeInfo {
    StringBuilder name;
    String code;

    String deptId;
    Pattern p;
    Scanner in;

    public EmployeeInfo () {
        in = new Scanner(System.in);
        setName(new StringBuilder(inputName()));
        createEmployeeCode(name);
        System.out.print("Please enter the department ID of the new employee: ");
        setDeptId(in.nextLine());
        in.close();
    } // end constructor

    public StringBuilder getName() {
        return name;
    } // end method getName
    public String getCode() {
        return code;
    } // end method getCode
    private void setName(StringBuilder name) {
        this.name = name;
    } // end method setName
    private void createEmployeeCode(StringBuilder name) {
        setName(name);
        code = name.substring(0, 2) + name.length();
    } // end method createEmployeeCode
    private String inputName() {
        System.out.print("Please enter a name: ");
        String name = in.nextLine();
        return name;
    } // end method inputName
    private boolean checkName(StringBuilder name) {
        return (getName().equals(name));
    } // end method checkName

    public String getDeptId() {
        return deptId;
    } // end method
    private void setDeptId(String newId) {
        deptId = newId;
    } // end method
    private String getId() {
        return deptId;
    } // end method
    private boolean validId(String id) {
        return true;
    } // end method

    public String toString() {
        return "\n\nEmployee Code: " + getCode() + ", Dept ID: " + getDeptId();
    }

    public String reverseString(String id) {

        if (!validId(getId()))
            return "N/A (Invalid ID)";

        if (id.isEmpty()){
            return id;
        }
        //Calling Function Recursively
        //System.out.println("String to be passed in Recursive Function: "+id.substring(1));
        return reverseString(id.substring(1)) + id.charAt(0);

    }

} // end class EmployeeInfo
