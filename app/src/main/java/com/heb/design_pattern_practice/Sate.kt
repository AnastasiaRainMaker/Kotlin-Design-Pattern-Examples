package com.heb.design_pattern_practice

open class AuthorizationState

object Unauthorized : AuthorizationState()

class Authorized(val userName: String) : AuthorizationState()

class AuthorizationVerifier {

    private var _state: AuthorizationState = Unauthorized

    private fun isAuthorized(): Boolean =
        when (_state) {
            is Unauthorized -> false
            is Authorized -> true
            else -> false
        }

    fun logIn(userName: String) {
        _state = Authorized(userName)
    }

    fun logOff() {
        _state = Unauthorized
    }

    override fun toString(): String =
        if (isAuthorized()) "User is logged in as ${(_state as Authorized).userName}" else "Access denied"
}