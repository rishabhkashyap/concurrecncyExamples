
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String[] vals = line1.split(" ");
		int n = Integer.parseInt(vals[0]);
		int l = Integer.parseInt(vals[1]);
		vals = new String[n];
		int k = 0;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			if (name.length() <= l) {
				vals[k++] = name;

			}

		}

		for (String str:vals) {
			if (isPalindrome(str)) {
				++counter;

			} else if (isConvertible(str)) {
				++counter;
			}
		}
		System.out.println(counter);

	}

	private static boolean isConvertible(String str) {

		char[] chars = str.toCharArray();
		List<Character> strChars = new ArrayList<>(10);
		for (char c : chars) {
			if (strChars.contains(c)) {
				strChars.remove(strChars.indexOf(c));
			} else {
				strChars.add(c);
			}
		}
		if (strChars.size() <= 1) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean isPalindrome(String str) {
		StringBuilder rev = new StringBuilder(str).reverse();
		return rev.toString().equals(str);
	}

}
