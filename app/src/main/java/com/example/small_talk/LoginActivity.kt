package com.example.small_talk

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    companion object{                                   //midlertidig log in og log out state
        const val LOGGED_IN_KEY = "USER_IS_LOGGED_IN"  //logget in en gang i appen, vil den her være lagret. neste gang appen kjører går den direkte inne.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO: Implementere logg in og ut med dummy data.

        //LOG IN button --> Main Activity
        login_btn.setOnClickListener{

            val sharedPref = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
            sharedPref?.edit()?.putBoolean(LoginActivity.LOGGED_IN_KEY,true)?.apply()

            //if brukernavn input, og passord er riktig. La bruker logge in?
            if(2+2 == 4){
                login()
            }

        }

    }//onCreate


    //Login -> MainActivity (w/ Navbar)
    //Flag, kan ikke gå tilbake til login, etterpå ved "back".
    private fun login(){

        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK   //flag, sletter forrige activitet. Sletter login etter man har logget in.

        //intent.putExtra (sender info til andre acitivty, eller fragment).
        //intent.serializable (another way to pass data)
        intent.putExtra("user_id","enbrukerID unik fra lokal database")
        startActivity(intent)
    }



}


