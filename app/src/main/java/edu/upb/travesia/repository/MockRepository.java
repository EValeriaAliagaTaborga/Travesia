package edu.upb.travesia.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.Country;
import edu.upb.travesia.models.repository.User;

public class MockRepository implements RepositoryImpl {

    private static MockRepository instance;

    public static MockRepository getInstance() {
        if (instance == null) {
            instance = new MockRepository();
        }
        return instance;
    }


    @Override
    public LiveData<Base> login(String email, String password) {
        return null;
    }

    @Override
    public LiveData<Base> getCountries() {
        String json = "[{\"uuid\":\"BO\",\"name\":\"Bolivia\",\"flag\":\"bolivia\",\"cities\":[{\"uuid\":\"BOLP\",\"name\":\"La Paz\",\"tours\":[{\"uuid\":\"tour-001\",\"name\":\"Electropreste\",\"price\":300,\"picture\":\"electropreste\"},{\"uuid\":\"tour-002\",\"name\":\"cable\",\"price\":50,\"picture\":\"cable_car\"}]},{\"uuid\":\"BOSC\",\"name\":\"Santa Cruz\",\"tours\":[{\"uuid\":\"tour-003\",\"name\":\"Casa del Camba Lunch\",\"price\":200,\"picture\":\"casa_del_camba\"}]},{\"uuid\":\"BOCBBA\",\"name\":\"Cochabamba\",\"tours\":[{\"uuid\":\"tour-004\",\"name\":\"Chicharron with my Abuela\",\"price\":70,\"picture\":\"chicharron\"}]},{\"uuid\":\"BOSRE\",\"name\":\"Sucre\",\"tours\":[{\"uuid\":\"tour-005\",\"name\":\"Para Ti Chocolate Factory Tour\",\"price\":20,\"picture\":\"chocolate_parati\"}]},{\"uuid\":\"BOTJA\",\"name\":\"Tarija\",\"tours\":[{\"uuid\":\"tour-006\",\"name\":\"Wine Route Tour\",\"price\":150,\"picture\":\"wine_tour\"}]},{\"uuid\":\"BOOR\",\"name\":\"Oruro\",\"tours\":[{\"uuid\":\"tour-007\",\"name\":\"Carnival Seats\",\"price\":700,\"picture\":\"carnival_oruro\"}]},{\"uuid\":\"BOPO\",\"name\":\"Potosi\",\"tours\":[{\"uuid\":\"tour-008\",\"name\":\"Casa de la Moneda\",\"price\":30,\"picture\":\"casa_moneda\"}]},{\"uuid\":\"BOBENI\",\"name\":\"Beni\",\"tours\":[{\"uuid\":\"tour-009\",\"name\":\"Boat Ride in the River\",\"price\":10,\"picture\":\"beni_river\"}]},{\"uuid\":\"BOPND\",\"name\":\"Pando\"}]},{\"uuid\":\"KO\",\"name\":\"South Korea\",\"flag\":\"korea_south\",\"cities\":[{\"uuid\":\"KOSEO\",\"name\":\"Seoul\",\"tours\":[{\"uuid\":\"tour-010\",\"name\":\"LOTTE Mall and Kakao Store\",\"price\":100,\"picture\":\"default_image\"}]},{\"uuid\":\"KOBUS\",\"name\":\"Busan\",\"tours\":[{\"uuid\":\"tour-011\",\"name\":\"Busan Tower\",\"price\":50,\"picture\":\"default_image\"}]},{\"uuid\":\"KOINC\",\"name\":\"Incheon\",\"tours\":[{\"uuid\":\"tour-012\",\"name\":\"Duty Free Mall\",\"price\":200,\"picture\":\"default_image\"}]},{\"uuid\":\"KODAE\",\"name\":\"Daejeon\",\"tours\":[{\"uuid\":\"tour-013\",\"name\":\"Ice Skating Rink\",\"price\":250,\"picture\":\"default_image\"}]},{\"uuid\":\"KODAG\",\"name\":\"Daegu\",\"tours\":[{\"uuid\":\"tour-014\",\"name\":\"Cat Cafe\",\"price\":40,\"picture\":\"default_image\"}]},{\"uuid\":\"KOGWA\",\"name\":\"Gwangju\",\"tours\":[{\"uuid\":\"tour-015\",\"name\":\"Korean Barbecue Time\",\"price\":400,\"picture\":\"default_image\"}]},{\"uuid\":\"KOULS\",\"name\":\"Ulsan\",\"tours\":[{\"uuid\":\"tour-016\",\"name\":\"Hyundai Automotors Factory Tour\",\"price\":0,\"picture\":\"default_image\"}]}]},{\"uuid\":\"FR\",\"name\":\"France\",\"flag\":\"france\",\"cities\":[{\"uuid\":\"FRPAR\",\"name\":\"Paris\",\"tours\":[{\"uuid\":\"tour-017\",\"name\":\"Eiffel Tower\",\"price\":200,\"picture\":\"default_image\"}]},{\"uuid\":\"FRLYO\",\"name\":\"Lyon\",\"tours\":[{\"uuid\":\"tour-018\",\"name\":\"Traditional Macarons Cooking Class\",\"price\":150,\"picture\":\"default_image\"}]},{\"uuid\":\"FRMAR\",\"name\":\"Marseille\",\"tours\":[{\"uuid\":\"tour-019\",\"name\":\"Island Fortress and Prison Tour\",\"price\":110,\"picture\":\"default_image\"}]},{\"uuid\":\"FRTOU\",\"name\":\"Toulouse\",\"tours\":[{\"uuid\":\"tour-020\",\"name\":\"Dog Cafe\",\"price\":30,\"picture\":\"default_image\"}]},{\"uuid\":\"FRNI\",\"name\":\"Nice\",\"tours\":[{\"uuid\":\"tour-021\",\"name\":\"Bakery Tour\",\"price\":20,\"picture\":\"default_image\"}]},{\"uuid\":\"FRNAN\",\"name\":\"Nantes\",\"tours\":[{\"uuid\":\"tour-022\",\"name\":\"Universities Tour\",\"price\":60,\"picture\":\"default_image\"}]},{\"uuid\":\"FRSTR\",\"name\":\"Strasbourg\",\"tours\":[{\"uuid\":\"tour-023\",\"name\":\"Dating Game with other Tourists\",\"price\":15,\"picture\":\"default_image\"}]},{\"uuid\":\"FRMO\",\"name\":\"Montpellier\",\"tours\":[{\"uuid\":\"tour-024\",\"name\":\"Party\",\"price\":100,\"picture\":\"default_image\"}]}]}]";
        MutableLiveData<Base> result = new MutableLiveData<>();
        try {
            List<Country> countries = new Gson().fromJson(json, new TypeToken<List<Country>>() {}.getType());
            //List<Country> countries = new Gson().fromJson(json, ArrayList.class);
            Log.e("MockRep - Countries",countries.toString());
            result.postValue(new Base(countries));
        } catch (Exception ex) {
            Log.e("MockRep - Countries","Error! algo de get types fallido");
        }
        return result;
    }

    @Override
    public LiveData<Base> getCountryDetails(String uuid) {
        return null;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public LiveData<List<User>> getAll() {
        return null;
    }

    @Override
    public LiveData<Base> register(String email, String password) {
        return null;
    }
}
