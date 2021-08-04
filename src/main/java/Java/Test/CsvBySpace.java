package Java.Test;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CsvBySpace {
	@CsvBindByPosition(position = 0)
	private String Year;

	@CsvBindByPosition(position = 1)
	private String Score;

	@CsvBindByPosition(position = 2)
	private String Title;

	public CsvBySpace() {
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
