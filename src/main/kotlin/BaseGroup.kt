abstract class BaseGroup<T, A> {

    protected val notes = mutableListOf<T>()
    protected val comments = mutableListOf<A>()
    protected var checkId = 1

    fun getNextId() = checkId++

    abstract fun add(note: T): T

    abstract fun edit(note: T): Boolean

    abstract fun get(note: T): String

    abstract fun delete(note: T): Boolean


    fun clear() {
        notes.clear()
    }
}