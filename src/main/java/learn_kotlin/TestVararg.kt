package learn_kotlin

/**
 * Created by yujian on 2017/12/13.
 */
fun main(args:Array<String>){
    vars(1,2,3,4,5)
}

fun vars(vararg v:Int){
    for (vt in v)
        println(vt)
}