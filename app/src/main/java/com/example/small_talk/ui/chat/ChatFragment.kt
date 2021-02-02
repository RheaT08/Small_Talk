package com.example.small_talk.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.small_talk.R
import kotlinx.android.synthetic.main.fragment_chat.*

//TODO: Implementer UI på recyclerview. Lag cardviews etc...

class ChatFragment : Fragment() {


    //Adapter, and greier for display av info om boligene. Håndtering av RecyclerView layouten
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    //Dummy string meldinger
    val contacts = mutableListOf<String>("Amalie","Sara","Oskar")


    private lateinit var chatViewModel: ChatViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_chat, container, false)
        //val textView: TextView = root.findViewById(R.id.text_chat)


        //Dette vil vise det du vil vise når fragmentet starter. F.eks min chat_recyclerview.
        chatViewModel.text.observe(viewLifecycleOwner, Observer {
            displayChat(contacts)
        })

        return root
    }



    //Displays the chats
    private fun displayChat(list: MutableList<String>){

        viewManager = LinearLayoutManager(activity)
        viewAdapter = ChatAdapter(list)  //oppretter en objekt av MyAdapter klassen min. Parameter en mutablelist.


        recyclerView = recyclerview_chat.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            //adapter = viewAdapter
            recyclerview_chat.adapter = viewAdapter
        }
    }

}