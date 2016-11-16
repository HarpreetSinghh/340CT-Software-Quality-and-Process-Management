
package harpreetapp;

public class Module {
	private String code;
	private String title;
	private String tutor;
	private String courseNumber;
	private String courseTitle;
	private String issueDate;
	private String dueDate;
	private String assessmentType;
	private double percentageMark;
	
	public Module() {}
	
	public Module(String code, String title, String tutor, String courseNumber,
			String courseTitle, String issueDate, String dueDate,
			String assessmentType, double percentageMark) {
		super();
		this.code = code;
		this.title = title;
		this.tutor = tutor;
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.assessmentType = assessmentType;
		this.percentageMark = percentageMark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public double getPercentageMark() {
		return percentageMark;
	}

	public void setPercentageMark(double percentageMark) {
		this.percentageMark = percentageMark;
	}

	@Override
	public String toString() {
		return "Module [code=" + code + ", title=" + title + ", tutor=" + tutor
				+ ", courseNumber=" + courseNumber + ", courseTitle="
				+ courseTitle + ", issueDate=" + issueDate + ", dueDate="
				+ dueDate + ", assessmentType=" + assessmentType
				+ ", percentageMark=" + percentageMark + "]";
	}
	
	
	
}