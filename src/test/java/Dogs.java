public class Dogs {

    private static final int PAWS =4;
    private static final int TAIL =1;
    private String breed;
    private String name;
    private Size size;
    private static int dogsCount;

    Dogs(){
        dogsCount++;
        System.out.println("Dogs count is "+dogsCount);
    }

    public Size getSize() {
        return size;
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    public void setSize(Size size) {
       /* if (size.equalsIgnoreCase("Big") ||
                size.equalsIgnoreCase("Average") ||
                size.equalsIgnoreCase("Small")) {

            this.size = size;
        } else {
            System.out.println("Incorrect size of a dog");
        }*/
        this.size = size;
    }



    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bark() {
       switch (size) {
           case BIG:
               System.out.println("Bau-Bau");
               break;
           case AVERAGE:
               System.out.println("Raf-Raf");
               break;
           case SMALL:
               System.out.println("Tjaf-Tjaf");
               break;
       }

    }
    public void bite(){
        if(dogsCount>2){
            System.out.println("\nDogs are going to bite you...\n");
        }
        else bark();
    }
   }
