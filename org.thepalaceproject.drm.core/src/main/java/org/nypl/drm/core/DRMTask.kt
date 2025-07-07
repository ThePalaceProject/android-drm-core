package org.nypl.drm.core

import org.slf4j.Logger
import org.slf4j.MDC

class DRMTask private constructor(
  private val logger: Logger,
  private val steps: MutableList<DRMStep>,
  private val attributes: MutableMap<String, String>
) {

  inner class DRMStep internal constructor(
    private val message: String,
    private var failedProp: Throwable?
  ) {
    val failed: Throwable?
      get() = this.failedProp

    fun recordFailure(
      exception: Throwable
    ) {
      this.failedProp = exception
    }
  }

  companion object {
    fun create(logger: Logger): DRMTask {
      return DRMTask(
        logger = logger,
        steps = mutableListOf(),
        attributes = mutableMapOf()
      )
    }
  }

  fun attribute(
    name: String,
    value: Any
  ) {
    val freshName = this.freshName(name)
    val valueText = value.toString()
    MDC.put(name, valueText)
    this.attributes[freshName] = valueText
  }

  private fun freshName(
    name: String
  ): String {
    var nameInd = 0
    var nameNow = name
    while (true) {
      if (this.attributes.containsKey(nameNow)) {
        nameNow = "${name}_$nameInd"
        ++nameInd
      } else {
        return nameNow
      }
    }
  }

  fun recordFailure(
    exception: Throwable
  ) {
    this.steps.last().recordFailure(exception)
  }

  fun beginStep(
    message: String
  ): DRMStep {
    this.logger.debug("{}", message)
    val step =
      this.DRMStep(
        message = message,
        failedProp = null
      )
    this.steps.add(step)
    return step
  }

  fun <T> executeStep(
    message: String,
    execute: () -> T
  ): T {
    val step = this.beginStep(message)
    return try {
      execute()
    } catch (e: Throwable) {
      step.recordFailure(e)
      throw e
    }
  }

  fun <R> succeeded(x: R): DRMTaskResult.DRMTaskSuccess<R> {
    return DRMTaskResult.DRMTaskSuccess(
      attributes = this.attributes.toMap(),
      steps = this.steps.toList(),
      value = x
    )
  }

  fun <R> failed(): DRMTaskResult.DRMTaskFailure<R> {
    return DRMTaskResult.DRMTaskFailure(
      attributes = this.attributes.toMap(),
      steps = this.steps.toList()
    )
  }

  fun <R> cancelled(): DRMTaskResult.DRMTaskCancelled<R> {
    return DRMTaskResult.DRMTaskCancelled(
      attributes = this.attributes.toMap(),
      steps = this.steps.toList()
    )
  }
}
