package com.heb.design_pattern_practice

interface Book {
    fun read()
}

class Manual : Book {

    override fun read() {
        println("Reading a manual")
    }
}

class Novel : Book {

    override fun read() {
        println("Reading a novel")
    }
}

class BookComposite {

    private val books = arrayListOf<Book>()

    fun addBookToRead(book: Book) {
        books.add(book)
    }

    fun readAllBooks() {
        books.forEach { it.read() }
    }
}

fun main() {
    val bookComposite = BookComposite()
    bookComposite.addBookToRead(Manual())
    bookComposite.addBookToRead(Novel())
    bookComposite.addBookToRead(Novel())

    bookComposite.readAllBooks()

    //result
    //Reading a manual
    //Reading a novel
    //Reading a novel
}