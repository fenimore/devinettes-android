/*
 * Devinettes
 *
 * Copyright (C) 2014 - 2016 Fenimore Love
 *
 * Devinettes is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * Devinettes is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Devinettes; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * Riddles are licensed under
 *     Creative Commons -
 *     Attribution-NonCommercial-NoDerivs 3.0 United States
 */
package com.workingagenda.devinettes;

import android.util.Log;

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

        Riddle r = new Riddle("The Sphinx\'s Riddle",
                "What walks on four legs in the morning,\n" +
                        "then two legs in the afternoon,\n" +
                        "and three in the evening?",
                "Sophocles",
                "d787f56b080945c1ec0b3343cbf962ca427bb8ef");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name This Pest", "See if you can name this pest:\n" +
                "A trickster of the ancient lore,\n" +
                "reminds me of a writing desk,\n"+
                "once it told me: never more\n",
                "mobia & ludos 2015",
                "0efec51fd7cf517793321ec68fd852811537b69c");
        r.setId(i);
        i++;

        riddles.add(r);
        Log.d("ID?", Integer.toString(i));
        r = new Riddle("The Cobalt Current", "I am the cobalt current\n" +
                "Safe from view. But puncture me\n" +
                "And a rubescent torrent\nWill spill all over you.",
                "mobia & ludos 2015",
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
                "Recursion here where wont was more:\nMask without a face, coin without wealth.\nNow the thing you\'re looking for\nIs nothing other than itself.",
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
                "abfde2a7fdf79a571f95f0da0de9762b6a324472");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("My Warmth Connects",
                "My warmth connects from far to wide,\nNevertheless, I too divide.\nI am the greatest of my kind;\nMy value, zero, will never rise.",
                "ludos 2013",
                "06ea4987e7621b4ff0995777aadbdd01c2fe5262");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("When There Is One",
                "When there is one, it is stood up \nWhen there are two, they\'ve both been true \nWhen there are seven, it is creation \nWhen they\'ve past, their record lasts.",
                "ludos 2013",
                "e927d0677c77241b707442314346326278051dd6");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Coat Or Crust",
                "What coat or crust is always worn\nIn winter when my hair has shed\nAnd blossom season, when I\'m warm\nAnd hair\'s again atop my head.",
                "rufus & ludos 2010",
                "cc86fbef6659b4c929f80b139294e11a5bd44269");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Where, Close At Hand",
                "My dearest vexxed, where, close at hand,\nDo suited men mean royalty,\nWhere one defector from the band\nMay forfeit all their quality?",
                "rufus & ludos 2010",
                "c8d3756e45b644ce8b817869739736d39c31e30e");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Ancient War",
                "What ancient war, played out in duels,\nThough set aside, is never won,\nDespite the fall of kings to fools\nAnd tragically neglected pun?",
                "rufus & ludos 2010",
                "8fe63c015a9b530b576c408f8e25c043967ef67b");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Found In Heaps",
                "Found in heaps of equine cuisine.\nYou poke my eye and guide me well,\nLed beneath, lest my mark be seen.\nI wound! Yet heal! None need tell.",
                "mobia & ludos 2012",
                "b65840c9c035ddad29c5a0e3f64428d4d5271c16");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without You I am Incomplete 1",
                "Without you I am incomplete\nYou, the earth´s most tasteful treasure,\nI, the opposite of sweet\nIn harmony we come together.",
                "mobia & ludos 2012",
                "b295d117135a9763da282e7dae73a5ca7d3e5b11");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without You I am Incomplete 2",
                "Without you I am incomplete\nYou dry your tears and come ashore\nYou white, I black, at last we meet\nBetter to wed than to be pure.",
                "mobia & ludos 2012",
                "64356bcfae350c970263c1ce575185b289f7b836");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What\'s The Answer",
                "What\'s the secret to this question\nWhich seems to mean so little?\nYou think you know but think again,\nThe answer is a riddle.",
                "rufus 2010",
                "ecefe3a4d0a5737a74471c289c787880772a293a");
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("This: Brought By Man",
                "This: brought by man into the world,\nThing unthinkable, yet present:\nNor God, nor Love, nor Mind unfurled,\nThe trick? The answer isn\'t.",
                "rufus 2010",
                "0feca720e2c29dafb2c900713ba560e03b758711");
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
        riddles.add(r);

        */


        return riddles;
    }
}
