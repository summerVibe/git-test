package my.file_;

import org.apache.cxf.common.util.StringUtils;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Html2Text2 extends HTMLEditorKit.ParserCallback{
    StringBuffer s;

    public Html2Text2() {}

    public void parse(Reader in) throws IOException {
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
    }

    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }

    public static String getHtmlText(String path){
        String htmlText = "";
        if (StringUtils.isEmpty(path)) return htmlText;
        try {
            // the HTML to convert
            //Reader in=new StringReader("string");
            FileReader in = new FileReader(path);
            Html2Text2 parser = new Html2Text2();
            parser.parse(in);
            in.close();
            htmlText = parser.getText();
            System.out.println(parser.getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return htmlText;
    }

    public static void main (String[] args) {
        getHtmlText("C:\\Users\\E465\\Desktop\\testHtml2.html");

    }
}
