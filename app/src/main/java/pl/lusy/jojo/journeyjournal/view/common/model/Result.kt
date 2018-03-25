package pl.lusy.jojo.journeyjournal.view.common.model

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

class Result<out T>(
    val data: T? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)


fun <T> Flowable<T>.toResult(): Flowable<Result<T>> {
    return compose { item ->
        item
            .map { Result(data = it) }
            .onErrorReturn { e -> Result(errorMessage = e.message) }
            .startWith(Result(isLoading = true))
            .observeOn(AndroidSchedulers.mainThread())
    }
}
