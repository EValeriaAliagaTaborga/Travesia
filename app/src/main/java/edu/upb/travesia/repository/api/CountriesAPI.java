package edu.upb.travesia.repository.api;

import java.util.List;

import edu.upb.travesia.models.repository.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountriesAPI {
    @GET("api%2Fcountries.json")
    Call<List<Country>> getCountries(@Query("alt") String alt);

}
