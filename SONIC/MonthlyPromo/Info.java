package work;

import java.util.*;

public class Info {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        String GM = "Sebastian Cortez";

        String jobTitle = " ";

        System.out.println(GM + " please enter a job description for that particular employee: ");
        jobTitle = in.nextLine().toLowerCase();

        switch (jobTitle) {

            case "carhop":
                jobTitle = "carhop";
                break;

            case "shift manager":
                jobTitle = "shift manager";
                break;

            case "asst mngr":
                jobTitle = "assistant manager";
                break;

            case "cook":
                jobTitle = "cook";
                break;

            case "manager":
                jobTitle = "manager";
                break;

            default:
                jobTitle = "carhop";

        }
        System.out.println("Job Description: " + jobTitle);


        String position;

        System.out.println(GM + " please enter a job description for that particular employee: ");

        position = in.nextLine().toLowerCase();

        switch (position) {

            case "supervisor":
                position = "Supervisor";
                break;

            case "gm":
                position = "General Manager";
                break;

            case "associate manager":
                position = "Assistant Manager";
                break;

            case "shift leader":
                position = "Shift Leader";
                break;

            case "crew leader":
                position = "Crew Leader";

            case "crew kitchen":
                position = "Crew - Kitchen";
                break;

            case "crew drive through":
                position = "Crew - Drive Through";
                break;

            case "crew expeditor ":
                position = "Crew - Expeditor";
                break;

            case "Crew":
                position = "Crew";
                break;

            default:
                position = "Crew";


        }
        System.out.println("Position: " + position);

    }
    }
