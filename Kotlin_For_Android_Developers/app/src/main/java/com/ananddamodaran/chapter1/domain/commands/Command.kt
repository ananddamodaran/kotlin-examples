package com.ananddamodaran.chapter1.domain.commands

/**
 * Created by anand on 3/17/18.
 */
interface Command<out T> {
    fun execute(): T
}