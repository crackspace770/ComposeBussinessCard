package com.fajar.composebussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajar.composebussinesscard.ui.theme.ComposeBussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeCard()
                    ComposeContact()
                }
            }
        }
    }
}



@Composable
fun ComposeCard(){
    BussinessCard(
        name = stringResource(R.string.full_name),
        title = stringResource(R.string.job_title),

    )
}

@Composable
fun ComposeContact(){
    Contact(
        phone = stringResource(R.string.phone),
        social = stringResource(R.string.social),
        email = stringResource(R.string.email)
    )
}


@Composable
fun BussinessCard(name:String,
                  title:String,
                   )
{

    val imagePainter = painterResource(R.drawable.ic_baseline_account_circle_24)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = imagePainter,
            contentDescription = null,
            modifier = Modifier,
            contentScale = ContentScale.Crop)


        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Text(
            text = title,
            fontSize = 20.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

    }

}

@Composable
fun Contact(
    phone:String,
    social: String,
    email: String)
{

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ) {

        Text(
            text = phone,
            fontSize = 20.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Text(
            text = social,
            fontSize = 20.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
        )


        Text(
            text = email,
            fontSize = 20.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
        )


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBussinessCardTheme {
        ComposeCard()
        ComposeContact()
    }
}