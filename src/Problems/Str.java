package Problems;

import java.util.Arrays;

public class Str {
	public static void main(String[] args) {
//		char[] str = {'a','a','a'};
//		char[] pattern = {'a','b','*','a'};
//		boolean res = Str.match(str, pattern);
//		System.out.println(res);
//		System.out.println(Str.isMatch("aaa", "ab*a"));
//		char[] str = {'+','-','2'};
//		System.out.println(Str.isNumeric(str));
		Str str = new Str();
		str.Insert('g');
		str.Insert('o');
		str.Insert('g');
		System.out.println(str.FirstAppearingOnce());
	}
	
	/**
	 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
	 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次)。
	 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
	 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean match(char[] str, char[] pattern){
		if(pattern.length <= 0)
			return str.length<=0;	
		boolean mat = (str.length>0 && (str[0]==pattern[0] || pattern[0]=='.'));
		if(pattern.length>1 && pattern[1]=='*') {
			return match(str,Arrays.copyOfRange(pattern, 2, pattern.length))||(mat && match(Arrays.copyOfRange(str, 1, str.length),pattern));
		}else {
			return mat && match(Arrays.copyOfRange(str, 1, str.length),Arrays.copyOfRange(pattern, 1, pattern.length));
		}
    }
	public static boolean isMatch(String s, String p) {
		if (p.length() <= 0)
			return s.length() <= 0;
		boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
		if (p.length() > 1 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
		} else {
			return match && isMatch(s.substring(1), p.substring(1));
		}
	}

		public static boolean match1(char[] str, char[] pattern) {
		    if (str == null || pattern == null) {
		        return false;
		    }
		    int strIndex = 0;
		    int patternIndex = 0;
		    return matchCore(str, strIndex, pattern, patternIndex);
		}

	public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		// 有效性检验：str到尾，pattern到尾，匹配成功
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern先到尾，匹配失败
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		// 模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
					|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)// 模式后移2，视为x*匹配0个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)// 视为模式匹配1个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// *匹配1个，再匹配str中的下一个
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		// 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
				|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}

	/**
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
	 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 * 非法情况：E后必须接数字，且只能出现一次
	 * 		‘+/-’第一次出现为首位，要么就在e的后面第一位，第二次出现一定在e的后面
	 *      小数点只能出现一次，并且不能出现在e的后面
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(char[] str) {
        boolean demical = false,hasE = false,sign = false;
        int len = str.length;
        for(int i = 0;i < len;i++) {
        	if(str[i]=='e'||str[i]=='E') {
        		if(i==len-1) return false;
        		if(hasE) return false;
        		hasE = true;
        	}else if(str[i] == '+'|| str[i]=='-'){
        		if(sign && str[i-1] != 'e'&& str[i-1] != 'E') return false;
        		if(!sign && i>0 && str[i-1]!='e'&&str[i-1]!='E') return false;
        		sign = true;
        	}else if(str[i] == '.') {
        		if(demical || hasE) return false;
        		demical = true;
        	}else if(str[i] < '0' || str[i] >'9') {
        		return false;
        	}
        }
        return true;
    }
	
	/**
	 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
	 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
	 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
	 * 如果当前字符流没有存在出现一次的字符，返回#字符。
	 * @param ch
	 */
	//Insert one char from stringstream
	String s ="";
	char[] count = new char[256];
    public  void Insert(char ch)
    {
        s+=ch;
        count[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for(int i=0;i < s.length();i++) {
    		if(count[s.charAt(i)]==1)
    			return s.charAt(i);
    	}
    	return '#';
    }

}
