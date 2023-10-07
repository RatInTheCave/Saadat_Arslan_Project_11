package Complex_Project;

public class User_Dialogue {
    public static void main(String[] args) {
        boolean exitFlag = false;
        while (!exitFlag) {

            exitFlag = executeMenuChoice(Options(), exitFlag);

        }
    }


    public static int Options() {
        boolean MenuFlag = false;
        int ChoiceCount = 0;
        String userChoice;
        while (!MenuFlag) {
            userChoice = Collection_Class.GetUserString("""
                     
                     Welcome to the collection menu, please choose one of the following items:
                     1. Print the short description of each miniature in the collection.
                     2. Add a miniature.
                     3. Remove a miniature.
                     4. Sort miniatures by base size.
                     5. Choose search option (by color, by base size, by name, by presence of varnish).
                     6. Print the detailed description of each miniature in the collection.
                     7. Read miniatures from file.
                     8. Save miniatures to file.
                     9. Exit.
                    """);
            if (userChoice.toLowerCase().contains("short")) {
                ChoiceCount = 1;
                MenuFlag = true;
            } else if (userChoice.contains("1")) {
                MenuFlag = true;
                ChoiceCount = 1;
            } else if (userChoice.toLowerCase().contains("add")) {
                ChoiceCount = 2;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("2")) {
                ChoiceCount = 2;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("remove")) {
                ChoiceCount = 3;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("3")) {
                ChoiceCount = 3;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("sort")) {
                ChoiceCount = 4;
                MenuFlag = true;
            } else if (userChoice.contains("4")) {
                ChoiceCount = 4;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("search")) {
                ChoiceCount = 5;
                MenuFlag = true;
            } else if (userChoice.contains("5")) {
                ChoiceCount = 5;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("detailed")) {
                ChoiceCount = 6;
                MenuFlag = true;
            } else if (userChoice.contains("6")) {
                ChoiceCount = 6;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("read")) {
                ChoiceCount = 7;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("7")) {
                ChoiceCount = 7;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("save")) {
                ChoiceCount = 8;
                MenuFlag = true;
            } else if (userChoice.contains("8")) {
                ChoiceCount = 8;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("exit")) {
                ChoiceCount = 9;
                MenuFlag = true;
            } else if (userChoice.contains("9")) {
                ChoiceCount = 9;
                MenuFlag = true;
            }
        }
        return ChoiceCount;
    }
    public static Collection_Class ItemArray = new Collection_Class();


    public static boolean executeMenuChoice(int menuItem, boolean exitFlag) {
        switch (menuItem) {
            case 1 -> ItemArray.TitleList();
            case 2 -> ItemArray.add(ItemArray.ItemCreation());
            case 3 -> ItemArray.remove(Collection_Class.GetUserInt("Please enter the element of the collection you wish to remove (starts with 0)"));
            case 4 -> ItemArray.sort();
            case 5 -> ItemArray.ChooseSearch();
            case 6 -> ItemArray.DescriptionList();
            case 7 -> ItemArray.readFromFile();
            case 8 -> ItemArray.saveToFile();
            case 9 -> exitFlag = true;
        }
        return exitFlag;
    }
}

