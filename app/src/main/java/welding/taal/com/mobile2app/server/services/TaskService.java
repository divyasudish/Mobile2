package welding.taal.com.mobile2app.server.services;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Suneesh on 4/16/2016.
 */
public interface TaskService {
    @GET("/task")
    void getTaskList1(retrofit.Callback<String> taskCallback);
    @POST("/task1")
    void uploadTask1(@Body String objectList, Callback<String> testCallback);
}
