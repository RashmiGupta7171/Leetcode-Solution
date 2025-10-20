// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if (s.length() != t.length()){
//             return false;
//         }
//         HashMap<Character, Character> mp1 = new hashMap<>();
//         HashMap<Character, Boolean> mp2 = new hashMap<>();
//         int n = s.length();
//         for(int i=0; i<n; i++){
//             char ch1 = s.charAT(i);
//             char ch2 = t.charAt(i);
//             if(mp1.containsKey(ch1) == true){
//                 if(mp1.get(ch1) != ch2)
//                 return false;
//             }
//             else{
//                 mp1.put(ch1 , ch2);
//                 mp2.put(ch2 , true);
//             }
//         }
//     }
//     return true;
// }
// }
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Boolean> mapUsedT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (mapST.containsKey(ch1)) {
                // If mapping exists, it must match the same character in t
                if (mapST.get(ch1) != ch2) {
                    return false;
                }
            } else {
                // If ch2 is already mapped to some other ch1, it’s invalid
                if (mapUsedT.getOrDefault(ch2, false)) {
                    return false;
                }
                mapST.put(ch1, ch2);
                mapUsedT.put(ch2, true);
            }
        }

        return true;
    }
}

        