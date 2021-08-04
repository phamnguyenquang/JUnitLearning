package Java.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class readCSV {
	private String filePath = "e:\\deniro.csv";
	private Reader reader;
	private CsvToBean<CsvByName> parser;
	List<CsvByName> storageList;

	private static boolean isNumeric(String s) {
		if (s == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private void initialize() {
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
			parser = new CsvToBeanBuilder<CsvByName>(reader).withType(CsvByName.class)
					.withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true).build();
			final List<CsvByName> storageList1 = parser.parse();
			storageList = storageList1;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public readCSV(String path) {
		filePath = path;
		initialize();
	}

	public void getTitleGivenYear(String Year) {
		if (isNumeric(Year)) {
			List<String> title = new ArrayList<String>();
			for (int i = 0; i < storageList.size(); ++i) {
				if (storageList.get(i).getYear().equals(Year))
					title.add(storageList.get(i).getTitle());
			}
			if (title.size() == 0) {
				System.out.println("No record found for: " + Year);
			} else {
				for (int j = 0; j < title.size(); ++j) {
					System.out.print(title.get(j) + ", ");
				}
				System.out.println("");
			}
		} else {
			System.err.println("Invalid input");
		}

	}

	public double getMeanScore() {
		double size = storageList.size();
		double total = 0;
		double result = 0;
		boolean prematureBreak = false;
		for (int i = 0; i < storageList.size(); ++i) {
			try {
				double d = Double.parseDouble(storageList.get(i).getScore());
				total += d;
			} catch (NumberFormatException e) {
				System.err.println("Invalid Data Detected");
				prematureBreak = true;
				break;
			}
		}
		if (prematureBreak) {
			return -1;
		} else {
			result = total / size;
			return result;
		}
	}

	public double getMedianScore() {
		double median = 0;
		List<Double> ScoreList = new ArrayList<Double>();
		boolean prematureBreak = false;
		for (int i = 0; i < storageList.size(); ++i) {
			try {
				double d = Double.parseDouble(storageList.get(i).getScore());
				ScoreList.add(d);
			} catch (NumberFormatException e) {
				System.err.println("Invalid Data Detected");
				prematureBreak = true;
				break;
			}
		}
		if (prematureBreak) {
			return -1;
		} else {
			Collections.sort(ScoreList);
			int size = ScoreList.size();
			if (size % 2 == 1) {
				median = ScoreList.get((size + 1) / 2 - 1);
			} else {
				median = (ScoreList.get(size / 2 - 1) + ScoreList.get(size / 2)) / 2;
			}
			return median;
		}
	}
	public List<CsvByName> getCsvObject()
	{
		return storageList;
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
