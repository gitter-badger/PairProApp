package net.zaim.pairproapp;

import net.zaim.pairproapp.model.Account;
import net.zaim.pairproapp.model.Category;
import net.zaim.pairproapp.model.Genre;
import net.zaim.pairproapp.model.User;

import retrofit.Callback;
import retrofit.http.GET;

public interface ZaimEndpointInterface {

    @GET("/home/user/verify")
    void getUser(Callback<User> callback);

    @GET("/home/category")
    void getCategory(Callback<Category> callback);

    @GET("/home/genre")
    void getGenre(Callback<Genre> callback);

    @GET("/home/account")
    void getAccount(Callback<Account> callback);
}
