package com.example.fetch_apprenticeship.util
/**
 * A sealed class representing the result of an asynchronous operation.
 *
 * The class has three sealed subclasses:
 *
 *   * `Success`: The operation succeeded and the data is available in the `data` property.
 *   * `Error`: The operation failed and the error message is available in the `message` property.
 *   * `Loading`: The operation is still in progress and the data is not yet available.
 */
sealed class Result<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T): Result<T>(data)
    class Error<T>(message: String, data: T? = null): Result<T>(data, message)
    class Loading<T>(data: T? = null): Result<T>(data)
}