package com.ifal.project1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TigaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var rg_bayar:RadioGroup
    lateinit var rb_bayar:RadioButton
    lateinit var chk_suitecase:CheckBox
    lateinit var chk_box:CheckBox
    lateinit var chk_bag:CheckBox

    val list_asal = arrayOf<String>("Padang","Jakarta","Bandung","Batam")
    val list_tujuan = arrayOf<String>("Sidoharjo","Makasar","Semarang")
    val list_jam = arrayOf<String>("06:00AM","08:00AM","12:00AM","14:00PM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiga)

//        TextView
        val output = findViewById<TextView>(R.id.txtOutput)

//        Edit Text
        val id = findViewById<EditText>(R.id.editId)
        val nama = findViewById<EditText>(R.id.editNama)
        val harga_tiket = findViewById<EditText>(R.id.editHargaTiket)
        val jumlah_beli = findViewById<EditText>(R.id.editJumlahBeli)

//        Spinner
        val kota_asal = findViewById<Spinner>(R.id.spinKotaAsal)
        val kota_tujuan = findViewById<Spinner>(R.id.spinKotaTujuan)
        val jam_keberangkatan = findViewById<Spinner>(R.id.spinJamKeberangkatan)

        val kotaasal_aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@TigaActivity , R.layout.spin_style , list_asal)
        val kotatujuan_aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@TigaActivity, R.layout.spin_style, list_tujuan)
        val jam_aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@TigaActivity, R.layout.spin_style, list_jam)
        kotaasal_aa.setDropDownViewResource(R.layout.spin_style)
        kotatujuan_aa.setDropDownViewResource(R.layout.spin_style)
        jam_aa.setDropDownViewResource(R.layout.spin_style)

        kota_asal.adapter = kotaasal_aa
        kota_tujuan.adapter = kotatujuan_aa
        jam_keberangkatan.adapter = jam_aa

        kota_asal.onItemSelectedListener=this
        kota_tujuan.onItemSelectedListener=this
        jam_keberangkatan.onItemSelectedListener=this

//        RadioButton
        rg_bayar = findViewById(R.id.rgBayar)

//        CheckBox
        chk_suitecase = findViewById(R.id.chkSuitecase)
        chk_box = findViewById(R.id.chkBox)
        chk_bag = findViewById(R.id.chkBag)

//        Button
        val btn_proses = findViewById<Button>(R.id.btnProses)
        btn_proses.setOnClickListener {
            val selectedRadio:Int = rg_bayar.checkedRadioButtonId
            rb_bayar = findViewById(selectedRadio)

            var totalBagasi:Int = 0
            val result = StringBuilder()
            if(chk_suitecase.isChecked){
                result.append("\nSuitcase : Rp.200000")
                totalBagasi += 200000
            }
            if(chk_box.isChecked){
                result.append("\nBox : Rp.100000")
                totalBagasi += 100000
            }
            if(chk_bag.isChecked){
                result.append("\nBag : Rp.50000")
                totalBagasi += 50000
            }

            val tid = id.text
            val tnama = nama.text
            val tkota_asal = kota_asal.selectedItem
            val tkota_tujuan = kota_tujuan.selectedItem
            val tharga_tiket = harga_tiket.text
            val tcara_bayar = rb_bayar.text
            val tjumlah_beli = jumlah_beli.text
            val tjam_keberangkatan = jam_keberangkatan.selectedItem

            output.text = "Output : " +
                    "\nId Pelanggan : " + tid +
                    "\nNama : " + tnama +
                    "\nKota Asal : " + tkota_asal +
                    "\nKota Tujuan : " + tkota_tujuan +
                    "\nHarga Tiket : " + tharga_tiket +
                    "\nCara Bayar : " + tcara_bayar +
                    "\nJumlah Beli : " + tjumlah_beli +
                    "\nJam Keberangkatan : " + tjam_keberangkatan +
                    "\nTambahan Bagasi : " + result +
                    "\nTotal Biaya Bagasi : Rp." + totalBagasi
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val pilihanTipe : String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, "Tipe Kamar dipilih $pilihanTipe", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}