package com.patience.movieapp.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patience.movieapp.R

data class TrendingModel(val image:Int)

@Composable
fun TrendingList(model: TrendingModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .clickable {}
            .size(250.dp)

    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",

            modifier = Modifier
                .padding(end=10.dp)
                .fillMaxSize(),

            contentScale=ContentScale.Crop
        )



    }}

val Trends = mutableListOf<TrendingModel>().apply {


    add(TrendingModel( R.drawable.moneyheist))
    add(TrendingModel( R.drawable.brigerton))
    add(TrendingModel( R.drawable.argylle))
    add(TrendingModel( R.drawable.myfault))
    add(TrendingModel( R.drawable.anyone))
    add(TrendingModel( R.drawable.meaculpa))
    add(TrendingModel( R.drawable.code8))
    add(TrendingModel( R.drawable.avatar))
    add(TrendingModel( R.drawable.lift))
    add(TrendingModel( R.drawable.upgraded))
    add(TrendingModel( R.drawable.tearsmith))
    add(TrendingModel( R.drawable.gentlemen2))
    add(TrendingModel( R.drawable.maxton))

}

@Composable
fun TrendingMovies () {


    LazyRow {
        items(Trends) { model ->
            TrendingList(model = model)
        }
    }
}

@Preview
@Composable
private fun Trendsprev() {
    TrendingMovies()
}


