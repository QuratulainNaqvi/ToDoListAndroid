package com.pakitech.todolistandroid

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pakitech.todolistandroid.ui.theme.ToDoListAndroidTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LayoutDesign()
                }

            }
        }
    }
}

@Composable
fun LayoutDesign() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        BoldMainTitle()
        DisplayTaskRadioGroup()
    }
}

@Composable
fun BoldMainTitle() {
    Column(
        Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.all_task),
            color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 30.dp, 0.dp, 10.dp)
        )
        Text(
            text = stringResource(id = R.string.today_tasks),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp, 30.dp, 0.dp),
            fontSize = 18.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayTaskRadioGroup() {
    val selectedValue = remember { mutableStateOf("") }
    val isSelectedItem: (String) -> Boolean = {selectedValue.value == it}
    val onChangeState : (String) -> Unit = {selectedValue.value = it}
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            Modifier
                .fillMaxWidth()
        ) {
            Row(
                Modifier
                    .fillMaxWidth().padding(10.dp,10.dp,0.dp,0.dp)
            ) {
                RadioButton(selected = true, onClick = { /*TODO*/ })
                Text(
                    text = stringResource(id = R.string.task1),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(0.dp, 10.dp, 30.dp, 0.dp),
                    fontSize = 16.sp
                )
            }
            Row(
                Modifier
                    .fillMaxWidth().padding(10.dp,0.dp,0.dp,0.dp)
            ) {
                RadioButton(selected = false, onClick = { })
                Text(
                    text = stringResource(id = R.string.task2),
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp, 30.dp, 0.dp),
                    fontSize = 16.sp
                )
            }
            Row(
                Modifier
                    .fillMaxWidth().padding(10.dp,0.dp,0.dp,0.dp)
            ) {
                RadioButton(selected = false, onClick = {  })
                Text(
                    text = stringResource(id = R.string.task3),
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp, 30.dp, 0.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoListAndroidTheme {
        LayoutDesign()
    }
}