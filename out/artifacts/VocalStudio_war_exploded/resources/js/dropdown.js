/**
 * Created by Fairy on 5/27/2015.
 */
$(function(){
    /* ????? ?????? */
    $('.delivery_list').click(function(){
        $(".cities_list").slideToggle('fast');
    });
    $('ul.cities_list li').click(function(){
        var tx = $(this).html();
        var tv = $(this).attr('alt');
        $(".cities_list").slideUp('fast');
        $(".delivery_list span").html(tx);
        $(".delivery_text").html(tv);
    });
})