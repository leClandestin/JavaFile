This program manages and searches recipes from a text file. Users can:

List all recipes with their cooking times.

Search recipes by name (keywords).

Search recipes by cooking time — shows recipes with time equal to or less than the given limit.

Search recipes by ingredient — finds all recipes that include a specific ingredient.

Recipe: Represents a recipe with a name and cooking time.

InputRecipe: Reads the file, stores recipe names, cooking times, and ingredients, and handles user commands.

RecipeSearch: Starts the program and interacts with the user.



Program Demonstration Example:

File to read: recipes.txt

Commands:
list - lists the recipes
stop - stops the program
find name - searches recipes by name
find cooking time - searches recipes by cooking time
find ingredient - searches recipes by ingredient

Enter command: list

Recipes:
Pancake dough, cooking time: 60
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command: find name
Searched word: roll

Recipes:
Tofu rolls, cooking time: 30

Enter command: find cooking time
Max cooking time: 30

Recipes:
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command: find ingredient
Ingredient: sugar

Recipes:
Pancake dough, cooking time: 60

Enter command: find ingredient
Ingredient: egg

Recipes:
Pancake dough, cooking time: 60
Meatballs, cooking time: 20

Enter command: find ingredient
Ingredient: gg

Recipes:

Enter command:  stop