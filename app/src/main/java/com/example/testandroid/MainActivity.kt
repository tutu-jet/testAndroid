package com.example.testandroid

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testandroid.ui.theme.TestAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAndroidTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 5.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        ChangeIconViews(
                            activity = this@MainActivity,
                            enabledPkgName = BuildConfig.main_activity,
                            disabledPkgName = BuildConfig.main_activity_alias
                        )
                    }
                }
            }
        }
    }
}

fun Activity.changeEnabledComponent(
    enabledPkgName: String,
    disabledPkgName: String,
) {
    packageManager.setComponentEnabledSetting(
        ComponentName(this, enabledPkgName),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )

    packageManager.setComponentEnabledSetting(
        ComponentName(this, disabledPkgName),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ChangeIconViews(activity: Activity, enabledPkgName: String, disabledPkgName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val btnModifier = Modifier.padding(vertical = 2.5.dp)

        Button(modifier = btnModifier, onClick = {
            activity.changeEnabledComponent(
                enabledPkgName = enabledPkgName,
                disabledPkgName = disabledPkgName
            )
        }) {
            Text(text = "切换成Test 1")
        }
        Button(modifier = btnModifier, onClick = {
            activity.changeEnabledComponent(
                enabledPkgName = disabledPkgName,
                disabledPkgName = enabledPkgName
            )
        }) {
            Text(text = "切换成Test 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAndroidTheme {
        Greeting("Android")
    }
}

