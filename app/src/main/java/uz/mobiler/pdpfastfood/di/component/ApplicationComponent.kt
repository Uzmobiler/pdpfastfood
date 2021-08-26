package uz.mobiler.pdpfastfood.di.component

import dagger.Component
import dagger.Module
import uz.mobiler.pdpfastfood.LoginActivity
import uz.mobiler.pdpfastfood.di.module.NetworkModule
import uz.mobiler.pdpfastfood.ui.login.ConfirmFragment
import uz.mobiler.pdpfastfood.ui.login.PhoneFragment
import uz.mobiler.pdpfastfood.ui.login.RegisterFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(loginActivity: LoginActivity)

    fun inject(confirmFragment: ConfirmFragment)
    fun inject(registerFragment: RegisterFragment)
}