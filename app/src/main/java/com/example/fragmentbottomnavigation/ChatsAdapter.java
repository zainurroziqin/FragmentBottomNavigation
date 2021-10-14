package com.example.fragmentbottomnavigation;
import java.util.ArrayList;
public class ChatsAdapter {
    private static String[] namaPengirim = {
      "Dimas",
      "Risky",
      "Mullah",
      "Bahrul",
      "Arep",
      "Azril",
      "Sofyan",
      "Danis",
      "Ramzi",
      "Reyhan"
    };

    private static String[] isiPesan ={
      "Ada apa Kawan?",
      "Kamu ada dimana?",
      "Hei Kawan",
      "Assalamuaaikum",
      "Baik terima kasih",
      "Yoi!",
      "Sekarang kah?",
      "Join dc?",
      "Valorant ga si?",
      "Login?"
    };

    public static int[] imagesPengirim={
            R.drawable.dimas,
            R.drawable.risky,
            R.drawable.mullah,
            R.drawable.bahrul,
            R.drawable.arep,
            R.drawable.azril,
            R.drawable.sofyan,
            R.drawable.danis,
            R.drawable.ramzi,
            R.drawable.reyhan
    };

    public static String[]waktuPesan={
            "10:52",
            "12:24",
            "15:00",
            "15:13",
            "15:45",
            "16:02",
            "16:09",
            "16:25",
            "16:50",
            "17:00"
    };

    static ArrayList<Chats> getListData(){
        ArrayList<Chats> list = new ArrayList<>();
        for (int position = 0; position< namaPengirim.length; position++){
            Chats chat = new Chats();
            chat.setName(namaPengirim[position]);
            chat.setDetail(isiPesan[position]);
            chat.setPhoto(imagesPengirim[position]);
            chat.setWaktu(waktuPesan[position]);
            list.add(chat);
        }
        return list;
    }
}
