package com.example.phonebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonebook.ui.theme.PhonebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var name by remember{
                mutableStateOf("")
            }

            var cell by remember{
                mutableStateOf("")
            }

            var contact_list by remember{
                mutableStateOf("")
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.dumbbells_2646970_640),
                    contentDescription = "Services Image",
                )

                Text("Phonebook")
                OutlinedTextField(
                    value = name,
                    onValueChange = { text ->
                        name = text
                    },
                    placeholder = {
                        Text("Enter a name")
                    }
                )
                Spacer(modifier = Modifier.size(20.dp))
                OutlinedTextField(
                    value = cell,
                    onValueChange = { text ->
                        cell = text
                    },
                    placeholder = {
                        Text("Enter a cell number")
                    }
                )

                Row {
                    Button(onClick = {
                        contact_list = contact_list + "\n" + name + " - " + cell
                        name = ""

                    }) {
                        Text("Add")
                    }
                    Button(onClick = {
                        name = ""
                        cell = ""
                    }) {
                        Text("Clear")
                    }
                    Button(onClick = {
                        name = ""
                        cell = ""
                        contact_list = ""
                    }) {
                        Text("Delete All")
                    }
                }

                Text(text = contact_list)

            }
        }
    }
}