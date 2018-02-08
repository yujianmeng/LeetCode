package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/11/21.
 * * 玩家会控制一些角色，每个角色有自己的生命值和攻击力。当生命值小于等于 0 时，该角色死亡。角色分为英雄和随从。
 　　* 玩家各控制一个英雄，游戏开始时，英雄的生命值为 30，攻击力为 0。当英雄死亡时，游戏结束，英雄未死亡的一方获胜。
 　　* 玩家可在游戏过程中召唤随从。棋盘上每方都有 7 个可用于放置随从的空位，从左到右一字排开，被称为战场。当随从死亡时，它将被从战场上移除。
 　　* 游戏开始后，两位玩家轮流进行操作，每个玩家的连续一组操作称为一个回合。
 　　* 每个回合中，当前玩家可进行零个或者多个以下操作：
 　　1) 召唤随从：玩家召唤一个随从进入战场，随从具有指定的生命值和攻击力。
 　　2) 随从攻击：玩家控制自己的某个随从攻击对手的英雄或者某个随从。
 　　3) 结束回合：玩家声明自己的当前回合结束，游戏将进入对手的回合。该操作一定是一个回合的最后一个操作。
 　　* 当随从攻击时，攻击方和被攻击方会同时对彼此造成等同于自己攻击力的伤害。受到伤害的角色的生命值将会减少，数值等同于受到的伤害。例如，随从 X 的生命值为 HX、攻击力为 AX，随从 Y 的生命值为 HY、攻击力为 AY，如果随从 X 攻击随从 Y，则攻击发生后随从 X 的生命值变为 HX - AY，随从 Y 的生命值变为 HY - AX。攻击发生后，角色的生命值可以为负数。
 　　本题将给出一个游戏的过程，要求编写程序模拟该游戏过程并输出最后的局面。
 输入格式
 　　输入第一行是一个整数 n，表示操作的个数。接下来 n 行，每行描述一个操作，格式如下：
 　　<action> <arg1> <arg2> ...
 　　其中<action>表示操作类型，是一个字符串，共有 3 种：summon表示召唤随从，attack表示随从攻击，end表示结束回合。这 3 种操作的具体格式如下：
 　　* summon <position> <attack> <health>：当前玩家在位置<position>召唤一个生命值为<health>、攻击力为<attack>的随从。其中<position>是一个 1 到 7 的整数，表示召唤的随从出现在战场上的位置，原来该位置及右边的随从都将顺次向右移动一位。
 　　* attack <attacker> <defender>：当前玩家的角色<attacker>攻击对方的角色 <defender>。<attacker>是 1 到 7 的整数，表示发起攻击的本方随从编号，<defender>是 0 到 7 的整数，表示被攻击的对方角色，0 表示攻击对方英雄，1 到 7 表示攻击对方随从的编号。
 　　* end：当前玩家结束本回合。
 　　注意：随从的编号会随着游戏的进程发生变化，当召唤一个随从时，玩家指定召唤该随从放入战场的位置，此时，原来该位置及右边的所有随从编号都会增加 1。而当一个随从死亡时，它右边的所有随从编号都会减少 1。任意时刻，战场上的随从总是从1开始连续编号。
 输出格式
 　　输出共 5 行。
 　　第 1 行包含一个整数，表示这 n 次操作后（以下称为 T 时刻）游戏的胜负结果，1 表示先手玩家获胜，-1 表示后手玩家获胜，0 表示游戏尚未结束，还没有人获胜。
 　　第 2 行包含一个整数，表示 T 时刻先手玩家的英雄的生命值。
 　　第 3 行包含若干个整数，第一个整数 p 表示 T 时刻先手玩家在战场上存活的随从个数，之后 p 个整数，分别表示这些随从在 T 时刻的生命值（按照从左往右的顺序）。
 　　第 4 行和第 5 行与第 2 行和第 3 行类似，只是将玩家从先手玩家换为后手玩家。
 样例输入
 8
 summon 1 3 6
 summon 2 4 2
 end
 summon 1 4 5
 summon 1 2 1
 attack 1 2
 end
 attack 1 1
 样例输出
 0
 30
 1 2
 30
 1 2
 样例说明
 　　按照样例输入从第 2 行开始逐行的解释如下：
 　　1. 先手玩家在位置 1 召唤一个生命值为 6、攻击力为 3 的随从 A，是本方战场上唯一的随从。
 　　2. 先手玩家在位置 2 召唤一个生命值为 2、攻击力为 4 的随从 B，出现在随从 A 的右边。
 　　3. 先手玩家回合结束。
 　　4. 后手玩家在位置 1 召唤一个生命值为 5、攻击力为 4 的随从 C，是本方战场上唯一的随从。
 　　5. 后手玩家在位置 1 召唤一个生命值为 1、攻击力为 2 的随从 D，出现在随从 C 的左边。
 　　6. 随从 D 攻击随从 B，双方均死亡。
 　　7. 后手玩家回合结束。
 　　8. 随从 A 攻击随从 C，双方的生命值都降低至 2。
 评测用例规模与约定
 　　* 操作的个数0 ≤ n ≤ 1000。
 　　* 随从的初始生命值为 1 到 100 的整数，攻击力为 0 到 100 的整数。
 　　* 保证所有操作均合法，包括但不限于：
 　　1) 召唤随从的位置一定是合法的，即如果当前本方战场上有 m 个随从，则召唤随从的位置一定在 1 到 m + 1 之间，其中 1 表示战场最左边的位置，m + 1 表示战场最右边的位置。
 　　2) 当本方战场有 7 个随从时，不会再召唤新的随从。
 　　3) 发起攻击和被攻击的角色一定存在，发起攻击的角色攻击力大于 0。
 　　4) 一方英雄如果死亡，就不再会有后续操作。
 　　* 数据约定：
 　　前 20% 的评测用例召唤随从的位置都是战场的最右边。
 　　前 40% 的评测用例没有 attack 操作。
 　　前 60% 的评测用例不会出现随从死亡的情况。
 */
public class LuShi {
    /**
    *先手随从
    * 后手随从
    */
    private static Accompany[] sente = new Accompany[8];
    private static Accompany[] gote = new Accompany[8];
    private static Scanner scanner = new Scanner(System.in);
    private static int senteAccN = 0;
    private static int goteAccN = 0;
    private static boolean isSente = true;
    public static void main(String[] args) {
        //编号0是英雄本身
        sente[0] = new Accompany(0,30,0);
        gote[0] = new Accompany(0,30,0);
        int n = scanner.nextInt();
        int i = 0;
        while (i++<n){
            String action = scanner.next();
            switch (action){
                case "summon":
                    summon(isSente);
                    break;
                case "attack":
                    attack(isSente);
                    break;
                case "end":
                    isSente = !isSente;
                    break;
                default:
                    System.out.println("类型错误！");
            }
        }
        if (gote[0].health<=0){
            System.out.println(1);
        }
        else if (sente[0].health<=0){
            System.out.println(-1);
        }
        else {
            System.out.println(0);
        }
        System.out.println(sente[0].health);
        System.out.print(senteAccN+" ");
        for (int j = 1; j < senteAccN+1; j++) {
            System.out.print(sente[j].health+" ");
        }
        System.out.println();

        System.out.println(gote[0].health);
        System.out.print(goteAccN+" ");
        for (int j = 1; j < goteAccN+1; j++) {
            System.out.print(gote[j].health+" ");
        }
        System.out.println();
    }

    private static void summon(boolean isSente){
        int position = scanner.nextInt();
        int attack = scanner.nextInt();
        int health = scanner.nextInt();
        Accompany accompany = new Accompany(attack,health,position);
        int length;
        Accompany[] who;
        if (isSente){
            length = senteAccN;
            senteAccN++;
            who = sente;
        }
        else {
            length = goteAccN;
            goteAccN++;
            who = gote;
        }
        if (position<=length){
            for (int i = length+1; i > position; i--) {
                who[i] = who[i-1];
            }
            who[position] = accompany;
        }
        else {
            who[position] = accompany;
        }
    }

    private static void attack(boolean isSente){
        int attPo = scanner.nextInt();
        int defPo = scanner.nextInt();
        Accompany[] attackers;
        Accompany[] defenders;
        if (isSente) {
            attackers = sente;
            defenders = gote;
        }
        else {
            attackers = gote;
            defenders = sente;
        }
        defenders[defPo].health = defenders[defPo].health-attackers[attPo].attack;
        attackers[attPo].health = attackers[attPo].health-defenders[defPo].attack;
        leftMove(defenders,defPo,1);
        leftMove(attackers,attPo,0);
    }

    private static void leftMove(Accompany[] arr,int po,int deOratt){
        int length;
        if (arr[po].health<=0){
            if ((isSente&&deOratt==0)||(!isSente&&deOratt!=0)){
                length = senteAccN;
                senteAccN--;
            }
            else {
                length = goteAccN;
                goteAccN--;
            }
            if (arr[po].position<length){
                for (int i = arr[po].position; i < length; i++) {
                    arr[i] = arr[i+1];
                }
            }
            arr[length] = null;
        }
    }
}

class Accompany{
    int attack;
    int health;
    int position;
    public Accompany(int attack,int health,int position){
        this.attack = attack;
        this.health = health;
        this.position = position;
    }
}