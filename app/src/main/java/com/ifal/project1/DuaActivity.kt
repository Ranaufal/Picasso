package com.ifal.project1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DuaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val tipeKamar = arrayOf<String>("Executive", "Standar","Economi","President Suite")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)

        val no_kamar = findViewById<EditText>(R.id.edtNoKamar)
        val harga_kamar = findViewById<EditText>(R.id.edtHargaKamar)
        val tipe_kamar = findViewById<Spinner>(R.id.spinTipeKamar)
        val biaya_tambahan = findViewById<EditText>(R.id.edtBiayaTambahan)
        val hari_menginap = findViewById<EditText>(R.id.edtHariMenginap)
        val btnproses = findViewById<Button>(R.id.proses)
        val output = findViewById<TextView>(R.id.txtOutput)

        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@DuaActivity,R.layout.spin_style,tipeKamar)
        aa.setDropDownViewResource(R.layout.spin_style)
        tipe_kamar.adapter = aa
        tipe_kamar.onItemSelectedListener=this

        btnproses.setOnClickListener {
            val isi_no_kamar = no_kamar.text
            val isi_harga_kamar = harga_kamar.text.toString().toInt()
            val isi_tipe_kamar = tipe_kamar.selectedItem
            val isi_hari_menginap = hari_menginap.text.toString().toDouble()
            val isi_biaya_tambahan = biaya_tambahan.text.toString().toDouble()
            var total = (isi_harga_kamar * isi_hari_menginap) + isi_biaya_tambahan

            if(isi_hari_menginap > 10){
                total = (total * .1) + total
            }

            val isi_output = "Output : \n" +
                    "No Kamar : $isi_no_kamar \n" +
                    "Harga Kamar : $isi_harga_kamar \n" +
                    "Tipe Kamar : $isi_tipe_kamar \n" +
                    "Hari Menginap :$isi_hari_menginap \n" +
                    "Biaya Tambahan : $isi_biaya_tambahan \n\n" +
                    "Total Bayar : Rp.$total"

            output.setText("$isi_output")


        }



    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val pilihanTipe : String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, "Tipe Kamar dipilih $pilihanTipe",Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}