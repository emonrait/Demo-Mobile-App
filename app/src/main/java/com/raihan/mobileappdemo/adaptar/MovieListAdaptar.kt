package com.raihan.mobileappdemo.adaptar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.raihan.mobileappdemo.R
import com.raihan.mobileappdemo.model.Movie
import java.util.ArrayList

class MovieListAdaptar(
    private var movieList: ArrayList<Movie>,
    listenerInit: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var requestFilterList = ArrayList<Movie>()
    lateinit var mcontext: Context

    var listener: OnItemClickListener


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        requestFilterList = movieList
        listener = listenerInit


    }

    interface OnItemClickListener {
        fun onItemClick(item: Movie?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val atmListView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_movie_list, parent, false)
        val sch = MyViewHolder(atmListView)
        mcontext = parent.context
        return sch
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = requestFilterList[position]
        val menu_name: TextView? = holder.itemView.findViewById(R.id.menu_name)
        val menu_desc: TextView? = holder.itemView.findViewById(R.id.menu_desc)
        val menu_icon: ImageView? = holder.itemView.findViewById(R.id.menu_icon)

        menu_name!!.text = currentItem.title
        menu_desc!!.text = currentItem.duration + " - " + currentItem.genre
        currentItem.imageId?.let { menu_icon?.setImageResource(it) }


        menu_name.setOnClickListener {
            val selectedList: Movie = currentItem
            listener.onItemClick(selectedList)

        }
    }

    override fun getItemCount(): Int {
        return requestFilterList.size
       // notifyDataSetChanged()
       // Log.e("requestFilterList--->", requestFilterList.size.toString())
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                if (constraint.toString().isEmpty()) {
                    requestFilterList = movieList
                } else {

                    val resultList = ArrayList<Movie>()
                    for (row in movieList) {
                        if (
                            row.title.toString().lowercase()
                                .contains(constraint.toString().lowercase())

                            || row.genre.toString().lowercase()
                                .contains(
                                    constraint.toString().lowercase()
                                )
                        ) {
                            resultList.add(row)
                        }
                    }
                    requestFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = requestFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                requestFilterList = results?.values as ArrayList<Movie>
                notifyDataSetChanged()
            }

        }
    }
}