public class Player {

    private static String name;
    private static int drunk;
    private static int hungry;
    public static Item leftHand;
    public static Item rightHand;
    public static Item empty;

    public Player() {
        name = "";
        drunk = 0;
        hungry = 25;
        Item empty = new Item ("empty",0,0,false);
        leftHand = empty;
        rightHand = empty;
    }
    
    public static void setName () {
        name = Interact.nome;
    }
    
    public static boolean deuPT() {
        if(drunk > 80) {
            System.out.print("* GAME OVER *");
            System.out.print("* Você bebeu demais, deu pt e foi espulso da festa pelos seguranças");
            return true;
        }
        
        return false;
    }
    
    public static boolean esfomeousse() {
        if(hungry > 80) {
            System.out.println("* GAME OVER *");
            System.out.println("* Você ficou com fome, tacou o foda-se  e foi para casa. *");
            return true;
        }
        
        return false;
    }
    
    //altera os valores de alcolismo do player
    public static void drunkUpLeftHand() {
        drunk += leftHand.getAlcohol();
        leftHand = empty;
    }

    public static void drunkUpRightHand() {
        drunk += rightHand.getAlcohol();
        rightHand = empty;
    }
    
    //altera is valores de fome do player
    public static void hungerDownRightHand() {
        hungry -= rightHand.getHungry();
    }

    public static void hungerDownLeftHand() {
        hungry -= leftHand.getHungry();
    }
    
    public static void takeItem(Item item) {
        if(Game.hand.equals("direita")) 
            rightHand = item;
        
        if(Game.hand.equals("esquerda"))
            leftHand = item;
    }

    //retorna o valor de alcolismo
    public static int getDrunkValue() {
        return drunk;
    }
    
    public static void hungerUp() {
        hungry += 5;
    }
    
    public static void drunkDown() {
        drunk -= 5;
    }
    
    //retorna o valor de fome
    public static int getHungerValue() {
        return hungry;
    }

    //transforma em string o nome do item na mão
    public static String getNameLeft()
    {
        return leftHand.getName();
    }
    
    public static String getNameRight()
    {
        return rightHand.getName();
    }
    
    public static Item getLeftHand() {
        return leftHand;
    }
    
    public static Item getRightHand() {
        return rightHand;
    }
    
    public static Item dropItemLeft() {
        return empty;
    }
    
    public static Item dropItemRight() {
        return empty;
    }
    
    public static String getName() {
        return name;
    }
    //printa as informações do personagem
    public void getInfo() {
        System.out.println(name);
        System.out.println(drunk);
        System.out.println(hungry);
        System.out.println(getNameLeft());
        System.out.println(getNameRight());
    }
}