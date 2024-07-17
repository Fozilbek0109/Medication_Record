package uz.coder.medicationrecord.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.coder.medicationrecord.database.DoriModell
import uz.coder.medicationrecord.databinding.ItemDoriBinding
import java.io.File

class AdapterDoriRec(var list: List<DoriModell>, var delite: () -> Unit):RecyclerView.Adapter<AdapterDoriRec.VH>() {
    inner class VH(var binding: ItemDoriBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemDoriBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.apply {
            doriImg.setImageURI(Uri.fromFile(File(list[position].img)))
            name.text = list[position].doriName
            startDate.text = list[position].chiqqanVaqti
            endDate.text = list[position].tugashVaqti
        }
    }


}