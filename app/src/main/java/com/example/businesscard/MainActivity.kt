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
        modifier = modifier // Light green background
            .fillMaxSize(),
        color = Color(0xFFD0F0C0) // Light green background
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp) // Reduced padding
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
                    .padding(bottom = 8.dp) // Reduced padding
                    .background(color = Color(0xFF00008B)) // Light green background
            )
            Text(text = name, style = MaterialTheme.typography.headlineMedium)
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.weight(1f)) // Pushes the contact info to the bottom
            Text(text = phone, style = MaterialTheme.typography.bodyMedium)
            Text(text = email, style = MaterialTheme.typography.bodyMedium)
            Text(text = website, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.weight(0.1f)) // Pushes the contact info to the bottom
        }
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