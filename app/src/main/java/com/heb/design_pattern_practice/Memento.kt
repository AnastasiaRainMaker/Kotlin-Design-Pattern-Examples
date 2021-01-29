package com.heb.design_pattern_practice

//allows to restore state via rollback

data class Memento(val state: String)

class Originator(var state: String) {

    fun createMemento(): Memento = Memento(state)

    fun restore(memento: Memento) {
        state = memento.state
    }
}

class Movie {

    val mementoList = ArrayList<Memento>()

    fun saveState(state: Memento) {
        mementoList.add(state)
    }

    fun restore(index: Int): Memento =
        mementoList[index]
}

class VideoPlayer(private val movie: Movie) {

    private val originator = Originator("Playing from beginning")

    fun playFromBeginning() {
        if (movie.mementoList.isEmpty())
            movie.saveState(originator.createMemento())
        else originator.restore(movie.restore(0))
    }

    fun pauseMovie() {
        originator.state = "Paused"
    }

    fun resumeMovie() {
        with(movie) {
            mementoList.removeLast()
            originator.restore(restore(mementoList.lastIndex))
        }
    }

}