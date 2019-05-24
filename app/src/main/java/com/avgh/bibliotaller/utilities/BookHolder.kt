package com.avgh.bibliotaller.utilities

import android.content.SharedPreferences
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.entities.*
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinAuthor

object BookHolder {

    val bookHeld = arrayOf(
        Book("978-84-08-19740-9", R.drawable.julia.toString(), 1, false),
        Book("978-84-670-5248-0", R.drawable.portada_la.toString(), 1, false),
        Book("978-84-08-20086-4", R.drawable.nuestro_planeta.toString(),1, false),
        Book("978-84-9199-089-5", R.drawable.creatividad.toString(),1, false),
        Book("978-84-670-5598-6", R.drawable.murmullo.toString(),1, false),
        Book("978-84-234-3040-6", R.drawable.liberalismo.toString(),1,false),
        Book("978-84-234-3053-6",R.drawable.archipielago.toString(),1, false),
        Book("978-84-344-3049-5",R.drawable.maspoderoso.toString(),1,false),
        Book("978-84-17453-24-4", R.drawable.efimera.toString(), 1, false),
        Book("978-84-17568-41-2",R.drawable.marca.toString(),1,false)
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
        ),
        Content(
            10, Lagunajes.Espanish, "Liberalismo",
            "En este libro, Juan Ramón Rallo, uno de nuestros más valiosos pensadores liberales, expone cuáles son los diez principios nucleares del liberalismo para así clarificar su significado actual. Según Rallo, el liberalismo es una filosofía política minimalista que no pretende establecer de manera rígida lo que está bien y lo que está mal en todos los aspectos de nuestra existencia, sino que únicamente aspira a descubrir " +
                    "cuál es el marco jurídico necesario para que cada uno pueda vivir su propia vida sin más limitación que la de respetar a los demás. ",
            "978-84-234-3040-6"
        ),
        Content(
            11, Lagunajes.English, "Liberalism",
            "In this book, Juan Ramón Rallo, one of our most valuable liberal thinkers, explains what the ten core principles of liberalism are in order to clarify their current meaning. According to Rallo, liberalism is a minimalist political philosophy that does not intend to rigidly establish what is right and wrong in all aspects of our existence, but only aspires to discover what is the legal framework necessary for each one " +
                    "He can live his own life with no other limitation than respecting others.",
            "978-84-234-3040-6"
        ),
        Content(
            12, Lagunajes.Espanish, "El archipiélago liberal",
            "La historia de las sociedades es una historia de cooperación humana y, al mismo tiempo, un relato de conflictos sucesivos. Si bien la posibilidad de una coexistencia pacífica nunca ha sido cuestionada, la durabilidad y sostenibilidad de dicha armonía siempre ha sido incierta. La filosofía política, por tanto, debe ofrecernos ideas y reflexiones sobre los fundamentos que asientan, o pueden llegar a asentar, el orden social.",
            "978-84-234-3053-6"
        ),
        Content(
            13, Lagunajes.English,"The Liberal archipelago",
            "The history of societies is a history of human cooperation and, at the same time, a story of successive conflicts. While the possibility of peaceful coexistence has never been questioned, the durability and sustainability of such harmony has always been uncertain. The political philosophy, therefore, must offer us ideas and reflections on the foundations that settle, or may come to settle, the social order.",
            "978-84-234-3053-6"
        ),
        Content(
            14, Lagunajes.Espanish,"El dios más poderoso",
            "Omnipresente y omnipotente, plural e infinito, un pequeño dios que actúa de Poeta, un gran poeta que actúa de Dios. Todo eso fue Walt Whitman. Y todo eso aparece en este libro que capta de manera extraordinaria el espíritu y la humanidad del —primero que todo— periodista y narrador, del ciudadano de Brooklyn y amante de Manhattan, del viajero que conoció el Sur esclavista y el paisaje canadiense; en definitiva, del poeta " +
                    "que alzó el canto de sí mismo se hizo de la alegría de vivir, la igualdad, la solidaridady el universalismo sus señas más representativas.",
            "978-84-344-3049-5"
        ),
        Content(
            15, Lagunajes.English,"The most powerful god",
            "Omnipresent and omnipotent, plural and infinite, a small god who acts as a Poet, a great poet who acts as God. All that was Walt Whitman. And all that appears in this book that captures in an extraordinary way the spirit and humanity of the first, first and foremost, journalist and narrator, of the Brooklyn citizen and lover of Manhattan, of the traveler who knew the slave South and the Canadian landscape; in short, " +
                    "the poet who raised the chant of himself and made the joy of life, equality, solidarity and universalism his most representative signs.",
            "978-84-344-3049-5"
        ),
        Content(
            16, Lagunajes.Espanish,"Efimera",
            "Efímera es el nombre de un insecto que vive sólo 24 horas, que no tiene pues los días contados, sino las horas. Y lo efímero es el material del que se nutre este poemario, una reflexión oética sobre lo breve en todas sus facetas, sobre aquello que no dura. El lector encontrará poemas dedicados a la pompa de jabón, pero también a la escarcha, cómo no a la euforia o desde luego al necesariamente efímero muñeco de nieve. " +
                    "¿No lo somos al cabo nosotros mismos, no es lo pasajero lo que nos caracteriza? La muerte, el triunfo de la especie sobre el individuo, es cuanto nos define y ella es quien vuelve efímera nuestra vida, por mucho que se prolongue, por mucho que tratemos de alargarla. Somos temporales, fugaces, finitos.",
            "978-84-344-3049-5"
        ),
        Content(
            17, Lagunajes.Espanish,"Y tú, ¿qué marca eres?",
            "En su primera edición, el objetivo de este libro era analizar cómo, aplicando la marca personal, podíamos desarrollarnos profesionalmente en un entorno donde las relaciones laborales comenzaban a hacerse más ﬂuidas. Ha pasado casi una década desde su publicación y este objetivo se mantiene, pero el contexto ha cambiado. En esta nueva edición permanecen los conceptos clave, pero también aparecen otros nuevos relativos al entorno laboral al que nos enfrentamos en la actualidad.",
            "978-84-17568-41-2"
        ),
        Content(
            18,Lagunajes.English, "And you, what brand are you?",
            "In its first edition, the aim of this book was to analyze how, applying the personal brand, we could develop professionally in an environment where labor relations began to become more fluid. Almost a decade has passed since its publication and this objective remains, but the context has changed. In this new edition, the key concepts remain, but there are also new ones related to the work environment that we are facing today.",
            "978-84-17568-41-2"
        )

    )

    val editorialHeld = arrayOf(
        Editorial(0, "Editorial Planeta", "2018", "Santiago Posteguillo"),
        Editorial(1, "Espasa", "2012", "Madrid"),
        Editorial(2, "GeoPlaneta", "2019", "Barcelona"),
        Editorial(3, "Editorial Critica", "2019", "Santiago de Chile"),
        Editorial(4,"Deusto","2017","Washington"),
        Editorial(5, "Editorial Ariel", "2014", "Ciudad de Mexico"),
        Editorial(6, "Fundación José Manuel Lara", "2019","Cartagena"),
        Editorial(7,"Alienta Editorial","2017", "Barcelona")

    )

    val authorHeld = arrayOf(
        Author("Santiago Posteguillo", 0),
        Author("Karen Viggers", 1 ),
        Author("Keith Scholey",2),
        Author("Elkhonon Goldberg", 3),
        Author("Juan Ramón Rallo", 4),
        Author("Chandran Kukathas", 5),
        Author("Toni Montesinos", 6),
        Author("Miguel Albero",7),
        Author("Neus Arqués",8)
    )

    val authorByBook = arrayOf(
        BookJoinAuthor("978-84-08-19740-9",1),
        BookJoinAuthor("978-84-670-5248-0",0),
        BookJoinAuthor("978-84-08-20086-4",2),
        BookJoinAuthor("978-84-9199-089-5",3),
        BookJoinAuthor("978-84-670-5598-6",1),
        BookJoinAuthor("978-84-234-3040-6", 4),
        BookJoinAuthor("978-84-234-3053-6", 5),
        BookJoinAuthor("978-84-344-3049-5",6),
        BookJoinAuthor("978-84-344-3049-5",7),
        BookJoinAuthor("978-84-17568-41-2",8)
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
        Tag(8, "Contemporanea"),
        Tag(9, "Actualidad"),
        Tag(10, "Politica"),
        Tag(11, "Economia"),
        Tag(12,"Ciencias humanas y sociales"),
        Tag(13,"Poesia"),
        Tag(14,"Empresa")
    )


}