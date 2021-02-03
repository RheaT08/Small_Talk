package com.example.small_talk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        //TODO: sjekk om bruker er logget inn
        //For å se hvordan aktiviteten er når det tar lang tid. Får tråder til å stoppe litt opp. Programmet sover i xx sekunder.
        //Thread.sleep(2000)


        val sharedPref = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val userLoggedIn = sharedPref.getBoolean(LoginActivity.LOGGED_IN_KEY,false)   //TODO: Senere endre slik at den faktisk sjekker om bruker er logget in eller ikke.



        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        Handler(Looper.getMainLooper()).postDelayed({

            //Intent - tar brukeren med til neste aktivitet/fragment utifra om de er logget inn eller ikke.
            //overfør brukeren videre fra LoginActivity til chatfragment(MainActivity)
            val activityIntent = if(userLoggedIn){
                Intent(this, MainActivity::class.java)
            }
            else{
                Intent(this, LoginActivity::class.java)
            }


            startActivity(activityIntent) //viderefører brukeren
            finish()

        }, 5000)   //3 seconds on splashscreen

        }//onCreate
}//END



