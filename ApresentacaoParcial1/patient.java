enum ConditionSeverity {
   LOW, MEDIUM, HIGH, EMERGENCY
}

class Patient implements Comparable<Patient> {
   private String name;
   private int age;
   private ConditionSeverity conditionSeverity;


   public Patient(String name, int age, ConditionSeverity conditionSeverity) {
       this.name = name;
       this.age = age;
       this.conditionSeverity = conditionSeverity;
   }


   public String getName() {
       return name;
   }


   public void setName(String name) {
       this.name = name;
   }


   public int getAge() {
       return age;
   }


   public void setAge(int age) {
       this.age = age;
   }


   public ConditionSeverity getConditionSeverity() {
       return conditionSeverity;
   }


   public void setConditionSeverity(ConditionSeverity conditionSeverity) {
       this.conditionSeverity = conditionSeverity;
   }


   @Override
public int compareTo(Patient other) {
    return -1 * this.conditionSeverity.compareTo(other.getConditionSeverity());
}
}
