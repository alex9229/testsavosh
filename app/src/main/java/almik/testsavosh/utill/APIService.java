package almik.testsavosh.utill;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alex on 07.12.16.
 */

public interface APIService {


    @GET("/bugReport")
    Call<bug> getBug();

}
