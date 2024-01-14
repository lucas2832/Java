public class Npc {
    private String name;
    private int drunk;
    private int hungry;
    private boolean reciveQuestItem;
    private String questItem;
    private String history;
    private boolean firstTime;
    private boolean told;

    public Npc(String name, int drunk, int hungry, String history, String questItem) {
        this.name = name;
        this.drunk = drunk;
        this.hungry = hungry;
        this.history = history;
        this.reciveQuestItem = false;
        this.firstTime = true;
        this.questItem = questItem;
        this.told = false;
    }

    public String getName() {
        return name;
    }

    public boolean getReciveQuestItem() {
        return reciveQuestItem;
    }

    public String getQuestItem() {
        return questItem;
    }

    public String getHistory() {
        return history;
    }

    public void setFirstTime() {
        firstTime = false;
    }

    public boolean getFirstTime() {
        return firstTime;
    }
    
    public void setTold() {
        told = true;
    }
    
    public boolean getTold() {
        return told;
    }

}
