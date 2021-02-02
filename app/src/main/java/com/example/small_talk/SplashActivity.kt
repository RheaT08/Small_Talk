package com.example.small_talk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        //TODO: sjekk om bruker er logget inn
        //For å se hvordan aktiviteten er når det tar lang tid. Får tråder til å stoppe litt opp. Programmet sover i xx sekunder.
        Thread.sleep(2000)

        //val sharedPref = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val userLoggedIn = false   //TODO: Senere endre slik at den faktisk sjekker om bruker er logget in eller ikke.

        Timer("SplashTest",false).schedule(5000){

            //Intent - tar brukeren med til neste aktivitet/fragment utifra om de er logget inn eller ikke.
            //overfør brukeren videre fra LoginActivity til chatfragment(MainActivity)
            val activityIntent = if(userLoggedIn){
                Intent(this, MainActivity::class.java)
            }
            else{
                Intent(this, LoginActivity::class.java)
            }


            startActivity(activityIntent) //viderefører brukeren
        }
    }



}