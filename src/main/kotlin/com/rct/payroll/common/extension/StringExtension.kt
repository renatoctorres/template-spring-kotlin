package com.rct.payroll.common.extension

import java.util.UUID

private val ONLY_CHARS_AND_NUMBERS = "[^A-Za-z0-9]".toRegex()
private val ONLY_NUMBERS = "[^0-9]".toRegex()

val String.Companion.EMPTY: String get() = ""

fun String.onlyNumbers() = this.replace(regex = ONLY_NUMBERS, replacement = String.EMPTY)

fun String.onlyCharsAndNumbers() = this.replace(regex = ONLY_CHARS_AND_NUMBERS, replacement = String.EMPTY)

fun String.toUUID(): UUID = UUID.fromString(this)
