package com.alaaeddinalbarghoth.rxandroidapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.alaaeddinalbarghoth.rxandroidapp.activities.components.ListCompose
import com.alaaeddinalbarghoth.rxandroidapp.activities.ui.theme.RxAndroidAppTheme
import com.alaaeddinalbarghoth.rxandroidapp.data.GithubClient
import com.alaaeddinalbarghoth.rxandroidapp.data.model.Repo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import logcat.LogPriority.ERROR
import logcat.logcat

class ApiActivity : ComponentActivity() {

    private val reposList: MutableState<List<Repo>> = mutableStateOf(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RxAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PopulateData()
                    ListCompose(list = reposList.value)
                }
            }
        }
    }

    @Composable
    fun PopulateData() {
        GithubClient.getGithubService().getRepos("AlaaEddinAlbarghoth")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ dataList ->
                reposList.value = dataList
            }, {
                logcat(ERROR) { it.toString() }
            })

    }
}
