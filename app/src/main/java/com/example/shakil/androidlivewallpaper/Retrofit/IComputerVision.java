package com.example.shakil.androidlivewallpaper.Retrofit;

import com.example.shakil.androidlivewallpaper.Model.AnalyzeModel.ComputerVision;
import com.example.shakil.androidlivewallpaper.Model.AnalyzeModel.URLUpload;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Shakil on 3/21/2018.
 */

public interface IComputerVision {
    @Headers({
            "Content-Type:application/json",
            "Ocp-Apim-Subscription-Key:a99edef471044c59bdbd5e1142dd186d"
    })
    @POST
    Call<ComputerVision> analyzeImage(@Url String apiEndPoint, @Body URLUpload url);
}
