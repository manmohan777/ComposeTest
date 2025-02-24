package com.example.composetest.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R


@Composable
fun ItemCard(modifier: Modifier = Modifier,height:Dp=241.dp,width:Dp=170.dp) {
    Box(
        contentAlignment = Alignment.TopCenter, modifier = Modifier
            .background(
                Color.White, shape = RoundedCornerShape(10.dp)
            )
            .size(width,height)
            .fillMaxWidth(),
    ) {
        Column {
            Image(
                painterResource(R.drawable.product1),
                contentDescription = null,
                Modifier.size(170.dp, 124.dp), contentScale = ContentScale.FillBounds
            )
            Spacer(Modifier.size(5.dp))
            Column(Modifier.padding(horizontal = 5.dp)) {
                Text("Women Printed Kurta", fontSize = 14.sp)
//                Spacer(Modifier.size(1.dp))
                Text("something about this kurta that should come in two lines", fontSize = 10.sp, lineHeight = 11.sp)
                Spacer(Modifier.size(1.dp))
                Text("\u20B91500", fontSize = 12.sp, lineHeight = 13.sp)
//                Spacer(Modifier.size(1.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "\u20B92499",
                        fontSize = 12.sp,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        color = Color.Gray, lineHeight = 13.sp
                    )
                    Text(
                        " 40%Off",
                        fontSize = 12.sp,
                        color = Color.Red,
                        lineHeight = 13.sp
                    )
                }
//                Spacer(Modifier.size(1.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RatingBar(rating = 4.6f, spaceBetween = 3.dp)
                    Text(" 56890", color = Color.Gray, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
private fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    spaceBetween: Dp = 0.dp
) {

    val image = ImageBitmap.imageResource(id = R.drawable.star)
    val imageFull = ImageBitmap.imageResource(id = R.drawable.star_full)

    val totalCount = 5

    val height = LocalDensity.current.run { image.height.toDp() }
    val width = LocalDensity.current.run { image.width.toDp() }
    val space = LocalDensity.current.run { spaceBetween.toPx() }
    val totalWidth = width * totalCount + spaceBetween * (totalCount - 1)


    Box(
        modifier
            .width(totalWidth)
            .height(height)
            .drawBehind {
                drawRating(rating, image, imageFull, space)
            })
}

private fun DrawScope.drawRating(
    rating: Float,
    image: ImageBitmap,
    imageFull: ImageBitmap,
    space: Float
) {

    val totalCount = 5

    val imageWidth = image.width.toFloat()
    val imageHeight = size.height

    val reminder = rating - rating.toInt()
    val ratingInt = (rating - reminder).toInt()

    for (i in 0 until totalCount) {

        val start = imageWidth * i + space * i

        drawImage(
            image = image,
            topLeft = Offset(start, 0f)
        )
    }

    drawWithLayer {
        for (i in 0 until totalCount) {
            val start = imageWidth * i + space * i
            // Destination
            drawImage(
                image = imageFull,
                topLeft = Offset(start, 0f)
            )
        }

        val end = imageWidth * totalCount + space * (totalCount - 1)
        val start = rating * imageWidth + ratingInt * space
        val size = end - start

        // Source
        drawRect(
            Color.Transparent,
            topLeft = Offset(start, 0f),
            size = Size(size, height = imageHeight),
            blendMode = BlendMode.SrcIn
        )
    }
}

private fun DrawScope.drawWithLayer(block: DrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}

@Preview
@Composable
private fun ItemCardPreview() {
    ItemCard()
}