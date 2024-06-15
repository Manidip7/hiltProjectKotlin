package com.example.myapplication.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.DebitcardCreditcardItemBinding
import com.example.myapplication.models.TestModelItem
import kotlin.reflect.KFunction


class CardShowAdapter(private val data: List<TestModelItem>, private val onNoteClicked: (TestModelItem) -> Unit) :
    RecyclerView.Adapter<CardShowAdapter.CardViewHolder>() {


   inner class CardViewHolder(var binding: DebitcardCreditcardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:TestModelItem){
            binding.text1.text = item.body
            binding.root.setOnClickListener {
                onNoteClicked(item)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = DebitcardCreditcardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}