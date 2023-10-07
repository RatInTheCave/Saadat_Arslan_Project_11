package Complex_Project;

import java.util.Scanner;

public class Collection_Class {

    public Collection_Class() {
        Count = 0;
        ItemArray = new Item_Class[100];

    }

    private static int Count;
    private static Item_Class[] ItemArray;

    public void TitleList() {
        int i = 0;
        if (Count == 0) {
            System.out.println("There is nothing to show. Please add some miniatures.");
        }
        while (i < Count) {
            Item_Class ChosenMini = ItemArray[i];
            System.out.println(ChosenMini.getTitle());
            i++;
        }

    }

    public void DescriptionList() {
        int i = 0;
        while (i < Count) {
            Item_Class ChosenMini = ItemArray[i];
            System.out.println(ChosenMini.getDescription());
            i++;
        }
    }

    public void add(Item_Class newItem) {
        ItemArray[Count] = newItem;
        Count = Count+1;
    }

    public void remove(int k) {

        if (Count == 0) {
            System.out.println("Collection is empty.");
        } else {
            Item_Class[] ItemArrayMinusOne = new Item_Class[100];
            int j = 0;
            for (int i = 0; i < Count; i++) {
                if (i == k) {
                    System.out.println(" ");
                } else {
                    ItemArrayMinusOne[j] = ItemArray[i];
                    j++;
                }
            }
            ItemArray = ItemArrayMinusOne;
            Count--;
            System.out.println("...Miniature removed...");
        }
    }

    public Item_Class ItemCreation() {

        return new Item_Class(
                Collection_Class.GetUserString("What is the name of your miniature?"),
                Collection_Class.GetUserString("What is the color of your miniature?"),
                Collection_Class.GetUserInt("What is the size of the base (in millimeters) of your miniature?"),
                Collection_Class.GetUserBoolean("Does your miniature have a coat of varnish for protection? true/false"));
    }

    public void sort() {
        for (int i = 0; i < Count; i++) {
            for (int j = 1; j < Count; j++) {
                if (ItemArray[j].getBaseSize() < ItemArray[j - 1].getBaseSize()) {
                    BubbleSwap(ItemArray, j, j - 1);
                }
            }
        }
    }
    public void ChooseSearch() {
        boolean MenuFlag = false;
        int SearchCount = 0;
        while (!MenuFlag) {
            String userChoice = GetUserString("""
                    Choose which search method you prefer:\s
                    1. By name:\s
                    2. By color: \s
                    3. By the size of the base: \s
                    4. By presence of varnish: \s
                    """);
            if (userChoice.toLowerCase().contains("name")) {
                SearchCount = 1;
                MenuFlag = true;
            } else if (userChoice.contains("1")) {
                SearchCount = 1;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("color")) {
                SearchCount = 2;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("2")) {
                SearchCount = 2;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("base")) {
                SearchCount = 3;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("3")) {
                SearchCount = 3;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("varnish")) {
                SearchCount = 4;
                MenuFlag = true;
            } else if (userChoice.toLowerCase().contains("4")) {
                SearchCount = 4;
                MenuFlag = true;
            }
        }
        find(SearchCount);
    }


    public void find(int SearchCount) {
        if (SearchCount == 0) {
            System.exit(0);
        } else if (SearchCount == 1) {
            String s = GetUserString("Please write the name of the miniature you're looking for");
            findByName(s);
        } else if (SearchCount == 2) {
            String r = GetUserString("Please write the color of the miniature you're looking for");
            findByColor(r);
        } else if (SearchCount == 3) {
            int t = GetUserInt("Please write the size of the base of the miniature you're looking for");
            findByBaseSize(t);
        }
        else if (SearchCount == 4) {
            boolean u = GetUserBoolean("Does the miniature you're looking for have a coat of varnish?");
            findByVarnish(u);
        }
    }

    public void findByName(String s) {
        for (int i = 0; i < Count; i++) {
            if (ItemArray[i].getName().toLowerCase().contains(s.toLowerCase())) {
                System.out.println(i + 1 + ". " + "A " + ItemArray[i].getColor().toLowerCase() + " " + ItemArray[i].getName() + " " + " with a " + ItemArray[i].getBaseSize() + " millimeter base, has " + ItemArray[i].Varnish());

            }
        }
    }

    public void findByColor(String r) {
        for (int i = 0; i < Count; i++) {
            if (ItemArray[i].getColor().toLowerCase().contains(r.toLowerCase())) {
                System.out.println(i + 1 + ". " + "A " + ItemArray[i].getColor().toLowerCase() + " " + ItemArray[i].getName() + " " + " with a " + ItemArray[i].getBaseSize() + " millimeter base, has " + ItemArray[i].Varnish());

            }
        }
    }

    public void findByBaseSize(int t) {
        for (int i = 0; i < Count; i++) {
            if (ItemArray[i].getBaseSize() == (t)) {
                System.out.println(i + 1 + ". " + "A " + ItemArray[i].getColor().toLowerCase() + " " + ItemArray[i].getName() + " " + " with a " + ItemArray[i].getBaseSize() + " millimeter base, has " + ItemArray[i].Varnish());            }
        }
    }
    public void findByVarnish(Boolean u) {
        for (int i = 0; i < Count; i++) {
            if (ItemArray[i].HasVarnish == (u)) {
                System.out.println(i + 1 + ". " + "A " + ItemArray[i].getColor().toLowerCase() + " " + ItemArray[i].getName() + " " + " with a " + ItemArray[i].getBaseSize() + " millimeter base, has " + ItemArray[i].Varnish());
            }
        }
    }
    public static void BubbleSwap(Item_Class[] array, int a, int b) {
        Item_Class temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int GetUserInt(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println(systemMessage);
        return userScanner.nextInt();
    }

    public static String GetUserString(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println(systemMessage);
        return userScanner.nextLine();
    }

    public static boolean GetUserBoolean(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println(systemMessage);
        return userScanner.nextBoolean();
    }

    public void readFromFile(){
        String fileContent = FileIO.readFromFile("miniaturesList.txt");
        boolean bool;
        int baseSize;
        String[] Lines = fileContent.split("\r\n");
        for (String arrayElement : Lines) {
            String[] oneItem = arrayElement.split(";");
            if (oneItem[3].equals("no varnish"))
                bool = false;
            else bool = true;
            baseSize = Integer.parseInt(oneItem[2]);
            Item_Class obj = new Item_Class(oneItem[0],oneItem[1],baseSize,bool);
            this.add(obj);
        }



    }

    public void saveToFile(){
        int i = 0;
        if (Count==0){
            System.out.println("There is nothing to write, please add some miniatures.");
            return;
        }
        while (i < Count) {
            Item_Class ChosenMini = ItemArray[i];
            FileIO.saveToFile(ChosenMini.getStringForExport(),"miniaturesList.txt");
            i++;
        }
        System.out.println("File is stored in project folder: miniaturesList.txt");

    }
}
