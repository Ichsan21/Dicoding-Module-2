package com.rizky92.madedicodingsubmission1;

import java.util.ArrayList;

public class Data {

    private static String title[] = {
            "Fast & Furious Presents: Hobbs & Shaw",
            "Spider-Man: Far from Home",
            "Zombieland: Double Tap",
            "Charlie's Angels",
            "Frozen II",
            "Ford v Ferrari",
            "Jumanji: The Next Level",
            "Star Wars: Episode IX - The Rise of Skywalker",
            "Avengers: Endgame",
            "Toy Story 4",
            "Terminator: Dark Fate",
            "Captain Marvel",
            "Gemini Man",
            "Dora and the Lost City of Gold",
            "John Wick: Chapter 3 - Parabellum",
            "Pokémon Detective Pikachu",
            "Alita: Battle Angel"
    };

    private static String desc[] = {
            "Lawman Luke Hobbs and outcast Deckard Shaw form an unlikely alliance when a cyber-genetically enhanced villain threatens the future of humanity.",
            "Following the events of Avengers: Endgame (2019), Spider-Man must step up to take on new threats in a world that has changed forever.",
            "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.",
            "When a young systems engineer blows the whistle on a dangerous technology, Charlie's Angels are called into action, putting their lives on the line to protect us all.",
            "Anna, Elsa, Kristoff, Olaf and Sven leave Arendelle to travel to an ancient, autumn-bound forest of an enchanted land. They set out to find the origin of Elsa's powers in order to save their kingdom.",
            "American car designer Carroll Shelby and driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary race car for Ford and challenge Ferrari at the 24 Hours of Le Mans in 1966.",
            "In Jumanji: The Next Level, the gang is back but the game has changed. As they return to rescue one of their own, the players will have to brave parts unknown from arid deserts to snowy mountains, to escape the world's most dangerous game.",
            "The surviving Resistance faces the First Order once more in the final chapter of the Skywalker saga.",
            "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
            "When a new toy called 'Forky' joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.",
            "An augmented human and Sarah Connor must stop an advanced liquid Terminator, from hunting down a young girl, who's fate is critical to the human race.",
            "Carol Danvers becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien races.",
            "An over-the-hill hitman faces off against a younger clone of himself.",
            "Dora, a teenage explorer, leads her friends on an adventure to save her parents and solve the mystery behind a lost city of gold.",
            "John Wick is on the run after killing a member of the international assassin's guild, and with a $14 million price tag on his head, he is the target of hit men and women everywhere.",
            "In a world where people collect Pokémon to do battle, a boy comes across an intelligent talking Pikachu who seeks to be a detective.",
            "A deactivated cyborg is revived, but cannot remember anything of her past life and goes on a quest to find out who she is."
    };

    private static String rating[] = {
            "6.5/10",
            "7.6/10",
            "7.2/10",
            "3.9/10",
            "7.3/10",
            "8.3/10",
            "Not yet rated",
            "Not yet rated",
            "8.5/10",
            "7.9/10",
            "6.5/10",
            "6.9/10",
            "5.7/10",
            "6.0/10",
            "7.6/10",
            "6.7/10",
            "7.4/10"
    };

    private static String date[] = {
            "2 August 2019",
            "2 July 2019",
            "18 October 2019",
            "15 November 2019",
            "22 November 2019",
            "15 November 2019",
            "13 December 2019",
            "18 December 2019",
            "26 April 2019",
            "21 June 2019",
            "1 November 2019",
            "8 March 2019",
            "11 October 2019",
            "9 August 2019",
            "17 May 2019",
            "10 May 2019",
            "14 February 2019",
    };

    private static String length[] = {
            "2h 17m",
            "2h 9m",
            "1h 39m",
            "1h 58m",
            "1h 43m",
            "2h 32m",
            "1h 54m",
            "2h 35m",
            "3h 1m",
            "1h 40m",
            "2h 8m",
            "2h 3m",
            "1h 57m",
            "1h 42m",
            "2h 11m",
            "1h 44m",
            "2h 2m"
    };

    private static String url[] = {
            "https://www.youtube.com/watch?v=9SA7FaKxZVI",
            "https://www.youtube.com/watch?v=Nt9L1jCKGnE",
            "https://www.youtube.com/watch?v=ZlW9yhUKlkQ",
            "https://www.youtube.com/watch?v=RSUq4VfWfjE",
            "https://www.youtube.com/watch?v=Zi4LMpSDccc",
            "https://www.youtube.com/watch?v=zyYgDtY2AMY",
            "https://www.youtube.com/watch?v=rBxcF-r9Ibs",
            "https://www.youtube.com/watch?v=8Qn_spdM5Zg",
            "https://www.youtube.com/watch?v=TcMBFSGVi1c",
            "https://www.youtube.com/watch?v=wmiIUN-7qhE",
            "https://www.youtube.com/watch?v=oxy8udgWRmo",
            "https://www.youtube.com/watch?v=Z1BCujX3pw8",
            "https://www.youtube.com/watch?v=AbyJignbSj0",
            "https://www.youtube.com/watch?v=gUTtJjV852c",
            "https://www.youtube.com/watch?v=pU8-7BX9uxs",
            "https://www.youtube.com/watch?v=1roy4o4tqQM",
            "https://www.youtube.com/watch?v=w7pYhpJaJW8"
    };

    private static int foto[] = {
            R.drawable.hobbs_and_shaw,
            R.drawable.spiderman_far_from_home,
            R.drawable.zombieland_double_tap,
            R.drawable.charlies_angels,
            R.drawable.frozen_2,
            R.drawable.ford_v_ferrari,
            R.drawable.jumanji_the_next_level,
            R.drawable.star_wars_the_rise_of_skywalker,
            R.drawable.avengers_endgame,
            R.drawable.toy_story_4,
            R.drawable.terminator_dark_fate,
            R.drawable.captain_marvel,
            R.drawable.gemini_man,
            R.drawable.dora_and_the_lost_city_of_gold,
            R.drawable.john_wick_3,
            R.drawable.detective_pikachu,
            R.drawable.alita_battle_angel
    };

    public static ArrayList<Movies> getListData() {
        ArrayList<Movies> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Movies movies = new Movies();

            movies.setTitle(title[i]);
            movies.setDesc(desc[i]);
            movies.setDate(date[i]);
            movies.setLength(length[i]);
            movies.setRating(rating[i]);
            movies.setUrl(url[i]);
            movies.setFoto(foto[i]);

            list.add(movies);
        }
        return list;
    }
}
