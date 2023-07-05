package com.example.multiview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.multiview.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val mainBinding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
    val emplist:ArrayList<ResponseEmp> = arrayListOf()
    lateinit var db:EmpDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = EmpDatabase.getDatabase(this).getEmpDao()
        emplist.addAll(db.getAllUser())
        val url = "https://dummy.restapiexample.com/api/v1/employees"
        val jsonObject=JsonObjectRequest(Request.Method.GET,url,null, { response ->
            Log.d("Response",response.toString())
            val data = response.getJSONArray("data")
           for (i in 0 until data.length()){
              val employeobject =data.getJSONObject(i)
              val employee=ResponseEmp (
                  employeobject.getInt("id"),
                      employeobject.getString("employee_name"),
                      employeobject.getInt("employee_salary"),
                      employeobject.getInt("employee_age")

              )
               emplist.add(employee)
               lifecycleScope.launch {
                   db.insert(employee)
               }

           }

            mainBinding.empRv.adapter=EmpAdapter(this@MainActivity,emplist)
        }, {
            error->
            Log.d("error",error.toString())
        }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObject)

    }
}