package com.example.thephoenix.util;

import com.example.thephoenix.PostResponse;
import com.example.thephoenix.model.LearnerHours;
import com.example.thephoenix.model.LearnerIQ;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {
    @GET("/api/skilliq")
    Call<List<LearnerIQ>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<LearnerHours>> getTopHoursLearners();

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<PostResponse> savePost(@FieldMap Map<String,String> params);
}
