class Solution {
    public String simplifyPath(String path) {
         Stack<String> st = new Stack<>();
        String[] arr = path.split("/");

        for (String string : arr) {
            if (string.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!string.equals(".") && !string.isEmpty()) {
                st.push(string);
            }
        }

        if (st.isEmpty()) {
            return "/";
        } 
        else {
            StringBuilder ans = new StringBuilder();
            for (String dir : st) {
                ans.append("/").append(dir);
            }
            return ans.toString();
        }   
        }
    }