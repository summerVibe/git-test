package my.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  : J
 * @version : 2017年6月8日  上午9:20:02
 * explain  : http://www.cnblogs.com/lzq198754/p/5780340.html
 */
public class Test_01 {

	public static void main(String[] args) {
		
		/**
		 *  常用正则表达式
		 */
		// 一个或多个汉字： 
		String s1 = "^[\u0391-\uFFE5]+$";
		
		// 邮政编码 
		String s2 = "^[1-9]\\d{5}$";
		
		// QQ号码
		String s3 = "^[1-9]\\d{4,10}$";
		
		// 邮箱
		String s4 = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
		
		// 用户名（字母开头 + 数字/字母/下划线）
		String s5 = "^[A-Za-z][A-Za-z1-9_-]+$";
		
		// 手机号码
		String s6 = "^1[3|4|5|8][0-9]\\d{8}$";
//		System.out.println(Pattern.matches(s6, "15608099852"));
		
		// URL
		String s7 = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
		
		
		// 18位身份证号
		String s8 = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
		
		// 传真号码
		String s9 = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
		
		// 固话号码
		String s10 = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
				
//		System.err.println(checkBirth("51081219930430325x"));
		
		// * 匹配前面的子表达式任意次。例如，zo*能匹配“z”，“zo”以及“zoo”。*等价于{0,}。
//		System.out.println(Pattern.matches("^zo*$", "z"));
		// + :匹配前面的子表达式一次或多次(大于等于1次）。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。
		
		// ? :匹配前面的子表达式零次或一次。例如，“do(es)?”可以匹配“do”或“does”中的“do”。?等价于{0,1}。
//		System.out.println(Pattern.matches("do(es)?", "does"));
		
		// . :匹配除“\r\n”之外的任何单个字符。要匹配包括“\r\n”在内的任何字符，请使用像“[\s\S]”的模式。
//		System.out.println(Pattern.matches("..a", "a"));
		
		// | : x|y 匹配x或y。例如，“z|food”能匹配“z”或“food”或"zood"(此处请谨慎)。“(z|f)ood”则匹配“zood”或“food”。
//		System.out.println(Pattern.matches("z|food", "food"));
		
		// [xyz] : 字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。
//		System.out.println(Pattern.matches("[abc]", "a"));		// true
		
		// [^xyz] :负值字符集合。匹配未包含的任意字符。例如，“[^abc]”可以匹配“plain”中的“plin”。
//		System.out.println(Pattern.matches("[^abc]", "a"));		// false
		
		// \b :匹配一个单词边界，也就是指单词和空格间的位置（即正则表达式的“匹配”有两种概念，
		// 一种是匹配字符，一种是匹配位置，这里的\b就是匹配位置的）。例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中的“er”。
		// \B :匹配非单词边界
//		System.out.println(Pattern.matches("er/b", "never"));
		
		// (pattern) :匹配pattern并获取这一匹配。所获取的匹配可以从产生的Matches集合得到，在VBScript中使用SubMatches集合，在JScript中则使用$0…$9属性。要匹配圆括号字符，请使用“\(”或“\)”。
//		System.out.println(Pattern.matches("(\\(pattern\\))", "(pattern)"));
		
		// 匹配pattern但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用。这在使用或字符“(|)”来组合一个模式的各个部分是很有用。例如“industr(?:y|ies)”就是一个比“industry|industries”更简略的表达式。
//		System.out.println(Pattern.matches("industr(?:y|ies)", "industry"));
//		System.out.println(Pattern.matches("industr(y|ies)", "industries"));
		
		// ....
		
		// \d :匹配一个数字字符。等价于[0-9]。
		// \D :匹配一个非数字字符。等价于[^0-9]。
//		System.out.println(Pattern.matches("\\d", "4"));
		
		// \w :匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。
		// \W :匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。
//		System.out.println(Pattern.matches("\\w", "D"));
		
		
	}
	
	
	/**
	 * 邮箱验证
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		if (isNull(email)) {
			return false;
		}
		// 邮箱验证规则
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
		
	}
	
	
	/**
	 * 身份证验证
	 * @param card
	 * @return true合法
	 */
	public static boolean checkBirth(String card) {
		if (isNull(card)) {
			return false;
		}
		return Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", card);
	}

	/**
	 * 验证参数是否为空,空true
	 * 
	 * @param object
	 * @return
	 */
	public final static boolean isNull(Object object) {
		return object == null || "null".equals(object.toString()) || "".equals(object.toString())
				|| "undefined".equals(object.toString())
				|| object.toString().trim().length() <= 0;
	}
	
	
	public void linkPhone(){
		
	}
	
	
}
