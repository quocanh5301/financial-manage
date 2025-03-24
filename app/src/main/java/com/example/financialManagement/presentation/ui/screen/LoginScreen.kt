package com.example.financialManagement.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.financialManagement.R
import com.example.financialManagement.core.style.MyTextStyle
import com.example.financialManagement.core.util.Resource
import com.example.financialManagement.navigation.Screen
import com.example.financialManagement.presentation.ui.compose.LoginTextField
import com.example.financialManagement.presentation.ui.compose.RoundTopCornerField
import com.example.financialManagement.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsState()
    val focusManager: FocusManager = LocalFocusManager.current

    Box(modifier = Modifier
        .background(
            brush = Brush.linearGradient(
                start = Offset(0f, 400f),
                end = Offset(1000f, 0f),
                colors = listOf(
                    Color(0xFF653AB3),
                    Color(0xFF5028ED),
//                    Color(0xFF1A1A4D),
                    Color(0xFF0A0A29)
                )
            )
        )
        .clickable { focusManager.clearFocus() }) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = "Custom Icon",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(18.dp))
            RoundTopCornerField {
                Column(modifier = Modifier.padding(16.dp)) {
                    Spacer(modifier = Modifier.height(20.dp))
                    LoginTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = "Email",
                        placeholder = "Enter your email",
                        leadingIcon = Icons.Default.Email
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LoginTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        placeholder = "Enter your password",
                        leadingIcon = Icons.Default.Lock,
                        isPassword = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = "Don’t have an account? ",
                            style = MyTextStyle.f16m,
                        )
                        Text(
                            text = "Sign Up",
                            color = Color(0xFF6A5AE0), // Purple color
                            style = MyTextStyle.f17sb,
                            textDecoration = TextDecoration.None,
                            modifier = Modifier.clickable { }
                        )
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black, // Custom background color
                            contentColor = Color.White // Text color
                        ),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            if (loginState !is Resource.Loading) {
                                viewModel.login(email, password)
                            }
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Text("Log In", modifier = Modifier.align(Alignment.Center))
                            when (loginState) {
                                is Resource.Loading -> CircularProgressIndicator(
                                    modifier = Modifier.align(
                                        Alignment.CenterEnd
                                    ),
                                )

                                is Resource.Error -> Icon(
                                    modifier = Modifier.align(Alignment.CenterEnd),
                                    imageVector = Icons.Default.Error,
                                    contentDescription = "Home Icon",
                                    tint = Color.Red,
                                )

                                is Resource.Success -> {
                                    navController.navigate(Screen.Base.route) {
                                        popUpTo(Screen.Login.route) { inclusive = true }
                                    }
                                }

                                else -> {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
