import java.util.Arrays;

public class PermutationRepeated {

  public static void permutation(String str) {
    // change to string array
    String[] strArr = str.split("");
    int n = strArr.length;
    // Prepare empty string array
    String[] strResult = new String[n];
    permutation(strArr, strResult, n-1, 0);
  }

  public static void permutation(String[] strArr, String[] strResult, int last, int index) {
    for (int i = 0; i < strArr.length; i++) {
      strResult[index] = strArr[i];
      if (index == last) {
        System.out.println(Arrays.toString(strResult));
      } else {
        permutation(strArr, strResult, last, index+1);
      }
    }
  }

  public static void main(String[] args) {
    String test = "xyz";
    permutation(test);
  }

}
