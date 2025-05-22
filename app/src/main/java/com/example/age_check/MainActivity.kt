package com.example.age_check

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.text
import androidx.compose.ui.tooling.preview.Preview
import com.example.age_check.ui.theme.Age_CheckTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toIntOrNull() // age is now Int?

            if (name.isEmpty() || age == null) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin và tuổi hợp lệ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (age <= 0) {
                Toast.makeText(this, "Tuổi phải là số nguyên dương!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = when {
                age > 65 -> "Người già"
                age in 6..65 -> "Người lớn" // Adjusted typical adult range
                age in 2..6 -> "Trẻ em" // Or a more specific category
                else -> "Em bé" // age is 1
            }
            txtResult.text = "$name là $category"
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Age_CheckTheme {
            Greeting("Android")
        }
    }
}