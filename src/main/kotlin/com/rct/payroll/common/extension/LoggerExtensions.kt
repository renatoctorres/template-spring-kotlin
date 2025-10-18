package com.rct.payroll.common.extension

import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified T : Any> T.logger(): Lazy<Logger> = lazy { LoggerFactory.getLogger(T::class.java) }
