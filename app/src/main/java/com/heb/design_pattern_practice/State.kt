package com.heb.design_pattern_practice

open class AuthorizationState

object Unauthorized : AuthorizationState()

class Authorized(val userName: String) : AuthorizationState()

class AuthorizationVerifier {

    private var state: AuthorizationState = Unauthorized

    private fun isAuthorized(): Boolean =
        when (state) {
            is Unauthorized -> false
            is Authorized -> true
            else -> false
        }

    fun logIn(userName: String) {
        state = Authorized(userName)
    }

    fun logOff() {
        state = Unauthorized
    }

    override fun toString(): String =
        if (isAuthorized()) "User is logged in as ${(state as Authorized).userName}" else "Access denied"
}

/**
 * Demo
 */
private val authorizationVerifier = AuthorizationVerifier()

fun main() {
    authorizationVerifier.logIn("Jane")
    println(
        authorizationVerifier.toString()
    )
    //result -> User is logged in as Jane
    authorizationVerifier.logOff()
    println(
        authorizationVerifier.toString()
    )
    //result -> Access denied
}


