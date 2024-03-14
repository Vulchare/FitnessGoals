public class Workout {
    private int id;
    private String category;
    private String name;
    private int sets;
    private int reps;




    public Workout(int id, String category, String name, int sets, int reps) {
        this(category, name, sets, reps);
        this.id = id;
    }
    public Workout(String category, String name, int sets, int reps){
        this.category = category;
        this.name = name;
        this.sets = sets;
        this.reps = reps;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() { return id;  }

    public void setId(int id) { this.id = id; }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", sets='" + sets + '\'' +
                ", reps='" + reps + '\'' +
                '}';
    }
}
