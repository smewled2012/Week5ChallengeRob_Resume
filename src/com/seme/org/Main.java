package com.seme.org;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Education> educations = new ArrayList<>();

        String addPerson;
        do {

            // create a person object

            System.out.println("Enter name : ");
            String name = input.nextLine();
            System.out.println("Enter email addresss : ");
            String email = input.nextLine();
            System.out.println("Enter phone number :");
            String phone = input.nextLine();
            Person person = new Person();
            person.setName(name);
            person.setEmail(email);
            person.setPhone(phone);

            // creating multiple Education for each person

            System.out.println("*****Adding Education *****");
            String addEdu;
            do {
                Education education = new Education();
                System.out.println("Enter the school you attended : ");
                String school = input.nextLine();
                System.out.println("Enter the year of graduation :");
                String year = input.nextLine();
                System.out.println("Enter the degree :");
                String degree = input.nextLine();
                System.out.println("Enter your major :  ");
                String major = input.nextLine();
                education.setSchool(school);
                education.setYear(year);
                education.setDegree(degree);
                education.setMajor(major);

                System.out.println("Do you want to add more Education ? yes/no");
                addEdu = input.nextLine();
                //  educations.add(education);
                person.addEducations(education);

            } while (addEdu.equalsIgnoreCase("yes"));


            //creating multiple Experience

            System.out.println("*****Adding Experience *****");

            String addexp;
            do {
                Experience experience = new Experience();
                System.out.println("Enter the company :");
                String company = input.nextLine();
                System.out.println("Enter the title: ");
                String title = input.nextLine();
                System.out.println("Enter the start Date :");
                String start = input.nextLine();
                System.out.println("Enter the end Date :");
                String end = input.nextLine();
                experience.setCompany(company);
                experience.setTitle(title);
                experience.setStartDate(start);
                experience.setEndDate(end);

                System.out.println("Adding Duties: ");
                String addDuty;
                do {
                    Duty duty = new Duty();
                    System.out.println("Enter your duty :");
                    String duty1 = input.nextLine();
                    duty.setActivity(duty1);
                    experience.addDuties(duty);
                    System.out.println("Do you have more duties ? yes/ no");
                    addDuty = input.nextLine();
                } while (addDuty.equalsIgnoreCase("yes"));

                person.addExperience(experience);
                System.out.println("Do you wanna add more Experience ? yes/no");
                addexp = input.nextLine();

            } while (addexp.equalsIgnoreCase("yes"));


            // adding Skills to the person
            System.out.println("*****Adding Skills ******");
            String addSkill;
            do {
                Skill skill = new Skill();
                System.out.println("Enter the skill :");
                String skill1 = input.nextLine();
                System.out.println("Enter your level from the option: \nFundamental \nNovice \nIntermediate \nAdvanced \nExpert");
                String rating = input.nextLine();
                skill.setSkill(skill1);
                skill.setRating(rating);

                System.out.println("Do you have more Skills ? yes/no");
                addSkill = input.nextLine();
                person.addSkill(skill);

            } while (addSkill.equalsIgnoreCase("yes"));

            people.add(person);


            // displaying the output of Profile, Education, Experience and skill for a person
           /* System.out.println("===========================================");

            System.out.println(person.getName() + "\n" + person.getEmail() + "\n" + person.getPhone());
            System.out.println("\n");
            System.out.println("Education:");
            for (Education edu : person.getListEducation()) {
                System.out.println(edu.getDegree() + " in " + edu.getMajor() + "," + "\n" +
                        edu.getSchool() + " University, " + edu.getYear() + "\n");
            }

            ArrayList<Experience> eachExperience = person.getListExperience();
            System.out.println("Experience: ");
            for (Experience exp : eachExperience) {
                System.out.println(exp.getTitle() + "\n" + exp.getCompany() + ", " + exp.getStartDate() + " - "
                        + exp.getEndDate());
                // for loop for the duty
                int count = 1;
                for (Duty eachDuty : exp.getListDuty()) {
                    System.out.println(" - Duty " + count + ", " + eachDuty.getActivity() + "\n");
                    count++;
                }
            }
            System.out.println("Skills: ");
            for (Skill eachSkill : person.getListSkills()) {
                System.out.println(eachSkill.getSkill() + ", " + eachSkill.getRating());
            }*/

            System.out.println("Do you want to do a resume for more person? yes/ no");
            addPerson=input.nextLine();

        }while(addPerson.equalsIgnoreCase("yes"));


        // displaying the output of Profile, Education and Experience, skills for multiple person
            System.out.println("===========================================");

            for(Person person:people) {

                System.out.println(person.getName() + "\n" + person.getEmail() + "\n" + person.getPhone());
                System.out.println("\n");
                System.out.println("Education:");
                for (Education edu : person.getListEducation()) {
                    System.out.println(edu.getDegree() + " in " + edu.getMajor() + "," + "\n" +
                            edu.getSchool() + " University, " + edu.getYear() + "\n");
                }

                ArrayList<Experience> eachExperience = person.getListExperience();
                System.out.println("Experience: ");
                for (Experience exp : eachExperience) {
                    System.out.println(exp.getTitle() + "\n" + exp.getCompany() + ", " + exp.getStartDate() + " - "
                            + exp.getEndDate());
                    // for loop for the duty
                    int count = 1;
                    for (Duty eachDuty : exp.getListDuty()) {
                        System.out.println(" - Duty " + count + ", " + eachDuty.getActivity());
                        count++;
                    }
                    System.out.println("\n");
                }
                System.out.println("Skills: ");
                for (Skill eachSkill : person.getListSkills()) {
                    System.out.println(eachSkill.getSkill() + ", " + eachSkill.getRating());
                }
            }

            // writing the object into the file


    }
}


