

public class Ch10Assignment1 {

    public static void main(String[] args) {
        String str = "Hong Kong (CNN) -- Thousands of demonstrators bracing for the possibility of a police crackdown packed streets in the heart of Hong Kong early Tuesday. Protesters had masks, protective goggles and plastic raincoats on hand as they camped out on the main thoroughfare leading into the city's central business district around 3 a.m. Tuesday, about 24 hours after officers had fired tear gas and pepper spray at the crowd. \"They're all ready just in case there is any sort of move by the Hong Kong police,\" CNN's Andrew Stevens reported.";
        System.out.println("Analyze the following string: ");
        System.out.println(str);
        System.out.println("******************************************");
        // Total number of characters without spaces
        System.out.println("Number of characters without spaces: " + str.replace(" ", "").length()); //should be 445

        System.out.println("******************************************");

        // Count total instances of "and" and "is"
        int counterAnd = 0;
        int counterIs = 0;
        int position = str.indexOf("and");
        while(position != -1) {
            counterAnd++;
            position = str.indexOf("and", position + 1);
        }
        position = str.indexOf("is");
        while(position != -1) {
            counterIs++;
            position = str.indexOf("is", position + 1);
        }
        System.out.println("Total instances of \"the\" and \"is\": " + (counterAnd + counterIs)); // should be 6

        System.out.println("******************************************");

        // Count total sentences
        int sentences = str.split("([.!?])([\\s\\n])([A-Z]*)").length;
        System.out.println("Total sentences: " + sentences); // should be 4

        System.out.println("******************************************");

        // Count total number of digits
        int digitCount = 0;
        for(int i = 0, len = str.length(); i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                digitCount++;
            }
        }
        System.out.println("Total number of digits: " + digitCount); // should be 3
    }
}
