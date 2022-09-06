package university.springboot.abcUni.beans;

import university.springboot.abcUni.entity.Student;

import javax.annotation.ManagedBean;
import java.io.Serializable;

@ManagedBean()
public class TestBean implements Serializable {

    public String deleteChoice;

    public TestBean(){}

    public String getDeleteChoice() {
        return deleteChoice;
    }

    public void setDeleteChoice(String deleteChoice) {
        this.deleteChoice = deleteChoice;
    }

    public String deleteAction(Student student) {

        return null;
    }
}
