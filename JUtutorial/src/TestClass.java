import java.util.ArrayList;

public class TestClass {
	private ArrayList<Integer> ElementList;
	private int sum = 0;

	private void CalculateSum() {
		sum = 0;
		for (int i = 0; i < ElementList.size(); ++i) {
			sum += ElementList.get(i);
		}
	}

	public TestClass() {

	}

	public TestClass(ArrayList<Integer> list) {
		SetArrayList(list);
	}
	public ArrayList<Integer> GetArray()
	{
		return ElementList;
	}

	public void SetArrayList(ArrayList<Integer> list) {
		ElementList = list;
	}

	public int getSum() {
		CalculateSum();
		return sum;
	}

}
