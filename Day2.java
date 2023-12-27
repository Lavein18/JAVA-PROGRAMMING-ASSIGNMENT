Quiz1
1)
public int[] productExceptSelf(int[] nums) {
   int n = nums.length;
   int[] result = new int[n];
   result[0] = 1;
   for (int i = 1; i < n; i++) {
       result[i] = result[i - 1] * nums[i - 1];
   }
   int suffixProduct = 1;
   for (int i = n - 1; i >= 0; i--) {
       result[i] *= suffixProduct;
       suffixProduct *= nums[i];
   }
   return result;
}

2)
import java.util.ArrayList;
import java.util.List;
public class Permutations {
   public static List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       backtrack(nums, new ArrayList<>(), result);
       return result;
   }
   private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
       if (current.size() == nums.length) {
           result.add(new ArrayList<>(current));
       } else {
           for (int num : nums) {
               if (!current.contains(num)) {
                   current.add(num);
                   backtrack(nums, current, result);
                   current.remove(current.size() - 1);
               }
           }
       }
   }
   public static void main(String[] args) {
       int[] nums = {1, 4, 3};
       List<List<Integer>> permutations = permute(nums);
       System.out.println(permutations);
   }
}

3)
import java.util.*;
public class ClubbedWords {
    public static List<String> findClubbedWords(String[] words) {
        Set<String> clubbedWords = new HashSet<>();
        Set<String> seenWords = new HashSet<>();
    
        for (String word : words) {
            seenWords.add(word);
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                if (seenWords.contains(prefix) && seenWords.contains(suffix)) {
                    clubbedWords.add(word);
                    break;
                }
            }
        }
        return new ArrayList<>(clubbedWords);
    }
    public static void main(String[] args) {
        String[] words = {"mat", "mate", "matbellmates", "bell", "bellmatesbell", "butterribbon", "butter", "ribbon"};
        List<String> clubbed = findClubbedWords(words);
        System.out.println(clubbed);
    }
}
