package com.Fairy.VocalsStudio.models;

/**
 * Created by Fairy on 6/8/2015.
 */
public class LessonRequestBuilder {
    private LessonRequest lr;

    public LessonRequestBuilder (){
        lr = new LessonRequest();
    }

    public LessonRequest build(){
        return lr;
    }

    public void refresh(){
        lr = new LessonRequest();
    }

    public LessonRequestBuilder setIdLessonRequest(int id){
        lr.setId(id);
        return this;
    };

    public LessonRequestBuilder setLrIdUser(User user){
        lr.setLrUser(user);
        return this;
    }

    public LessonRequestBuilder setLrIdUser(int idUser){
        User user = new User();
        user.setIdUser(idUser);
        lr.setLrUser(user);
        return this;
    }

    public LessonRequestBuilder setDate(String date){
        lr.setDate(date);
        return this;
    }

    public LessonRequestBuilder setTime(String time){
        lr.setTime(time);
        return this;
    }

    public LessonRequestBuilder setStatus(String stutus){
        lr.setStatus(stutus);
        return this;
    }

    public LessonRequestBuilder setType(String type){
        lr.setType(type);
        return this;
    }
}
