public class Guest {
    private String name;
    private Boolean gymMembership;

    public Guest(String name){
        this.name = name;
        this.gymMembership = false;
    }

    public String getName(){
        return name;
    }

    public boolean getGymMembership() {
        return this.gymMembership;
    }
}
