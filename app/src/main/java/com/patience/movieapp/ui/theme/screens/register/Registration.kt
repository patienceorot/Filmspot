package com.patience.movieapp.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
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
import com.patience.movieapp.navigation.ROUTE_LOGIN

@Composable
fun Registration(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize())
    {

        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")

        }
        var confirmpass by remember {
            mutableStateOf("")
        }
        var username by remember {
            mutableStateOf("")
        }
        var rememberPassword by remember {
            mutableStateOf(false)
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
                .verticalScroll(rememberScrollState())
//                .background(color = Color.Black)
                .padding(vertical = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(120.dp))


            Text(
                text = " Registration ",
                color = Color.White,
                fontSize = 40.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Create your new account",
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "name"
                    )
                },
                label = {
                    Text(
                        text = "User Name",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                },
                modifier = Modifier
                    .width(350.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )

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
//
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },

                label = {
                    Text(
                        text = " Enter Password",
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
                value = confirmpass,
                onValueChange = { confirmpass = it },

                label = {
                    Text(
                        text = " Confirm Password",
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked =rememberPassword ,
                    onCheckedChange ={
                        rememberPassword=it
                    }
                )


                Text(
                    text = "Remember password",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Right
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedButton(
                onClick = {
                    val myregister= AuthViewModel(navController,context)
                    myregister.signup(email.trim(),password.trim(),confirmpass.trim())
                    navController.navigate(ROUTE_LOGIN)

                },
                Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            )
            {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    color = Color.Magenta
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Already have an account?",
                color = Color.DarkGray,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Sign in",
                fontSize = 13.sp,
                color = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate(ROUTE_LOGIN)
                }

            )

        }
    }
}



@Preview
@Composable
private fun Registerprev() {
    Registration(navController = rememberNavController())
}