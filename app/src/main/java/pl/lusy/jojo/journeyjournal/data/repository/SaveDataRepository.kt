package pl.lusy.jojo.journeyjournal.data.repository

interface SaveDataRepository<in T> {
    fun save(data: T)
}
