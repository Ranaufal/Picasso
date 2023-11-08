package com.ifal.project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LimaActivity : AppCompatActivity() {
    lateinit var onnim:TextView
    lateinit var onprodi:TextView
    lateinit var onuas:TextView
    lateinit var onharian:TextView
    lateinit var ontotal:TextView
    lateinit var back: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lima)

//        onnim = findViewById(R.id.txtOutputNim)
//        onprodi = findViewById(R.id.txtOutputProdi)
//        onuas = findViewById(R.id.txtOutputUas)
//        onharian = findViewById(R.id.txtOutputHarian)
        ontotal = findViewById(R.id.txtOutputTotal)

        val bundle = intent.extras
        if(bundle != null){
//            onnim.text = "Nim : ${bundle.getString("nim")}"
//            onprodi.text = "Prodi : ${bundle.getString("prodi")}"
//            onuas.text = "Uas : ${bundle.getString("uas")}"
//            onharian.text = "Harian : ${bundle.getString("harian")}"
//            ontotal.text = "TOTAL : ${bundle.getString("total")}"

            ontotal.text = bundle.getString("fullString")
        }

        back = findViewById(R.id.btnBack)
        back.setOnClickListener {
            val intent = Intent(this@LimaActivity, EmpatActivity::class.java)
            startActivity(intent)
        }
    }
}