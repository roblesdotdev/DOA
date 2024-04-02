package com.roblesdotdev.doa.authentication.domain.matcher

interface EmailMatcher {
    fun isValid(email: String) : Boolean
}