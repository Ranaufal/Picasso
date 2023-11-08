package com.ifal.project1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class EmpatActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    lateinit var btnChange:Button
    lateinit var nim:EditText
    lateinit var spin_prodi:Spinner
    lateinit var uas:EditText
    lateinit var harian:EditText
    val l_prodi = arrayOf<String>("Manajemen Informatika","Teknologi Rekayasa Perangkat Lunak","Teknik Komputer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empat)

//        EditText
        nim = findViewById(R.id.edtNim)
        uas = findViewById(R.id.edtUas)
        harian = findViewById(R.id.edtHarian)

//        Spinner
        spin_prodi = findViewById(R.id.spinProdi)
        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@EmpatActivity,R.layout.spin_style,l_prodi)
        aa.setDropDownViewResource(R.layout.spin_style)
        spin_prodi.adapter = aa
        spin_prodi.onItemSelectedListener = this

//        Button
        btnChange = findViewById(R.id.btnProses)
        btnChange.setOnClickListener {
            val intent = Intent(this@EmpatActivity, LimaActivity::class.java)

            val bundle = Bundle()
            val nuas = uas.text.toString().toInt()
            val nharian = harian.text.toString().toInt()


            val total = (nuas / 2) + (nharian / 2)
            val fullBundle = "Nim : " + nim.text.toString() +
                    "\nProdi : " + spin_prodi.selectedItem.toString() +
                    "\nUAS : " + uas.text.toString() +
                    "\nHarian : " + harian.text.toString() +
                    "\nTotal : " +total

            bundle.putString("fullString", fullBundle)

//            bundle.putString("nim", nim.text.toString())
//            bundle.putString("uas", uas.text.toString())
//            bundle.putString("prodi", spin_prodi.selectedItem.toString())
//            bundle.putString("harian", harian.text.toString())
//            bundle.putString("total", total.toString())



            intent.putExtras(bundle)

            startActivity(intent)

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}