package com.workingagenda.devinettes;

import java.util.ArrayList;

/**
 * Created by fen on 8/10/16.
 */
public class RiddleCollection {


    public static ArrayList<Riddle> Collect() {
        ArrayList<Riddle> riddles = new ArrayList<>(20);

        // Increment automatically the id
        // So that I can change around order no prob
        int i = 0;

        Riddle r = new Riddle("Name this pest", "See if you can name this pest:\n" +
                "A trickster of the ancient lore,\n" +
                "reminds me of a writing desk,\n"+
                "once it told me: never more\n",
                "mobia &amp; ludos 2015",
                "0efec51fd7cf517793321ec68fd852811537b69c");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("The Cobalt Current", "I am the cobalt current\n" +
                "Safe from view. But puncture me\n" +
                "And a rubescent torrent\nWill spill all over you.",
                "mobia &amp; ludos 2015",
                "9c795e6a9969fe9d25768b50907bfd7b167c85b8");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Your Heroine After Me", "Name your heroine after me\nOr count your chances, set her free.\nOr make a chain to bind her near\nMy life is short, your love is dear.",
                "mobia 2012",
                "0f91787c8088296ea1439e159e4845b7b4cb5df5");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Me The Skin",
                "Name me the skin you cannot touch\nNor taste so long as five is five\nWhich fills the fields -- we call them such --\nWe spectate all our waking lives.",
                "rufus 2012",
                "6dd0fe8001145bec4a12d0e22da711c4970d000b");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Recursion Here",
                "Recursion here where wont was more:\nMask without a face, coin without wealth.\nNow the think you\'re looking for\nIs nothing other than itself.",
                "rufus 2013",
                "25dc282b5a3dcba62a9a777a856c65dd8a4ae8c4");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Me The House",
                "Name me the house without window,\nThe oldest kind, with but one room.\nThere you\'ll find me in the shadow,\nWaiting for my soul to bloom.",
                "rufus 2013",
                "a30ac4b391ead62c7ab2ea84fadf2f8ede6fbf6c");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without This Common Currency",
                "Without this common currency,\nCries are quieted, food is bland,\nAll light will lose transparency\nAnd numbness stuns your hand.",
                "rufus 2013",
                "e9a38c050834263fce81375d8e3dcdbeec80b082");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("My Warmth Connects",
                "When there is one, it is stood up \nWhen there are two, they\'ve both been true \nWhen there are seven, it is creation \nWhen they\'ve past, their record lasts.",
                "ludos 2013",
                "c09a2565eb3e551d0b33b3f5111b7fd0b90263f4");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Coat Or Crust",
                "What coat or crust is always worn\nIn winter when my hair has shed\nAnd blossom season, when I\'m warm\nAnd hair\'s again atop my head.",
                "rufus &amp; ludos 2010",
                "06ea4987e7621b4ff0995777aadbdd01c2fe5262");
        r.setId(i);
        i++;
        riddles.add(r);


        /*
        r = new Riddle("",
                "",
                "",
                "");
        r.setId(i);
        i++;
        riddles.add(r);*/


        return riddles;
    }
}
