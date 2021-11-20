package com.dhandyjoe.muviapp.database

import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.model.ModelFilm

object ConstantsMovie {

    fun getMovieList() : ArrayList<ModelFilm> {
        val movieList = ArrayList<ModelFilm>()

        val m1 = ModelFilm(
            11,
            "A Star is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "Drama, Romance, Music",
            R.drawable.movie_a_start_is_born,
            "3 October 2018",
            4F,
            true,
        )

        val m2 = ModelFilm(
            12,
            "Alita",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "Action, Science",
            R.drawable.movie_alita,
            "31 Januari 2019",
            4.5F,
            true,
        )

        val m3 = ModelFilm(
            13,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "Action, Adventure",
            R.drawable.movie_aquaman,
            "6 Juli 2018",
            2.5F,
            true,
        )

        val m4 = ModelFilm(
            14,
            "Bohemian",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "Drama, Music",
            R.drawable.movie_bohemian,
            "4 Desember 2018",
            3F,
            true,
        )

        val m5 = ModelFilm(
            15,
            "Cold Persuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.ad",
            "Action, Crime",
            R.drawable.movie_cold_persuit,
            "7 Februari 2019",
            3.5F,
            true,
        )

        val m6 = ModelFilm(
            16,
            "Creed",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "Drama",
            R.drawable.movie_creed,
            "25 November 2015",
            4F,
            true,
        )

        val m7 = ModelFilm(
            17,
            "Crimes",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "Adventure, Fantasy, Drama",
            R.drawable.movie_crimes,
            "14 November 2018",
            3F,
            true,
        )

        val m8 = ModelFilm(
            18,
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "Thriller, Drama",
            R.drawable.movie_glass,
            "16 Januari 2019",
            3F,
            true,
        )

        val m9 = ModelFilm(
            19,
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
            "Fantasy, Adventure",
            R.drawable.movie_how_to_train,
            "10 Maret 2010",
            4.5F,
            true,
        )

        val m10 = ModelFilm(
            110,
            "Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "Adventure, Action",
            R.drawable.movie_infinity_war,
            "25 April 2018",
            5F,
            true,
        )

        movieList.add(m1)
        movieList.add(m2)
        movieList.add(m3)
        movieList.add(m4)
        movieList.add(m5)
        movieList.add(m6)
        movieList.add(m7)
        movieList.add(m8)
        movieList.add(m9)
        movieList.add(m10)
        return movieList
    }

}