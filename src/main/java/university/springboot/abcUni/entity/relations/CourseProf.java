package university.springboot.abcUni.entity.relations;

public class CourseProf {

    private Integer profId;
    private Integer courseId;

    CourseProf(){}

    @Override
    public String toString() {
        return "CourseProf{" +
                "profId=" + profId +
                ", courseId=" + courseId +
                '}';
    }

    public CourseProf(Integer profId, Integer courseId) {
        this.profId = profId;
        this.courseId = courseId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
