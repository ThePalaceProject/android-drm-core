package org.nypl.drm.core

/**
 * The result of a multi-step DRM operation.
 */

sealed class DRMTaskResult<out T> {

  abstract val attributes: Map<String, String>

  abstract val steps: List<DRMTask.DRMStep>

  abstract fun <U> map(f: (T) -> U): DRMTaskResult<U>

  data class DRMTaskCancelled<out T>(
    override val attributes: Map<String, String>,
    override val steps: List<DRMTask.DRMStep>
  ) : DRMTaskResult<T>() {
    override fun <U> map(f: (T) -> U): DRMTaskResult<U> {
      return DRMTaskCancelled(this.attributes, this.steps)
    }
  }

  data class DRMTaskFailure<out T>(
    override val attributes: Map<String, String>,
    override val steps: List<DRMTask.DRMStep>
  ) : DRMTaskResult<T>() {
    override fun <U> map(f: (T) -> U): DRMTaskResult<U> {
      return DRMTaskFailure(this.attributes, this.steps)
    }
  }

  data class DRMTaskSuccess<out T>(
    override val attributes: Map<String, String>,
    override val steps: List<DRMTask.DRMStep>,
    val value: T
  ) : DRMTaskResult<T>() {
    override fun <U> map(f: (T) -> U): DRMTaskResult<U> {
      return DRMTaskSuccess(this.attributes, this.steps, f(this.value))
    }
  }
}
