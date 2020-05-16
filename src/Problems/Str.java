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
	 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
	 * ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0��)��
	 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
	 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
		// ��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern�ȵ�β��ƥ��ʧ��
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		// ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
					|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)// ģʽ����2����Ϊx*ƥ��0���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)// ��Ϊģʽƥ��1���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// *ƥ��1������ƥ��str�е���һ��
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		// ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
				|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}

	/**
	 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
	 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� 
	 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
	 * �Ƿ������E���������֣���ֻ�ܳ���һ��
	 * 		��+/-����һ�γ���Ϊ��λ��Ҫô����e�ĺ����һλ���ڶ��γ���һ����e�ĺ���
	 *      С����ֻ�ܳ���һ�Σ����Ҳ��ܳ�����e�ĺ���
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
	 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
	 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
	 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
	 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
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
