/**

iven a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".

Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".

Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

**/


//Solution: Time: O(n) n= letters in input string | Space O(1) - 26 distinct chars in string stored in hashmap in worst case 

class CharacterReplacement {
  public static int findLength(String str, int k) {
    int windowStart = 0; 
    int windowEnd = 0; 
    int maxLetter = 0; 
    int maxLen = 0; 

    //Hashmap to store char frequencies 
    HashMap<Character, Integer> map = new HashMap<>(); 

    for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
      char left = str.charAt(windowEnd); 

      if(map.containsKey(left)){
        map.put(left, map.get(left)+1);
      }
      else{
        map.put(left, 1);
      }

      maxLetter = Math.max(maxLetter, map.get(left));

      //while sliding window contains more letters than we can replace, shrink window
      while(windowEnd - windowStart + 1 - maxLetter > k ){
        char right = str.charAt(windowStart); 
        map.put(right, map.get(right) -1); 
        windowStart++;
      }
      
      maxLen = Math.max(windowEnd - windowStart+1, maxLen);
      }
      return maxLen;
    }
  }

/**

This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as
discussed in Longest Substring with Distinct Characters. We can use a HashMap to count the frequency of each letter.

    We will iterate through the string to add one letter at a time in the window.
    
    We will also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
    
    So, at any time, we know that we do have a window with one letter repeating maxRepeatLetterCount times;
    this means we should try to replace the remaining letters.
        
        If the remaining letters are less than or equal to k, we can replace them all.
        
 If we have more than k remaining letters, we should shrink the window as we cannot replace more than k letters.
While shrinking the window, we don’t need to update maxRepeatLetterCount. Since we are only interested in the longest valid substring, 
our sliding windows do not have to shrink, even if a window may cover an invalid substring. Either we expand the window by appending a 
character to the right or we shift the entire window to the right by one. We only expand the window when the frequency of the newly added 
character exceeds the historical maximum frequency (from a previous window that included a valid substring). In other words, we do not need 
to know the exact maximum count of the current window. 

The only thing we need to know is whether the maximum count exceeds the historical maximum count, and that can only happen because of the newly added char.

**/
