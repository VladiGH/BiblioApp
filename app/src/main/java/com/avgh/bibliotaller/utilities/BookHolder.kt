package com.avgh.bibliotaller.utilities

import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.entities.*

object BookHolder {

    val bookHeld = arrayOf(
        Book("978-84-08-19740-9", R.drawable.portada_yo_julia.toString(), 1),
        Book("978-84-670-5248-0", R.drawable.portada_la.toString(), 1),
        Book("978-84-08-20086-4", R.drawable.nuestro_planeta.toString(),1),
        Book("978-84-9199-089-5", R.drawable.creatividad.toString(),1),
        Book("978-84-670-5598-6", R.drawable.murmullo.toString(),1)
    )

    val contentHeld = arrayOf(
        Content(
            0, Lagunajes.Espanish, "Yo, Julia",
            "192 d.C. Varios hombres luchan por un imperio, pero Julia, hija de reyes, madre de césares y esposa de emperador, piensa en algo más ambicioso: una dinastía. Roma está bajo el control de Cómodo, un emperador loco. El Senado se conjura para terminar con el tirano y los gobernadores militares más poderosos podrían dar un golpe de Estado: Albino en Britania, Severo en el Danubio o Nigro en Siria. Cómodo retiene a sus esposas para evitar su rebelión y Julia, la mujer de Severo, se convierte así en rehén. \n De pronto, Roma arde. Un incendio asola la ciudad. ¿Es un desastre o una oportunidad? Cinco hombres se disponen a luchar a muerte por el poder. Creen que la partida está a punto de empezar. Pero para Julia la partida ya ha empezado. Sabe que solo una mujer puede forjar una dinastía.",
            "978-84-08-19740-9"
        ),
        Content(
            1, Lagunajes.English, "I, Julia",
            "192 AD Several men fight for an empire, but Julia, daughter of kings, mother of Caesars and emperor's wife, thinks of something more ambitious: a dynasty. Rome is under the control of Commodus, a mad emperor. The Senate is conspired to finish with the tyrant and the most powerful military governors could give a coup d'etat: Albino in Britain, Severo in the Danube or Nigro in Syria. Comfortable keeps his wives to avoid their rebellion and Julia, the wife of Severo, thus becomes a hostage.",
            "978-84-08-19740-9"
        ),
        Content(
            2, Lagunajes.Espanish, "La isla de la memoria",
            "Mary, la mujer del farero de la Isla de Bruny durante cuarenta años, solo quiere pasar sus últimos días en paz, lejos de un hospital. Pero la llegada de una inesperada carta trastocará todos sus planes.\n" +
                    "Con ella volverán los fantasmas del pasado, que llevarán a Mary a instalarse de nuevo en su adorada y salvaje isla. Allí, recordará y recorrerá los escenarios de su juventud, y deberá hacer frente a los secretos que tan bien había sabido ocultar. Ahora, sin nada que perder, ha llegado el momento de saldar cuentas con el pasado y dejar que la verdad salga a la luz.",
            "978-84-670-5248-0"
        ),
        Content(
            3, Lagunajes.English, "Memories island",
            "Mary, the wife of the keeper of the Isle of Bruny for forty years, just wants to spend her last days in peace, away from a hospital. But the arrival of an unexpected letter will disrupt all his plans.\n" +
                    "With it will return the ghosts of the past, which will lead Mary to settle back on their beloved and wild island. There, he will remember and travel the stages of his youth, and must face the secrets that he had so well hidden. Now, with nothing to lose, the time has come to settle accounts with the past and let the truth come to light.",
            "978-84-670-5248-0"
        ),
        Content(
            4, Lagunajes.Espanish, "Nuestro planeta",
            "Plantea un recorrido, basado en una seria investigación y unas maravillosas fotografías, a través de los ocho hábitats de la Tierra, desde los Polos y los océanos más profundos hasta los desiertos y los bosques más remotos. La intención es mostrar su papel fundamental en la preservación de la diversidad de la vida y el profundo impacto que el ser humano ha dejado en ellos.",
            "978-84-08-20086-4"
        ),
        Content(
            5, Lagunajes.English, "Our planet",
            "It presents a journey, based on serious research and wonderful photographs, through the eight habitats of the Earth, from the Poles and the deepest oceans to the deserts and the most remote forests. The intention is to show its fundamental role in preserving the diversity of life and the profound impact that the human being has left on them.",
            "978-84-08-20086-4"
        ),
        Content(
        6, Lagunajes.Espanish, "Creatividad",
            "¿Cuáles son los procesos cerebrales detrás de la creatividad humana? ¿Cuáles son sus raíces evolutivas? ¿Cómo ayuda la cultura a moldear la creatividad individual?\n" +
                    "Creatividad es el primer libro que aborda estas y otras preguntas de una manera rigurosa y atractiva: Goldberg, neurocientífico y neuropsicólogo, se basa en los últimos descubrimientos de la investigación del cerebro y en sus propios puntos de vista para unificar historia, cultura y evolución hasta llegar a una original y a veces provocativa comprensión de la naturaleza de la creatividad humana.",
            "978-84-9199-089-5"
        ),
        Content(
            7, Lagunajes.English, "Creativity",
            "What are the brain processes behind human creativity? What are their evolutionary roots? How does culture help shape individual creativity?\n" +
                    "Creativity is the first book that addresses these and other questions in a rigorous and attractive way: Goldberg, neuroscientist and neuropsychologist, is based on the latest discoveries of brain research and their own points of view to unify history, culture and evolution up to come to an original and sometimes provocative understanding of the nature of human creativity.",
            "978-84-9199-089-5"
        ),
        Content(
            8, Lagunajes.Espanish, "El murmullo de los arboles",
            "Leon siempre ha cuidado de la gente que tenía a su alrededor y de los árboles de su parque. Ahora, lejos de su isla de Bruny natal, al sur de Tasmania, el joven deberá encontrar su lugar en el mundo, hacer amigos y descubrir su objetivo en la vida. Su nueva vida entre hombres duros que se dedican a la tala de árboles no será fácil. Leon crea nuevos lazos de amistad con Max, un niño acosado por sus compañeros " +
                    "de colegio, y Miki, una chica que anhela ser libre y escapar del yugo de su hermano, que la condena a vivir recluida y sin poder moverse con libertad. Cuando los intereses de su nueva comunidad choquen con la conservación de un eucalipto milenario, Leon deberá decidir qué significa ser un buen hombre.",
            "978-84-670-5598-6"
        ),
        Content(
            9, Lagunajes.English, "The murmur of the trees",
            "Leon has always taken care of the people he had around him and the trees in his park. Now, far from his native Bruny Island, south of Tasmania, the young man must find his place in the world, make friends and discover his goal in life. His new life among hard men who are dedicated to the cutting of trees will not be easy. Leon creates new bonds of friendship with Max, a boy hounded by his schoolmates, and Miki, " +
                    "a girl who yearns to be free and escape the yoke of his brother, who condemns her to live in seclusion and unable to move freely. When the interests of his new community collide with the conservation of a millennial eucalyptus, Leon must decide what it means to be a good man.",
            "978-84-670-5598-6"
        )
    )

    val editorialHeld = arrayOf(
        Editorial(0, "Editorial Planeta", "2018", "Santiago Posteguillo"),
        Editorial(1, "Espasa", "2012", "Madrid"),
        Editorial(2, "GeoPlaneta", "2019", "Barcelona"),
        Editorial(3, "Editorial Critica", "2019", "Santiago de Chile")

    )

    val authorHeld = arrayOf(
        Author("Santiago Posteguillo", 0),
        Author("Karen Viggers", 1),
        Author("Keith Scholey",2),
        Author("Elkhonon Goldberg", 3)
    )

    val tagHeld = arrayOf(
        Tag(0, "Novela"),
        Tag(1, "histórico"),
        Tag(2, "Antigua Roma"),
        Tag(3, "Narrativa en femenino"),
        Tag(4,"Ciencia"),
        Tag(5, "Ecologia"),
        Tag(6,"Cerebro"),
        Tag(7, "Mente"),
        Tag(8, "Contemporanea")
    )


}