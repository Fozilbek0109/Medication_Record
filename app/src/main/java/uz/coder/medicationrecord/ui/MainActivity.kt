package uz.coder.medicationrecord.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import uz.coder.medicationrecord.R
import uz.coder.medicationrecord.adapter.AdapterDoriRec
import uz.coder.medicationrecord.database.DatabaseLocal
import uz.coder.medicationrecord.database.DoriModell
import uz.coder.medicationrecord.databinding.ActivityMainBinding
import uz.coder.medicationrecord.databinding.AddDialogViewBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adpterDoriRec: AdapterDoriRec
    private lateinit var list: ArrayList<DoriModell>
    private val db by lazy {
        DatabaseLocal.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.navView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this, binding.draveLayout, binding.toolbar, R.string.nav_open,
            R.string.nav_close
        )
        binding.draveLayout.addDrawerListener(toggle)
        toggle.syncState()
        list = ArrayList(db.dooriDao().allList());
        adpterDoriRec = AdapterDoriRec(list){

        }
        binding.rec.adapter = adpterDoriRec

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_registration -> {

            }

            R.id.menu_book -> {

            }
            R.id.menu_about_prog -> {

            }
        }
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_model_add -> {
                Toast.makeText(this@MainActivity,"bosildi",Toast.LENGTH_SHORT).show()
                val dialogBinding =
                    AddDialogViewBinding.inflate(LayoutInflater.from(this@MainActivity), null, false)
                val dialog = AlertDialog.Builder(this@MainActivity).create()
                dialog.setView(dialogBinding.root).apply {
                    dialog.show()
                    dialogBinding.apply {
                        save.setOnClickListener {
                            val name = editName.text.toString().trim()
                            val start_date = editStart.text.toString().trim()
                            val end_date = editEndDate.text.toString().trim()
                            val prise = editPrise.text.toString().trim()
                            val about = editAbout.text.toString().trim()
                            val count = editCount.text.toString().trim()
                            val doriModell = DoriModell(
                                doriName = name,
                                chiqqanVaqti = start_date,
                                tugashVaqti = end_date,
                                miqdori = count,
                                narxi = prise,
                                description = about,
                                img = "ewdewd"
                            )
                            list.add(doriModell)
                            db.dooriDao().add(doriModell)
                            adpterDoriRec.notifyItemInserted(list.size)
                            dialog.dismiss()

                        }
                    }
                }
            }
            R.id.menu_model_delit -> {
                adpterDoriRec.delite.apply {

                }
            }
        }
        return true

    }



}