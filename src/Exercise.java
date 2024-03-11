public class Exercise {
    private String name;
    private int reps;
    private int sets;
    private float weight;


    public Exercise(String name, int sets, int reps, float weight){
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public float getWeight() {
        return weight;
    }

}

