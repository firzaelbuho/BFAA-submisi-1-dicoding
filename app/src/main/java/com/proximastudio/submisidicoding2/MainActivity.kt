package com.proximastudio.submisidicoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list = ArrayList<User>()
    //Data Users
    val usernameList = arrayOf("JakeWharton","amitshekhariitbhu",
        "romainguy","chrisbanes","tipsy","ravi8x",
        "jasoet","budioktaviyan","hendisantika",
        "sidiqpermana"

    )
    val nameList = arrayOf("Jake Wharton","Amit Shekhar",
        "Romain Guy","Chris Banes","David","Ravi Tamada",
        "Deny Prasetya","Budi Oktaviyan","Hendi Santika",
        "Sidiq Permana"

        )
    val companyList = arrayOf("Google, Inc.","@MindOrksOpenSource",
    "Google","@google working on @android","Working Group Two","AndroidHive | Droid5",
    "@gojek-engineering","@KotlinID","@JVMDeveloperID @KotlinID @IDDevOps",
    "Nusantara Beta Studio"

    )
    val locationList = arrayOf("Pittsburgh, PA, USA","New Delhi, India",
        "California","Sydney, Australia","Trondheim, Norway","India",
        "Kotagede, Yogyakarta, Indonesia","Jakarta, Indonesia","Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"

        )
    val avatarList = arrayOf(R.drawable.user1,R.drawable.user2,R.drawable.user3,
        R.drawable.user4,R.drawable.user5,R.drawable.user6,R.drawable.user7,
        R.drawable.user8,R.drawable.user9,R.drawable.user10
        )
    var repositoryList = arrayOf(
        102,37,9,30,56,28,44,110,1064,65

    )
    var followerList = arrayOf(
        56995,5153,7972,14725,788,18628,277,178,428,465

    )
    var followingList = arrayOf(
        12,2,0,1,0,3,39,23,61,10

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView.setHasFixedSize(true)


        addData()
        showRecyclerList()
        setActionBarTitle("Github User - List")


    }

    fun showRecyclerList(){
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(list)
        adapter.notifyDataSetChanged()

        //tampilkan data dalam recycler view
        mRecyclerView.adapter = adapter

    }
    private fun showRecyclerGrid() {
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        val gridAdapter = GridAdapter(list)
        mRecyclerView.adapter = gridAdapter
    }
    private fun showRecyclerCard() {
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val cardAdapter = Adapter(list)
        mRecyclerView.adapter = cardAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                setActionBarTitle("Github User - List")
                showRecyclerList()
            }
            R.id.action_grid -> {
                setActionBarTitle("Github User - Grid")
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                setActionBarTitle("Github User - Card")
                showRecyclerCard()
            }
        }
    }

    fun addData(){
        for (i in 0 until 10){

            list.add(User(usernameList[i],nameList[i],avatarList[i],companyList[i],
                locationList[i],repositoryList[i],followerList[i],followingList[i]))


            if(10 - 1 == i){
                // init adapter yang telah dibuat tadi

            }


        }
    }
    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }
}
