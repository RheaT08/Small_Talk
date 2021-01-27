package com.example.small_talk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.small_talk.pages.pages.login.LoginFragment
import com.example.small_talk.pages.pages.welcome.WelcomeFragment
import kotlinx.android.synthetic.main.fragments_main.*


class FragmentsActivity : AppCompatActivity(R.layout.fragments_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Fragments, progmatisk.
        //Første gang den kjører (state er null), kommer du inn til et Fragment. (WelcomeFragment).
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<WelcomeFragment>(R.id.fragment_container_view)  //Login_Fragment?
            }
        }

        //Etter velkoms skjerm, trykk button -> Chats?
        next_page_button.setOnClickListener{
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null) //legger fragment fra før bak. og lar oss hente den tilbake, ved tilbakeknapp.
                replace(R.id.fragment_container_view,LoginFragment()) //erstatter welcome, med Login page
            }
        }
        

    }//onCreate


}