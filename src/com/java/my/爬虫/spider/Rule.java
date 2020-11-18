package my.爬虫.spider;
/**
 * @author  : J
 * @version : Jul 14, 2017  4:08:19 PM
 * explain  : http://blog.csdn.net/lmj623565791/article/details/23272657
 */

/**
 * 规则类	
 * 用于指定查询url,method,params等
 */
public class Rule {
	
	public final static int GET = 0;
	public final static int POST = 1;
	
	public final static int CLASS = 0;
	public final static int ID = 1;
	public final static int SELECTION = 2;
	
	/**
	 * 连接
	 */
	private String url;
	/**
	 * 参数集合
	 */
	private String[] params;
	/**
	 * 参数对应值
	 */
	private String[] values;
	/**
	 * 对返回的html，第一次过滤所用的标签，请先设置type;
	 */
	private String resultTagName;
	/**
	 * CLASS / ID / SELECTION
	 * 设置resultTagName的类型，默认为ID
	 */
	private int type = ID;
	/**
	 * GET / POST
	 * 请求类型，默认为get
	 */
	private int requestMethod = GET;
	
	public Rule() {
		super();
	}

	public Rule(String url, String[] params, String[] values,
			String resultTagName, int type, int requestMethod) {
		super();
		this.url = url;
		this.params = params;
		this.values = values;
		this.resultTagName = resultTagName;
		this.type = type;
		this.requestMethod = requestMethod;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getResultTagName() {
		return resultTagName;
	}

	public void setResultTagName(String resultTagName) {
		this.resultTagName = resultTagName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(int requestMethod) {
		this.requestMethod = requestMethod;
	}
	
}
