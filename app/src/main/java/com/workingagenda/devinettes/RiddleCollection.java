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
import java.util.Arrays;
import java.util.List;

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
                Arrays.asList("d787f56b080945c1ec0b3343cbf962ca427bb8ef",
                        "8175e3c8753aeb1696959f72ede260ebf3ea14c5"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name This Pest", "See if you can name this pest:\n" +
                "A trickster of the ancient lore,\n" +
                "reminds me of a writing desk,\n"+
                "once it told me: never more\n",
                "mobia & ludos 2015",
                Arrays.asList("0efec51fd7cf517793321ec68fd852811537b69c",
                        "be4c02e15c23d6c45b154467d4f36a41a6646530",
                        "f8976a996ae02e728c6e09a4fbc6f414d2454b61"));
        r.setId(i);
        i++;

        riddles.add(r);
        Log.d("ID?", Integer.toString(i));
        r = new Riddle("The Cobalt Current", "I am the cobalt current\n" +
                "Safe from view. But puncture me\n" +
                "And a rubescent torrent\nWill spill all over you.",
                "mobia & ludos 2015",
                Arrays.asList("9c795e6a9969fe9d25768b50907bfd7b167c85b8",
                        "d12dec5a13f026388ecf187ff4f7bf4895a385d2",
                        "888b2beb103784c9e44b5b2c5ccbb3a486cf3ee5"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Your Heroine After Me", "Name your heroine after me\nOr count your chances, set her free.\nOr make a chain to bind her near\nMy life is short, your love is dear.",
                "mobia 2012",
                Arrays.asList("0f91787c8088296ea1439e159e4845b7b4cb5df5",
                        "e226f4619e9f378d84d918bf7020e9a8309925b1"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Me The Skin",
                "Name me the skin you cannot touch\nNor taste so long as five is five\nWhich fills the fields -- we call them such --\nWe spectate all our waking lives.",
                "rufus 2012",
                Arrays.asList("6dd0fe8001145bec4a12d0e22da711c4970d000b",
                        "f8bd696759805b9098f9e13be67d2b248c7619d0"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Recursion Here",
                "Recursion here where wont was more:\nMask without a face, coin without wealth.\nNow the thing you\'re looking for\nIs nothing other than itself.",
                "rufus 2013",
                Arrays.asList("25dc282b5a3dcba62a9a777a856c65dd8a4ae8c4",
                        "c2543fff3bfa6f144c2f06a7de6cd10c0b650cae",
                        "60c6fa6f0974eb79069d1391dbd850f3e16b265e"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Me The House",
                "Name me the house without window,\nThe oldest kind, with but one room.\nThere you\'ll find me in the shadow,\nWaiting for my soul to bloom.",
                "rufus 2013",
                Arrays.asList("a30ac4b391ead62c7ab2ea84fadf2f8ede6fbf6c",
                        "7a5243ca1c0513c2cb996ca73e24fd8d4e7110b1",
                        "5b4f00da3a8d73dcc5e8d9cdd7393f60c37c0def"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without This Common Currency",
                "Without this common currency,\nCries are quieted, food is bland,\nAll light will lose transparency\nAnd numbness stuns your hand.",
                "rufus 2013",
                Arrays.asList("abfde2a7fdf79a571f95f0da0de9762b6a324472",
                        "e9a38c050834263fce81375d8e3dcdbeec80b082",
                        "9c061901b889de27061ee5c6a8975ae89fe9be7e",
                        "c07deae4ebd966b17c07f405dd7d2f1a3d173488"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("My Warmth Connects",
                "My warmth connects from far to wide,\nNevertheless, I too divide.\nI am the greatest of my kind;\nMy value, zero, will never rise.",
                "ludos 2013",
                Arrays.asList("06ea4987e7621b4ff0995777aadbdd01c2fe5262",
                        "1e3fdd9338910dbc93082d9f7986de0b6174c967"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("When There Is One",
                "When there is one, it is stood up \nWhen there are two, they\'ve both been true \nWhen there are seven, it is creation \nWhen they\'ve past, their record lasts.",
                "ludos 2013",
                Arrays.asList("e927d0677c77241b707442314346326278051dd6",
                        "c09a2565eb3e551d0b33b3f5111b7fd0b90263f4",
                        "0aa718e58cdf44328d65263f46c9ac1e9b3ecd29"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Coat Or Crust",
                "What coat or crust is always worn\nIn winter when my hair has shed\nAnd blossom season, when I\'m warm\nAnd hair\'s again atop my head.",
                "rufus & ludos 2010",
                Arrays.asList("cc86fbef6659b4c929f80b139294e11a5bd44269"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Where, Close At Hand",
                "My dearest vexxed, where, close at hand,\nDo suited men mean royalty,\nWhere one defector from the band\nMay forfeit all their quality?",
                "rufus & ludos 2010",
                Arrays.asList("c8d3756e45b644ce8b817869739736d39c31e30e",
                        "ab493944661c2a31987bbed48fb832606458643a",
                        "7d340494ae69beb02259518e31672c2030c62013",
                        "d570d9264cd28b29774730684e3b397b1a84ee39"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Ancient War",
                "What ancient war, played out in duels,\nThough set aside, is never won,\nDespite the fall of kings to fools\nAnd tragically neglected pun?",
                "rufus & ludos 2010",
                Arrays.asList("8fe63c015a9b530b576c408f8e25c043967ef67b",
                        "945d4b2c0917033b2eb9a6efdcc00f5cd8f2b83e"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Found In Heaps",
                "Found in heaps of equine cuisine.\nYou poke my eye and guide me well,\nLed beneath, lest my mark be seen.\nI wound! Yet heal! None need tell.",
                "mobia & ludos 2012",
                Arrays.asList("b65840c9c035ddad29c5a0e3f64428d4d5271c16",
                        "3238e3410bce9e09495851d4f2171047ef584fdb"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without You I am Incomplete 1",
                "Without you I am incomplete\nYou, the earth´s most tasteful treasure,\nI, the opposite of sweet\nIn harmony we come together.",
                "mobia & ludos 2012",
                Arrays.asList("b295d117135a9763da282e7dae73a5ca7d3e5b11",
                        ""));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Without You I am Incomplete 2",
                "Without you I am incomplete\nYou dry your tears and come ashore\nYou white, I black, at last we meet\nBetter to wed than to be pure.",
                "mobia & ludos 2012",
                Arrays.asList("64356bcfae350c970263c1ce575185b289f7b836"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What\'s The Answer",
                "What\'s the secret to this question\nWhich seems to mean so little?\nYou think you know but think again,\nThe answer is a riddle.",
                "rufus 2010",
                Arrays.asList("ecefe3a4d0a5737a74471c289c787880772a293a",
                        "5239eaa08ca1903510fa4e2cf114911d479d7a1e"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("This: Brought By Man",
                "This: brought by man into the world,\nThing unthinkable, yet present:\nNor God, nor Love, nor Mind unfurled,\nThe trick? The answer isn\'t.",
                "rufus 2010",
                Arrays.asList("0feca720e2c29dafb2c900713ba560e03b758711",
                        "946348b9fe67bad3d62036cf43539b0d77a0b160"));
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
