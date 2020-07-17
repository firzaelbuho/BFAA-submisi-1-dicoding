package com.proximastudio.submisidicoding2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list.view.*


class Adapter (private val list:ArrayList<User>) : RecyclerView.Adapter<Adapter.Holder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false))

    }



    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {

        holder.view.username.text = list?.get(position)?.username
        holder.view.name.text = list?.get(position)?.name

        holder.view.location.text= list?.get(position)?.location


        Glide.with(holder.view)
            .load(list.get(position)?.avatar)
            .into(holder.view.avatar)


       holder.view.btn.setOnClickListener {
           val user = list.get(position)
           val context = holder.view.context
           val intent = Intent(context, Detail::class.java)
           intent.putExtra("key", user)
           context.startActivity(intent)
       }
        //clickable item

        holder.view.setOnClickListener {
            Toast.makeText(holder.view.context, "ini toast", Toast.LENGTH_SHORT).show()
            val user = list.get(position)
            val context = holder.view.context
            val intent = Intent(context, Detail::class.java)
            intent.putExtra("key", user)
            context.startActivity(intent)
        }
//
//            bundle.putString("name", list.get(position)?.name)
//            bundle.putString("desc", list.get(position)?.desc)
//            intent.putExtras(bundle)
//            context.startActivity(intent)
//
//        }
//        holder.view.btn2.setOnClickListener{
//
//            val context = holder.view.context
//            val intent = Intent(context, activity3::class.java)
//            context.startActivity(intent)

        //}
    }

    override fun getItemCount(): Int = list?.size

    //class holder

    class Holder(val view: View) : RecyclerView.ViewHolder(view){




    }
}
