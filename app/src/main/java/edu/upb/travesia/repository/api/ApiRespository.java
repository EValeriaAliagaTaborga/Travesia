package edu.upb.travesia.repository.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.Country;
import edu.upb.travesia.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRespository {

    private CountriesAPI countriesAPI;
    private static ApiRespository instance;

    public static ApiRespository getInstance(){
        if(instance == null) {
            instance = new ApiRespository();
        }
        return instance;
    }

    private ApiRespository(){
        countriesAPI = ApiService.createService(CountriesAPI.class);
    }

    public LiveData<Base> getCountries() {
        final MutableLiveData<Base> results = new MutableLiveData<>();

        countriesAPI.getCountries(Constants.API_PARAM_ALT)
                .enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        if (response.isSuccessful()) {
                            results.postValue(new Base(response.body()));
                        } else {
                            results.postValue(new Base(response.message(), new NullPointerException()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {
                        results.postValue(new Base("onFailure", new Exception(t)));
                    }
                });

        return results;
    }

}
