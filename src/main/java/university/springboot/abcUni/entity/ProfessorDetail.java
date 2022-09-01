package university.springboot.abcUni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professor_detail", schema = "abc_university_db")
public class ProfessorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	
	@Column(name="degree")
	private String degree;
	
	public ProfessorDetail() {}

	public ProfessorDetail(String youtubeChannel, String degree) {
		this.youtubeChannel = youtubeChannel;
		this.degree = degree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "ProfessorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", degree=" + degree + "]";
	}
	
	

	
}
