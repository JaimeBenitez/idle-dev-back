package com.example.idleback.servicios;

import org.springframework.stereotype.Service;

@Service
public class TrabajadoresServices {

    public String getWorkerAvatar(char sexo){
        String base_url = "http://localhost:8080/workers-avatars/";


        String[] maleAvatars =  new String[]{base_url + "man1.svg", base_url + "man2.svg", base_url + "man3.svg", base_url + "man4.svg", base_url + "man5.svg",base_url + "man6.svg",base_url + "man7.svg",base_url + "man8.svg",base_url + "man9.svg",base_url + "man10.svg",base_url + "man11.svg",base_url + "man12.svg",base_url + "man13.svg",base_url + "man14.svg",base_url + "man15.svg",base_url + "man16.svg",base_url + "man17.svg",base_url + "man18.svg"};
        String[] femaleAvatars = new String[]{base_url + "woman1.svg", base_url + "woman2.svg", base_url + "woman3.svg", base_url + "woman4.svg", base_url + "woman5.svg",base_url + "woman6.svg",base_url + "woman7.svg",base_url + "woman8.svg",base_url + "woman9.svg",base_url + "woman10.svg",base_url + "woman11.svg",base_url + "woman12.svg"};
        int randMen =  (int)Math.floor(Math.random()*maleAvatars.length);
        int randWomen = (int)Math.floor(Math.random()*femaleAvatars.length);
        if(sexo == 'M'){
            return maleAvatars[randMen];
        }else{
            return femaleAvatars[randWomen];
        }
    }

}
