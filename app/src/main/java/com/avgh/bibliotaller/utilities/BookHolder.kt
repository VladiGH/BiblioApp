package com.avgh.bibliotaller.utilities

import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.entities.*

object BookHolder {

    val bookHeld = arrayOf(
        Book("978-84-08-19740-9", R.drawable.portada_yo_julia.toString(), 1)
    )

    val contentHeld = arrayOf(
        Content(0, Lagunajes.Espanish, "Yo, Julia",
            "192 d.C. Varios hombres luchan por un imperio, pero Julia, hija de reyes, madre de césares y esposa de emperador, piensa en algo más ambicioso: una dinastía. Roma está bajo el control de Cómodo, un emperador loco. El Senado se conjura para terminar con el tirano y los gobernadores militares más poderosos podrían dar un golpe de Estado: Albino en Britania, Severo en el Danubio o Nigro en Siria. Cómodo retiene a sus esposas para evitar su rebelión y Julia, la mujer de Severo, se convierte así en rehén. \n De pronto, Roma arde. Un incendio asola la ciudad. ¿Es un desastre o una oportunidad? Cinco hombres se disponen a luchar a muerte por el poder. Creen que la partida está a punto de empezar. Pero para Julia la partida ya ha empezado. Sabe que solo una mujer puede forjar una dinastía.",
            "978-84-08-19740-9"),
        Content(1, Lagunajes.English, "I, Julia",
            "192 AD Several men fight for an empire, but Julia, daughter of kings, mother of Caesars and emperor's wife, thinks of something more ambitious: a dynasty. Rome is under the control of Commodus, a mad emperor. The Senate is conspired to finish with the tyrant and the most powerful military governors could give a coup d'etat: Albino in Britain, Severo in the Danube or Nigro in Syria. Comfortable keeps his wives to avoid their rebellion and Julia, the wife of Severo, thus becomes a hostage.",
            "978-84-08-19740-9")
    )

    val editorialHeld = arrayOf(
        Editorial(0, "Editorial Planeta", "2018", "Santiago Posteguillo")
    )

    val authorHeld = arrayOf(
        Author("Santiago Posteguillo",0)
    )

    val tagHeld = arrayOf(
        Tag(0, "Novela"),
        Tag(1, "histórico"),
        Tag(2, "Antigua Roma")
    )


}