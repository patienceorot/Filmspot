package com.patience.movieapp

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

data class PopularModel(val image:Int)

@Composable
fun Popularlist(model: PopularModel) {
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

val contactList = mutableListOf<PopularModel>().apply {


    add(PopularModel( R.drawable.ideaofyou))
    add(PopularModel( R.drawable.fastx))
    add(PopularModel( R.drawable.kungfu4))
    add(PopularModel( R.drawable.lucifer))
    add(PopularModel( R.drawable.strangerthngs))
    add(PopularModel( R.drawable.tvd))
    add(PopularModel( R.drawable.suits))
    add(PopularModel( R.drawable.spiderverse))
    add(PopularModel( R.drawable.shadow))
    add(PopularModel( R.drawable.greyanatomy))
    add(PopularModel( R.drawable.dune2))

}

@Composable
fun Popularmovies () {


    LazyRow {
        items(contactList) { model ->
            Popularlist(model = model)
        }
    }
}

@Preview
@Composable
private fun Popularprev() {
    Popularmovies()
}


