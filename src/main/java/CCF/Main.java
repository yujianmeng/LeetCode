package CCF;

import java.util.*;

/**
 * Created by yujian on 2017/9/27.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = "";
        String html = "";
        List<String> htmlContent = new LinkedList<String>();
        boolean theFirst=true;
        String texts = "";
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (line.equals("eof"))
                break;
            if (!line.equals("")) {
                char head = line.charAt(0);
                switch (head) {
                    case '#':
                        theFirst = true;
                        int sum = 1;
                        while (line.charAt(sum) == '#')
                            sum++;
                        line = inLine(line);
                        html = "<h" + sum + ">" + line.substring(sum).trim() + "</h" + sum + ">";
                        break;
                    case '*':
                        line = inLine(line);
                        if (theFirst) {
                            htmlContent.add("<ul>");
                            htmlContent.add("</ul>");
                            theFirst = false;
                        }
                        html = "<li>"+line.substring(1).trim()+"</li>";
                        break;
                    default:
                        theFirst = true;
                        texts = texts+line;
                }
                if (theFirst) htmlContent.add(html);
                else htmlContent.add(htmlContent.size()-1,html);
            }
            else if (!texts.equals("")){
                line = inLine(texts);
                html = "<p>"+line.trim()+"</p>";
                texts = "";
                htmlContent.add(html);
            }
        }
        for (int i=0;i<htmlContent.size();i++)
            System.out.println(htmlContent.get(i));
    }
    public static String inLine(String content){
        int flag = 1;
        if(content.contains("_")){
            for (int i=0;i<content.length();i++)
                if (content.charAt(i)=='_'){
                    if(flag++%2==1)
                        content = content.replaceFirst("_","<em>");
                    else content = content.replaceFirst("_","</em>");
                }
        }
        if (content.contains("[")&&content.contains("(")){
            int m=-1,n=-1;
            int p=-1,q=-1;
            for (int i=0;i<content.length();i++){
                char c = content.charAt(i);
                switch (c){
                    case '[':m=i;break;
                    case ']':n=i;break;
                    case '(':p=i;break;
                    case ')':q=i;break;
                }
                if (m>=0&&n>=0&&p>=0&&q>=0) {
                    content = content.replace(content.substring(m, q + 1),
                            "<a href=" + content.substring(p+1, q) + ">" + content.substring(m+1, n) + "</a>");
                    i=0;
                    m=-1;n=-1;p=-1;q=-1;
                }
            }
        }
        return content;
    }
}
