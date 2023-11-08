package com.ifal.project1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//    lateinit var matkul : EditText
//    lateinit var dosen : EditText
//    lateinit var submit : Button
//    lateinit var data : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        matkul = findViewById(R.id.editMatkul)
        val matkul = findViewById<EditText>(R.id.editMatkul)
//        dosen = findViewById(R.id.editDosenPengampu)
        val dosen = findViewById<EditText>(R.id.editDosenPengampu)
        val submit = findViewById<Button>(R.id.btnSubmit)
        val data = findViewById<TextView>(R.id.txtOutput)



        submit.setOnClickListener{
//            data.text = ("Data Perkuliahan : \nNama Mata Kuliah : "+matkul.text+"\nDosen Pengampu : "+dosen.text)
            var matkul = matkul.text
            var dosen = dosen.text

            data.text = ("Data Perkuliahan : " +
                    "\nNama Mata Kuliah : "+ matkul +
                    "\nDosen Pengampu : "+dosen)
        }


    }
}