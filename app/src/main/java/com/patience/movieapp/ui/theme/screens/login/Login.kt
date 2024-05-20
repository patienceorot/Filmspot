package com.patience.movieapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.patience.movieapp.R
import com.patience.movieapp.model.AuthViewModel
import com.patience.movieapp.navigation.ROUTE_HOME
import com.patience.movieapp.navigation.ROUTE_LOGIN
import com.patience.movieapp.navigation.ROUTE_REG

@Composable
fun Loginscreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize())
    {

        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        var context= LocalContext.current

        Image(
            painter = painterResource(id = R.drawable.pinkpurple),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
//                .background(color = Color.Black)
                .padding(vertical = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(120.dp))


            Text(
                text = " Welcome Back ",
                color = Color.White,
                fontSize = 40.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Log in to  your account",
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(30.dp))



            OutlinedTextField(
                value = email,
                onValueChange = { email = it },

                label = {
                    Text(
                        text = "user@gmail.com",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),

                modifier = Modifier
                    .width(350.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )

            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },

                label = {
                    Text(
                        text = "Password",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),

                modifier = Modifier
                    .width(350.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Forgot password?",
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Right

            )

            Spacer(modifier = Modifier.height(50.dp))
            OutlinedButton(
                onClick = {
                    val mylogin= AuthViewModel(navController, context )
                    mylogin.login(email.trim(),password.trim())
                    navController.navigate(ROUTE_HOME)
                },
                Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            )
            {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    color = Color.Magenta
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Don't have an account?",
                color = Color.DarkGray,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Sign up",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate(ROUTE_REG)
                }

            )


        }
    }
}
@Preview
@Composable
private fun Loginprev() {
    Loginscreen(navController = rememberNavController())
}