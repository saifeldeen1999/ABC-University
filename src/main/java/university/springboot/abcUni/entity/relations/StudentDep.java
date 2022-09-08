package university.springboot.abcUni.entity.relations;

public class StudentDep {

    private Integer depId;
    private Integer studentId;

    StudentDep(){}

    public StudentDep(Integer depId, Integer studentId) {
        this.depId = depId;
        this.studentId = studentId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentDep{" +
                "depId=" + depId +
                ", studentId=" + studentId +
                '}';
    }
}
