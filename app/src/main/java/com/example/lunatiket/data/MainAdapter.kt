import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lunatiket.R
import com.example.lunatiket.data.remote.response.AirportResponseItem


class MainAdapter(val context: Context, val list: List<AirportResponseItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name1: TextView = view.findViewById(R.id.airport)
        val name2: TextView = view.findViewById(R.id.city_name)
        val name3: TextView = view.findViewById(R.id.region)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.list_item_flight,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name1.text = list[position].name
        holder.name2.text = list[position].city
        holder.name3.text = list[position].region

        Log.d("title","Response : $holder")
    }
}