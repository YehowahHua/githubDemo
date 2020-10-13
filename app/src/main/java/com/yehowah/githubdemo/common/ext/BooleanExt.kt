package com.yehowah.githubdemo.common.ext

//泛型协变
sealed class BooleanExt<out T>

object Otherwise: BooleanExt<Nothing>()
class WithData<T>(val data: T): BooleanExt<T>()

/**
 * 扩展boolean方法
 * ()->Unit修改成()->T
 */
inline fun <T> Boolean.yes(block: ()->T):BooleanExt<T>{
    return when{
        this ->{
            WithData(block())
        }
        else ->{
            Otherwise
        }
    }
}


inline fun <T> Boolean.no(block: ()->T):BooleanExt<T>{
    return when{
        this ->{
            Otherwise
        }
        else ->{
            WithData(block())
        }
    }
}
//删除this.data as T的强转，对BooleanExt使用了泛型
inline fun <T> BooleanExt<T>.otherwise(block: ()->T){
    when(this){
        is Otherwise -> block()
        is WithData -> this.data
    }
}