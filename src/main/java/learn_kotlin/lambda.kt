package learn_kotlin

/**
 * Created by yujian on 2017/12/13.
 */
fun main(args:Array<String>){
    val sumLambda:(Int,Int)->Int={x,y->x+y}
    println(sumLambda(1,2))
}