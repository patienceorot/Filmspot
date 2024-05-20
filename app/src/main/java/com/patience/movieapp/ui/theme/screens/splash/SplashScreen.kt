package com.patience.movieapp.ui.theme.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.patience.movieapp.R
import com.patience.movieapp.navigation.ROUTE_REG
import kotlinx.coroutines.delay


@Composable
fun Splash(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(2500L)
        navController.navigate(ROUTE_REG)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lion),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
//                .background(Color.Blue)
                .padding(15.dp)
        )

        {
            Spacer(modifier = Modifier.height(60.dp))
            Text(text ="Filmspot",
                color = Color.Red,
                fontSize = 110.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(18.dp))
            Text(text ="Watch your favourite movies and TV shows for free",
                color = Color.White,
                fontSize = 50.sp,
                fontFamily = FontFamily.Default,
                fontStyle = FontStyle.Italic)
            Spacer(modifier = Modifier.height(70.dp))


            OutlinedButton(
                onClick = {
                    navController.navigate(ROUTE_REG)
                },
                Modifier.width(250.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow),
                shape= RoundedCornerShape(10.dp)
            )
            {
                Text(
                    text = "Get Started",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }




        }
    }}

@Preview
@Composable
private fun Splashprev() {
    Splash(navController = rememberNavController())
}