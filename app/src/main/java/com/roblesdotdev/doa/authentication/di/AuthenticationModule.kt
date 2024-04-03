package com.roblesdotdev.doa.authentication.di

import com.roblesdotdev.doa.authentication.data.matcher.EmailMatcherImpl
import com.roblesdotdev.doa.authentication.data.repository.AuthenticationRepositoryImpl
import com.roblesdotdev.doa.authentication.domain.matcher.EmailMatcher
import com.roblesdotdev.doa.authentication.domain.repository.AuthenticationRepository
import com.roblesdotdev.doa.authentication.domain.usecase.CheckSessionUseCase
import com.roblesdotdev.doa.authentication.domain.usecase.LoginUseCases
import com.roblesdotdev.doa.authentication.domain.usecase.LoginWithCredentialsUseCase
import com.roblesdotdev.doa.authentication.domain.usecase.SignupUseCases
import com.roblesdotdev.doa.authentication.domain.usecase.SignupWithCredentialsUseCase
import com.roblesdotdev.doa.authentication.domain.usecase.ValidateEmailUseCase
import com.roblesdotdev.doa.authentication.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun providesAuthenticationRepository(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesEmailMatcher(): EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun providesLoginUseCases(repository: AuthenticationRepository, matcher: EmailMatcher): LoginUseCases {
        return LoginUseCases(
            LoginWithCredentialsUseCase(repository),
            ValidateEmailUseCase(matcher),
            ValidatePasswordUseCase(),
        )
    }

    @Provides
    @Singleton
    fun providesSignupUseCases(repository: AuthenticationRepository, matcher: EmailMatcher): SignupUseCases {
        return SignupUseCases(
            SignupWithCredentialsUseCase(repository),
            ValidateEmailUseCase(matcher),
            ValidatePasswordUseCase(),
        )
    }


    @Provides
    @Singleton
    fun providesCheckSessionUseCase(repository: AuthenticationRepository): CheckSessionUseCase {
        return CheckSessionUseCase(repository)
    }
}