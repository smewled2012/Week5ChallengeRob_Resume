package com.seme.org;

/* The program displays in a resume format after accepting inputs from the user \
* Asks the user to enter his name, email, phone number, multiple educational background, Experience and skills he posses,
* then saves the information in the file and asks the user if he want to do resume of more person
  * It then asks if the user wants to update the name and email of specific person
   * It asks to enter the name of the person the information to be updated and the program then updates it.
   * then Finally it displays the updated resume of all the persons inserted
   * */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Rob_Resume {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        String addPerson;
        do {

            // create a person object

            Rob_Resume obj = new Rob_Resume();

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
                person.addEducations(education);

            } while (addEdu.equalsIgnoreCase("yes"));


            //creating multiple Experience

            System.out.println("*****Adding Experience *****");

            String addExp;
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
                addExp = input.nextLine();

            } while (addExp.equalsIgnoreCase("yes"));


            // adding Skills to the person  ********************
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

            // a method which writes the person object into a file

            obj.serializePerson(person);
            people.add(person);


            System.out.println("Do you want to do a resume for more person? yes/ no");
            addPerson=input.nextLine();

        }while(addPerson.equalsIgnoreCase("yes"));


        // displaying the output of Profile, Education and Experience, skills for multiple person

            for(Person person:people) {
                System.out.println("=========================================================");
                // method for displaying the Resume
                displayResume(person);

            }

        //*** updating the name, email and phone number ****

        System.out.println("**********************Updating a resume Option *********************");
        System.out.println("Do you need to update the profile of the resume of the person? yes/no ");
        String update = input.nextLine();
        if(update.equalsIgnoreCase("yes")){
            System.out.println("Enter the name of the person to be searched to update :");
            String uName= input.nextLine();
            Person person1= new Person();
            person1=findPersonByName(uName,people);
            System.out.println("Enter the name to be updated too :");
            String newName= input.nextLine();
            System.out.println("Enter the email address to be updated to: ");
            String newEmail = input.nextLine();
            //  updateInformation(newName,newEmail,person1);
            person1.setName(newName);
            person1.setEmail(newEmail);

            System.out.println("************* The Updated Person Resume ************************");
            // method for displaying the Resume
            displayResume(person1);

            System.out.println("**************** The updated total Resume **************");
            for(Person updatedPerson: people){
                System.out.println("==============******============*****===============================");
                // method for displaying the Resume
                displayResume(updatedPerson);
            }


            Rob_Resume obj=new Rob_Resume();
            obj.serializePerson(person1);



        }
        else{
            System.out.println("Thank You for Your Information ! Good Bye !!!");
        }


    }

    // a method which displays resume
    private static void displayResume(Person person) {
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

    // method which finds a person by name to update its information
    private static Person findPersonByName(String uName, ArrayList<Person> people) {
        Person personFound =null;
        for(Person eachPerson:people){
            if(eachPerson.getName().equalsIgnoreCase(uName))
                personFound=eachPerson;

        }
        return  personFound;
    }

    // a method that saves the object in file in the given file path

    private void serializePerson(Person person)  {
        FileOutputStream fout =null;
        ObjectOutputStream oos =null;

        try{
            fout = new FileOutputStream("c:\\\\temp\\\\person.ser");
            oos =new ObjectOutputStream(fout);
            oos.writeObject(person);
            System.out.println("File Saving Done !!");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(fout !=null){
                try{
                    fout.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(oos!=null){
                    try {
                        oos.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }


            }


        }
    }
}


