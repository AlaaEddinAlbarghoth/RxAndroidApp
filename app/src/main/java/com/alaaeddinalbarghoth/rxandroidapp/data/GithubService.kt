package com.alaaeddinalbarghoth.rxandroidapp.data

import com.alaaeddinalbarghoth.rxandroidapp.data.model.Repo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/starred")
    fun getRepos(@Path("user") username: String): Observable<ArrayList<Repo>>
}
