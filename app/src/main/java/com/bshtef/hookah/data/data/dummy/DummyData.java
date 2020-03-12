package com.bshtef.hookah.data.data.dummy;

import com.bshtef.hookah.data.model.Hookah;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DummyData {


    public static List<Hookah> getDummyHookahs(){

        List<String> hookahsNames = new ArrayList<>();
        hookahsNames.add("MYA");
        hookahsNames.add("Euroshisha");
        hookahsNames.add("Soft Smoke");
        hookahsNames.add("Standart LP");
        hookahsNames.add("Cosmo Bowl");
        hookahsNames.add("Khalil Mamoon");
        hookahsNames.add("Meduse Design");
        hookahsNames.add("Hoob Apex-4 StandartС");
        hookahsNames.add("AMY Deluxe");
        hookahsNames.add("Fabula Temple");

        List<String> hookahsImageUrls = new ArrayList<>();
        hookahsImageUrls.add("https://s.057.ua/section/promonewsintext/upload/images/promo/intext/000/050/753/f34970ad4474ee8d78edc62ae7f3ad21_5cd95fdcf3eaa.jpg");
        hookahsImageUrls.add("https://s.0552.ua/section/promonewsintext/upload/images/promo/intext/000/032/007/kaljan-1_5acc6242befff.jpg");
        hookahsImageUrls.add("https://artma-catering.kiev.ua/wp-content/uploads/2017/07/%D0%BA%D0%B0%D0%BB%D1%8C%D1%8F%D0%BD-%D0%BD%D0%B0-%D0%BA%D0%BE%D1%80%D0%BF%D0%BE%D1%80%D0%B0%D1%82%D0%B8%D0%B2-min.jpg");
        hookahsImageUrls.add("https://i1.poltava.to/uploads/2016/11/2016-11-03/hookah.jpg");
        hookahsImageUrls.add("https://st4.depositphotos.com/24664374/28220/i/450/depositphotos_282207076-stock-photo-hookahs-hookahs-for-smoking-accessories.jpg");
        hookahsImageUrls.add("https://s.057.ua/section/promonewsintext/upload/images/promo/intext/000/051/011/kalyan_5d31d2aec9318.jpg");
        hookahsImageUrls.add("https://mirk.com.ua/image/catalog/Blog/hookah/119-65286-1acd4d08f7e94765912431ec5e498193.jpg");
        hookahsImageUrls.add("https://hookah-lovers.com.ua/image/data/benefit/D3Ahv-tP4GzOhD3WuVcDT3_h7bYMUZR1peai_Y1OSDBU9PiAi0JQ-2zWRow0hoC0i-9FX-aYfCE=.jpg");
        hookahsImageUrls.add("https://lh3.googleusercontent.com/proxy/1M34Fe7d75BTJ9CV5IB8Xdw4h9nFjjSmYxV1c_BqmwsP_yaKfCNclkM01KNgBlOWdQU06lPTNE0wNVLpxjGVPQ");
        hookahsImageUrls.add("https://st3.depositphotos.com/11481516/19019/i/450/depositphotos_190194714-stock-photo-group-of-red-hookahs-shisha.jpg");


        List<Hookah> hookahs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Hookah hookah = new Hookah();
            hookah.setId(UUID.randomUUID().toString());
            hookah.setName(hookahsNames.get(i));
            hookah.setImageUrl(hookahsImageUrls.get(i));
            hookah.setPrice(350);
            hookah.setDescription("Мундштук из алюминия, плоское блюдце, Регулятор жара в стандартном комплекте! " +
                "Кальяны Smokah это уникальные кальяны, они изготовлены из высококачественной материалов, обладают непревзойдёнными " +
                "характеристиками и уникальным дизайном. Нержавеющая сталь, использованная при производстве кальянов Smokah не " +
                "подвержена коррозии, окислению и имеет высокую устойчивость от физических воздействий. Дизайн шахты каждого " +
                "кальяна серии Smokah уникален, не исключение и Smokah History 2.0. "
            );
            hookahs.add(hookah);
        }

        return hookahs;
    }

}
