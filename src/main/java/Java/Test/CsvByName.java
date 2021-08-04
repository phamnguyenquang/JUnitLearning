package Java.Test;

import com.opencsv.bean.CsvBindByName;

public class CsvByName {
	@CsvBindByName(column = "Year")
	private String Year;

	@CsvBindByName(column = "Score")
	private String Score;

	@CsvBindByName(column = "Title")
	private String Title;

	public CsvByName() {
	}

	public String getYear() {
		return Year;
	}

	public String getScore() {
		return Score;
	}

	public String getTitle() {
		return Title;
	}

	public void setYear(String newYear) {
		Year = newYear;
	}

	public void setScore(String newScore) {
		Score = newScore;
	}
	public void setTitle(String newTitle)
	{
		Title = newTitle;
	}
}
