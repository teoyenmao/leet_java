// Time complexity: O(n!), T(n) = n * T(n-1) * O(1)

public class Permutation {

  public static void permutation(String str) {
		permutation("", str);
	}

	public static void permutation(String prefixStr, String str) {
		int n = str.length();
		if (n == 0) {
			System.out.println("FINAL: " + prefixStr);
		} else {
			for (int i = 0; i < n; i++) {
        System.out.printf("prefixStr %s, i-char [%d]%s, str[0, i] %s, str[i+1, n] %s\n",
            prefixStr, i, str.charAt(i),  str.substring(0, i), str.substring(i+1, n));
				permutation(prefixStr + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		String test = "abc";
		permutation(test);
	}

}
