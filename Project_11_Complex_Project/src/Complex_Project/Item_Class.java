package Complex_Project;

public class Item_Class {


        public Item_Class(String newName, String newColor, int newBaseSize, boolean newHasVarnish) {
        color = newColor;
        name = newName;
        BaseSize = newBaseSize;
        HasVarnish = newHasVarnish;

    }

    public String getDescription() {
        return "A " + getColor() + " " + getName() + " miniature with base size of " + getBaseSize() + " millimeters. \n" +
                "The color is: " + getColor().toLowerCase() + "\n" +
                "The name is: " + getName() + "\n" +
                "The base size is: " + getBaseSize() + "\n" +
                "The miniature has " + Varnish() + "\n";

    }

    public String getStringForExport() {
        String BreakSymbol = ";";
        return getName() + BreakSymbol + getColor() + BreakSymbol + getBaseSize() + BreakSymbol + Varnish() + BreakSymbol;

    }
    public String getTitle() {
        return "A " + getColor().toLowerCase() + " " + getName() + " miniature with a base size of " + getBaseSize() + " millimeters, has " + Varnish();
    }
    public Boolean HasVarnish;
    private final String color;
    private final String name;
    private final int BaseSize;

    public String getColor() {
        return color;
    }

    public int getBaseSize() {
        return BaseSize;
    }

    public String getName() {
        return name;
    }

    public String Varnish(){
        String VarnishString;
        if (HasVarnish){
            VarnishString = "varnish";
        }
        else{
            VarnishString = "no varnish";
        }
        return VarnishString;
    }

}
