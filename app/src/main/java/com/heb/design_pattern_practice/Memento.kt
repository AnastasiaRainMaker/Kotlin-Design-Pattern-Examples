package com.heb.design_pattern_practice

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
        if (movie.mementoList.isEmpty()) {
            movie.saveState(originator.createMemento())
            println("New state is ${originator.state}")
        } else {
            originator.restore(movie.restore(0))
            println("New state is ${originator.state}")
        }
    }

    fun watchFor(time: Int) {
        originator.state = "Watched for $time min"
        movie.saveState(originator.createMemento())
        println("New state is ${originator.state}")
    }

    fun pauseMovie() {
        originator.state = "Paused"
        movie.saveState(originator.createMemento())
        println("New state is ${originator.state}")
    }

    fun resumeMovie() {
        with(movie) {
            mementoList.removeLast()
            originator.restore(restore(mementoList.lastIndex))
            println("New state is ${originator.state}")
        }
    }

}

fun main() {
    val videoPlayer = VideoPlayer(Movie())
    videoPlayer.playFromBeginning()
    videoPlayer.watchFor(60)
    videoPlayer.pauseMovie()
    videoPlayer.resumeMovie()

    //result
    //New state is Playing from beginning
    //New state is Watched for 60 min
    //New state is Paused
    //New state is Watched for 60 min
}