import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class InputRecipe {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<String> groupRecipeName = new ArrayList<>();
    private ArrayList<String> groupCookingTime = new ArrayList<>();
    private ArrayList<String> inputContainsName = new ArrayList<>();
    private ArrayList<String> matches = new ArrayList<>();
    private ArrayList<Integer> numGroupCookingTime = new ArrayList<>();
    private ArrayList<String> cookingIngredients = new ArrayList<>();
    private String[] recipeName;
    private String[] groups;
    private Recipe recipeClass;
    private StringBuilder[] recipeIngredients = new StringBuilder[3];
    
    public InputRecipe(){
        
    }
    public void inputs() {        
        System.out.print("Files to read: ");
        String fileToRead = scan.nextLine();
        list(fileToRead);
        System.out.println();
        System.out.println("Commands:\nlist - lists the recipes\n"
                                + "stop - stops the program\n"
                                + "find name - searches recipes by name\n"
                                + "find cooking time - searches recipes by cooking time\n"
                                + "find ingredient - searches recipes by ingredient\n");  
        while (true){             
            System.out.print("Enter Commands:");                   
            String commands = scan.nextLine();
            if (commands.equalsIgnoreCase("list")){
                System.out.println("\nRecipes:");
                part1();
                System.out.println();
            }
            else if (commands.equalsIgnoreCase("find name")){
                System.out.print("Searched word: ");
                String word = scan.nextLine().trim();
                System.out.println();
                matches = findName(word);
                if (!matches.isEmpty()){
                    System.out.println("Recipes:");
                    matchings();
                    inputContainsName.clear();
                    
                    System.out.println();
                }
                
            }
            else if (commands.equalsIgnoreCase("find cooking time")){
                System.out.print("Max cooking time: ");
                int maxCookingTime = scan.nextInt();
                scan.nextLine(); //clear buffer
                System.out.println("\nRecipes: ");
                cookingTime(maxCookingTime);
                //when there is an int need scan.nextLine() to clear buffer or else 
                //Enter Commands:Enter Commands: 
            }
            else if (commands.equalsIgnoreCase("find ingredient")){
                System.out.print("Ingredient: ");
                String ingredientInput = scan.nextLine();
                System.out.println("\nRecipes: ");
                //call method here
                findIngredientforRecipe(ingredientInput);
                matchings();
                //System.out.println(cookingIngredients);//good now we can use matching and findnmae method
                //turn our cooking ingredientm maybe into string

            }
            else if (commands.equalsIgnoreCase("stop")){
                break;
            }
        }

    }
    public void list(String recipeNames){
        Path p = Paths.get(recipeNames);        
        try {
            // groupRecipeName.clear();
            // groupCookingTime.clear();
            String text = Files.readString(p);
            groups = text.split("\\n\\s*\\n+");  
            
            for(int i=0; i<groups.length;i++) {
                recipeName = groups[i].split("\n");
                recipeIngredients[i] = new StringBuilder();
                for(int j=0; j< recipeName.length; j++) {
                    if (j == 0) {
                        groupRecipeName.add(recipeName[0].trim());            			
                    }
                    else if (j==1) {
                        groupCookingTime.add(recipeName[1].trim());
                    }
                    else{
                        recipeIngredients[i].append(recipeName[j]+",");
                    }
                }   
            }
            
            //canjust use contains in the part 2
        } 
        catch (Exception e) { 
            System.out.println("Error " + e.getMessage());
        }              
    }
    public ArrayList findName(String input){
        for(String name : groupRecipeName){
	        	String[] nameSplit = name.toLowerCase().split(" ");
	        	for (String word : nameSplit) {
	        		if (word.contains(input) || input.contains(word)){
	        			inputContainsName.add(name);
	        			break;
	        		}
	        	}
	        }                
        return inputContainsName;
    }
    public void part1(){
        for (int i =0; i< groupRecipeName.size();i++) {
                String name = groupRecipeName.get(i);
                String time = groupCookingTime.get(i);
                
                recipeClass = new Recipe(name,time);
                System.out.println(recipeClass);        		
        }
    }
    public void cookingTime(int maxCookingTime){
        for (int i = 0; i < groupCookingTime.size(); i++) {
            int time = Integer.parseInt(groupCookingTime.get(i));
            if (time <= maxCookingTime) {
                recipeClass = new Recipe(groupRecipeName.get(i), groupCookingTime.get(i));
                System.out.println(recipeClass);
            }
        }System.out.println();
    }
    public void matchings(){
        for (int i =0; i< matches.size();i++) {
            for(int j=0; j< groupRecipeName.size();j++) {
                if (matches.get(i).equals(groupRecipeName.get(j))) {
                    recipeClass = new Recipe(groupRecipeName.get(j),groupCookingTime.get(j));
                    System.out.println(recipeClass);
                    break;
                }
            }
        }
    }
    public void findIngredientforRecipe(String input){
        String[] splitByComma;
        cookingIngredients.clear();
        StringBuilder sbInput = new StringBuilder(input);
        for (int i = 0; i < groupRecipeName.size();i++){
            splitByComma = recipeIngredients[i].toString().split(",");
            for (int j = 0; j < splitByComma.length;j++){
                if (sbInput.toString().equalsIgnoreCase(splitByComma[j])){
                    recipeClass = new Recipe(groupRecipeName.get(i),groupCookingTime.get(i));
                    System.out.println(recipeClass);
                    break;
                }
            }
            
        }
        System.out.println();
    }
}