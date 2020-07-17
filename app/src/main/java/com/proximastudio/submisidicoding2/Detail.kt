package com.proximastudio.submisidicoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list.view.*

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail User"

        val user = intent.getParcelableExtra("key") as User
        Glide.with(this)
            .load(user.avatar)
            .into(avatar)
        username.text = user.username
        name.text = user.name
        company.text = user.company
        location.text = user.location
        repository.text = user.repository.toString()
        follower.text = user.follower.toString()
        following.text = user.following.toString()


    }
}
