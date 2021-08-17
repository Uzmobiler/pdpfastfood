package uz.mobiler.pdpfastfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment_login).navigateUp()
}