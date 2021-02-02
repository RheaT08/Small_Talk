package com.example.small_talk.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.small_talk.LoginActivity
import com.example.small_talk.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        val viewProfile = inflater.inflate(R.layout.fragment_profile, container, false)
        val textView: TextView = viewProfile.findViewById(R.id.text_profile)


        //Ting som skal fungere, og vises, settes her....???? Why??
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

            logout_btn.setOnClickListener {

                val sharedPref = activity?.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                sharedPref?.edit()?.putBoolean(LoginActivity.LOGGED_IN_KEY,false)?.apply()  //putBoolean med false, lagres det at vi ikke er logget inn lenger.

                //Tilbake til login siden.
                val backToLogin = Intent(activity,LoginActivity::class.java)  //hvorfor spesifisere "activity" og ikke this, eller ingenting?
                startActivity(backToLogin)
            }
        })

        return viewProfile //setter opp layout(xml-en)

    }//End of onCreateView


} //END