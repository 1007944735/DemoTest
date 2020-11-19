package com.example.demotest

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {
    private lateinit var mHeaderView1: View
    private lateinit var mHeaderView2: View
    private lateinit var data: MutableList<String>
    private lateinit var adapter: ListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        layoutManager= LinearLayoutManager(this)
        recycler_list.layoutManager = layoutManager
        data = mutableListOf<String>()
        for (i in 0..200) {
            data.add("${i}")
        }
        adapter=ListAdapter(data)
        mHeaderView1=layoutInflater.inflate(R.layout.layout_header, recycler_list, false)
        mHeaderView2=layoutInflater.inflate(R.layout.layout_header, recycler_list, false)
        adapter.setHeaderView(mHeaderView1)
        recycler_list.adapter = adapter

        println(true || true && false)
    }

    fun change(view: View) {
        adapter.notifyItemChanged(0)
    }
}


class ListAdapter(data: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_list, data) {
    override fun convert(holder: BaseViewHolder, item: String) {
        val tvContent = holder.getView<TextView>(R.id.tv_content)
        tvContent.text = item
    }

}