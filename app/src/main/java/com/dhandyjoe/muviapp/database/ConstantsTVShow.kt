package com.dhandyjoe.muviapp.database

import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.model.ModelFilm

object ConstantsTVShow {

    fun getTVShowList(): ArrayList<ModelFilm> {
        val tvShowList = ArrayList<ModelFilm>()

        val t1 = ModelFilm(
            21,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "Crime, Drama",
            R.drawable.poster_arrow,
            "10 Oktober 2012",
            2F,
            false,
        )

        val t2 = ModelFilm(
            22,
            "Doom Patrol",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "Sci-Fi, Fantasy",
            R.drawable.poster_doom_patrol,
            "15 Februari 2019",
            3.5F,
            false,
        )

        val t3 = ModelFilm(
            23,
            "Dragon Ball",
            "The series begins twelve years after Goku is seen leaving on Shenron not at the end of Dragon Ball GT, and diverges entirely into its own plot from there, on an alternate timeline from the one which shows Goku Jr. fighting Vegeta Jr. at the World Martial Arts Tournament. In this series, Majuub has reached new levels of power, and has honed the techniques taught to him by Goku. We also see Gotenks finally mature, and Vegeta more powerful than ever.Each character will bring forth their own set of capabilities and purpose, winning fights and being relevant, in order to create an environment that emphasizes teamwork as well as individual worth for each character. ",
            "Action",
            R.drawable.poster_dragon_ball,
            "30 November 2012",
            5F,
            false,
        )

        val t4 = ModelFilm(
            24,
            "Fairy Tail",
            "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
            "Action, Adventure",
            R.drawable.poster_fairytail,
            "6 Mei 2017",
            4.5F,
            false,
        )

        val t5 = ModelFilm(
            25,
            "Family Guy",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "Animation, Comedy",
            R.drawable.poster_family_guy,
            "31 Januari 1999",
            3F,
            false,
        )

        val t6 = ModelFilm(
            26,
            "Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "Drama, Sci-Fi",
            R.drawable.poster_flash,
            "7 Oktober 2014",
            5F,
            false,
        )

        val t7 = ModelFilm(
            27,
            "Game of Thrones",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "Sci-Fi, Fantasy",
            R.drawable.poster_god,
            "17 April 2011",
            4.5F,
            false,
        )

        val t8 = ModelFilm(
            28,
            "Gotham",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "Drama, Crime",
            R.drawable.poster_gotham,
            "22 September 2014",
            3F,
            false,
        )

        val t9 = ModelFilm(
            29,
            "Grey Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "Drama",
            R.drawable.poster_grey_anatomy,
            "27 Maret 2005",
            2.5F,
            false,
        )

        val t10 = ModelFilm(
            210,
            "Hanna",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "Action",
            R.drawable.poster_hanna,
            "28 Maret 2019",
            4.5F,
            false,
        )

        tvShowList.add(t1)
        tvShowList.add(t2)
        tvShowList.add(t3)
        tvShowList.add(t4)
        tvShowList.add(t5)
        tvShowList.add(t6)
        tvShowList.add(t7)
        tvShowList.add(t8)
        tvShowList.add(t9)
        tvShowList.add(t10)
        return tvShowList
    }

}