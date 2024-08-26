package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Fabrizio Leiva Misari",
                        title = "Software Engineer",
                        phone = "961-256-056",
                        email = "fabrizio.leiva@unmsm.edu.pe",
                        website = "@IamFabrizic",
                        logoResId = R.drawable.android_logo, // Replace with your actual logo resource ID
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phone: String,
    email: String,
    website: String,
    logoResId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color(0xFFD0F0C0) // Light green background
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f)) // Pushes the contact info to the bottom
            Image(
                painter = painterResource(id = logoResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(bottom = 8.dp)
                    .background(color = Color(0xFF00008B)) // Dark blue background
            )
            Text(text = name, style = MaterialTheme.typography.headlineMedium)
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.weight(1f)) // Pushes the contact info to the bottom
            ContactInfoRow(iconResId = R.drawable.ring_phone, text = phone)
            ContactInfoRow(iconResId = R.drawable.nuevo_correo_electronico, text = email)
            ContactInfoRow(iconResId = R.drawable.sitio, text = website)
            Spacer(modifier = Modifier.weight(0.1f)) // Pushes the contact info to the bottom
        }
    }
}

@Composable
fun ContactInfoRow(iconResId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Fabrizio Leiva Misari",
            title = "Software Engineer",
            phone = "961-256-056",
            email = "fabrizio.leiva@unmsm.edu.pe",
            website = "@IamFabrizic",
            logoResId = R.drawable.android_logo // Replace with your actual logo resource ID
        )
    }
}