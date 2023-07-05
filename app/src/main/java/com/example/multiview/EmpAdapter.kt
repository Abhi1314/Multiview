package com.example.multiview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
const val itemright=0
const val itemleft=1
class EmpAdapter(val context: Context,val Employlist:ArrayList<ResponseEmp>): RecyclerView.Adapter<EmpAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val emp_name:TextView=itemView.findViewById(R.id.empName)
    val emp_id:TextView=itemView.findViewById(R.id.empID)
    val emp_age:TextView=itemView.findViewById(R.id.empAge)
    val emp_salary:TextView=itemView.findViewById(R.id.empSalary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpAdapter.ViewHolder {
//       if (viewType== itemright){
           val view=LayoutInflater.from(parent.context).inflate(R.layout.lay2,parent,false)
           return ViewHolder(view)
//       }else{
//           val view=LayoutInflater.from(parent.context).inflate(R.layout.lay1,parent,false)
//           return ViewHolder(view)
//       }
    }

    override fun onBindViewHolder(holder: EmpAdapter.ViewHolder, position: Int) {
        holder.emp_name.text=Employlist[position].employee_name
        holder.emp_id.text=Employlist[position].eid.toString()
        holder.emp_age.text=Employlist[position].employee_age.toString()
        holder.emp_salary.text=Employlist[position].employee_salary.toString()
    }

//    override fun getItemViewType(position: Int): Int {
//        if(Employlist[position].employee_age>50){
//            return itemright
//        }else{
//            return itemleft
//        }
//
//    }
    override fun getItemCount(): Int {
        return Employlist.size
    }

}