package CCF;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by yujian on 2017/10/22.
 * 问题描述
 　　A市有n个交通枢纽，其中1号和n号非常重要，为了加强运输能力，A市决定在1号到n号枢纽间修建一条地铁。
 　　地铁由很多段隧道组成，每段隧道连接两个交通枢纽。经过勘探，有m段隧道作为候选，两个交通枢纽之间最多只有一条候选的隧道，没有隧道两端连接着同一个交通枢纽。
 　　现在有n家隧道施工的公司，每段候选的隧道只能由一个公司施工，每家公司施工需要的天数一致。而每家公司最多只能修建一条候选隧道。所有公司同时开始施工。
 　　作为项目负责人，你获得了候选隧道的信息，现在你可以按自己的想法选择一部分隧道进行施工，请问修建整条地铁最少需要多少天。
 输入格式
 　　输入的第一行包含两个整数n, m，用一个空格分隔，分别表示交通枢纽的数量和候选隧道的数量。
 　　第2行到第m+1行，每行包含三个整数a, b, c，表示枢纽a和枢纽b之间可以修建一条隧道，需要的时间为c天。
 输出格式
 　　输出一个整数，修建整条地铁线路最少需要的天数。
 样例输入
 6 6
 1 2 4
 2 3 4
 3 6 7
 1 4 2
 4 5 5
 5 6 6
 样例输出
 6
 样例说明
 　　可以修建的线路有两种。
 　　第一种经过的枢纽依次为1, 2, 3, 6，所需要的时间分别是4, 4, 7，则整条地铁线需要7天修完；
 　　第二种经过的枢纽依次为1, 4, 5, 6，所需要的时间分别是2, 5, 6，则整条地铁线需要6天修完。
 　　第二种方案所用的天数更少。
 评测用例规模与约定
 　　对于20%的评测用例，1 ≤ n ≤ 10，1 ≤ m ≤ 20；
 　　对于40%的评测用例，1 ≤ n ≤ 100，1 ≤ m ≤ 1000；
 　　对于60%的评测用例，1 ≤ n ≤ 1000，1 ≤ m ≤ 10000，1 ≤ c ≤ 1000；
 　　对于80%的评测用例，1 ≤ n ≤ 10000，1 ≤ m ≤ 100000；
 　　对于100%的评测用例，1 ≤ n ≤ 100000，1 ≤ m ≤ 200000，1 ≤ a, b ≤ n，1 ≤ c ≤ 1000000。

 　　所有评测用例保证在所有候选隧道都修通时1号枢纽可以通过隧道到达其他所有枢纽。
 */
/*public class Main {
    private static Stack<Integer> route = new Stack<>();
    private static Map<Integer,String> neighbors = new HashMap<>();
    private static int n;
    private static int maxDay=0;
    private static int minDay=Integer.MAX_VALUE;
    private static Map<String,Integer> weights = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        route.push(1);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int j=0;
        while (j++<m){
            int beginNode = scanner.nextInt();
            int endNode = scanner.nextInt();
            int weight = scanner.nextInt();
            weights.put(beginNode+""+endNode,weight);
            if (neighbors.containsKey(beginNode)){
                neighbors.put(beginNode,neighbors.get(beginNode)+"_"+endNode);

            }
            else {
                neighbors.put(beginNode, endNode + "");
            }
        }

        while (route.size()!=0){
            int peek = route.peek();
            if (neighbors.containsKey(peek)){
                String[] neighbor = neighbors.get(peek).split("_");
                int in = Integer.parseInt(neighbor[0]);
                route.push(in);
                getMinDay();
            }
            else {
                pop();
            }
        }
        System.out.println(minDay);
    }

    public static void pop(){
        int peek = route.peek();
        route.pop();
        if (route.size()!=0) {
            List<String> neighbor = new ArrayList<>
                    (Arrays.asList(neighbors.get(route.peek()).split("_")));
            if (neighbor.size() == 1) {
                pop();
            } else {
                if (neighbor.get(neighbor.size() - 1).equals(peek + "")) {
                    pop();
                } else {
                    for (int i = 0; i < neighbor.size(); i++) {
                        if (neighbor.get(i).equals(peek + "")) {
                            route.push(Integer.valueOf(neighbor.get(i + 1)));
                        }
                        getMinDay();
                        break;
                    }
                }
            }
        }
    }

    public static void getMinDay(){
        if (route.contains(n)){
//            printStack();
            getN();
            System.out.println(maxDay);
            if (maxDay<minDay){
                minDay = maxDay;}
            maxDay=0;
        }
    }

//    public static void printStack(){
//        Enumeration items = route.elements();
//        while (items.hasMoreElements()) { //显示枚举（stack ） 中的所有元素
//            System.out.print(items.nextElement() + " ");
//        }
//        System.out.println("");
//    }

    public static void getN(){
       for (int i=0;i<route.size()-1;i++){
           int weight = weights.get(route.get(i)+""+route.get(i+1));
           if (weight>maxDay){
               maxDay = weight;
           }
       }
    }
}*/

public class MinDays {

    public static void main(String[] args) {
        Vector<Node> vector=new Vector<>();
        Scanner scanner=new Scanner(System.in);
        int vnum=scanner.nextInt();
        int rnum=scanner.nextInt();
        int[] p=new int[vnum+1];
        for (int i = 0; i < rnum; i++) {
            Node node=new Node();
            node.x=scanner.nextInt();
            node.y=scanner.nextInt();
            node.z=scanner.nextInt();
            vector.add(node);
        }
//        Collections.sort(vector,(o1,o2)->o1.z<o2.z?-1:1);
        Collections.sort(vector,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.z<o2.z) {
                    return -1;
                }else if (o1.z>o2.z) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        for (int i = 1; i < p.length; i++) {
            p[i]=i;
        }
        int i=0;
        int x,y,z=0;
        while (i<rnum) {
            x=vector.get(i).x;
            y=vector.get(i).y;
            z=vector.get(i).z;
            int xf=find(p,x);
            int yf=find(p,y);
            union_s(p,xf,yf);
            if (find(p,1)==find(p,vnum)) {
                break;
            }
            i++;
        }
        System.out.println(z);
    }

    private static void union_s(int[] p, int xf, int yf) {
        p[yf]=xf;
    }

    private static int find(int[] p, int x) {
        while (p[x]!=x) {
            x=p[x];
        }
        return x;
    }

}
class Node{
    int x;
    int y;
    int z;
}
