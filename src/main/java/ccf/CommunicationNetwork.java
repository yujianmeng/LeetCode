package ccf;

import java.util.*;

/**
 * Created by yujian on 2017/11/3.
 * 某国的军队由N个部门组成，为了提高安全性，部门之间建立了M条通路，每条通路只能单向传递信息，即一条从部门a到部门b的通路只能由a向b传递信息。信息可以通过中转的方式进行传递，即如果a能将信息传递到b，b又能将信息传递到c，则a能将信息传递到c。一条信息可能通过多次中转最终到达目的地。
 　　由于保密工作做得很好，并不是所有部门之间都互相知道彼此的存在。只有当两个部门之间可以直接或间接传递信息时，他们才彼此知道对方的存在。部门之间不会把自己知道哪些部门告诉其他部门。

 　　上图中给了一个4个部门的例子，图中的单向边表示通路。部门1可以将消息发送给所有部门，部门4可以接收所有部门的消息，所以部门1和部门4知道所有其他部门的存在。部门2和部门3之间没有任何方式可以发送消息，所以部门2和部门3互相不知道彼此的存在。
 　　现在请问，有多少个部门知道所有N个部门的存在。或者说，有多少个部门所知道的部门数量（包括自己）正好是N。
 输入格式
 　　输入的第一行包含两个整数N, M，分别表示部门的数量和单向通路的数量。所有部门从1到N标号。
 　　接下来M行，每行两个整数a, b，表示部门a到部门b有一条单向通路。
 输出格式
 　　输出一行，包含一个整数，表示答案。
 样例输入
 4 4
 1 2
 1 3
 2 4
 3 4
 样例输出
 2
 样例说明
 　　部门1和部门4知道所有其他部门的存在。
 评测用例规模与约定
 　　对于30%的评测用例，1 ≤ N ≤ 10，1 ≤ M ≤ 20；
 　　对于60%的评测用例，1 ≤ N ≤ 100，1 ≤ M ≤ 1000；
 　　对于100%的评测用例，1 ≤ N ≤ 1000，1 ≤ M ≤ 10000。
 */
public class CommunicationNetwork {
    private static List<Node1> allNode = new ArrayList<>();
    private static Set<Integer> ne = new HashSet<>();
    private static Set<Integer> pre = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> kownNums = new HashMap<>();
        int sum=0;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i=0;
        while (i<m){
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            Node1 beginNode = null;
            Node1 endNode = null;
            for (Node1 node:allNode){
                if(node.self==begin) {
                    beginNode = node;
                    node.next.add(end);
                }
                if (node.self==end){
                    endNode = node;
                    node.previous.add(begin);
                }
            }
            if (beginNode==null){
                Node1 node = new Node1();
                node.self = begin;
                node.next.add(end);
                allNode.add(node);
            }
            if (endNode==null){
                Node1 node = new Node1();
                node.self = end;
                node.previous.add(begin);
                allNode.add(node);
            }
            i++;
        }

        for (Node1 node:allNode) {
            int self = node.self;
            ne.add(self);
            pre.add(self);
            List<Integer> next = node.next;
            List<Integer> previous = node.previous;
            next(next);
            previous(previous);
            ne.addAll(pre);
            kownNums.put(self,ne.size());
            ne = new HashSet<>();
            pre = new HashSet<>();
        }
        Set<Integer> keySet = kownNums.keySet();
        for (Integer key:keySet){
            if (kownNums.get(key)==n){
                sum++;
            }
        }
        System.out.println(sum);
    }

    //向下知道的节点数
    private static void next(List<Integer> next){
        for (Integer i:next){
            if (ne.contains(i)) {
                continue;
            }
            ne.add(i);
            for (Node1 node:allNode){
                if (node.self == i){
                    if (node.next.size()!=0) {
                        next(node.next);
                    }
                    break;
                }
            }
        }
    }
    //向上知道的节点数
    private static void previous(List<Integer> previous){
        for (Integer i:previous){
            if (pre.contains(i)) {
                continue;
            }
            pre.add(i);
            for (Node1 node:allNode){
                if (node.self==i){
                    if (node.previous.size()!=0){
                        previous(node.previous);
                    }
                    break;
                }
            }
        }
    }
}

class Node1{
    int self = 0;
    List<Integer> previous = new ArrayList<>();
    List<Integer> next = new ArrayList<>();
}


