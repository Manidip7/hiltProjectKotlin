package com.example.myapplication.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.DebitcardCreditcardItemBinding
import com.example.myapplication.models.TestModelItem

class CardShowAdapter(private var context: Context, private val data: List<TestModelItem>, private val onItemClick: CardClickListener) :
    RecyclerView.Adapter<CardShowAdapter.CardViewHolder>() {

    interface CardClickListener{
        fun ButtonClicked(item:TestModelItem)
    }

    class CardViewHolder(var binding: DebitcardCreditcardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context,item:TestModelItem){
            binding.text1.text = item.body
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = DebitcardCreditcardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = data[position]
        holder.bind(context,item)
        holder.itemView.setOnClickListener {
        }

        holder.binding.bteCard.setOnClickListener {
            onItemClick.ButtonClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}