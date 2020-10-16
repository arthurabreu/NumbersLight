package com.arthur.android.numberslight

import com.arthur.android.numberslight.listnumbers.model.Numbers
import com.arthur.android.numberslight.network.model.NLEntity
import com.arthur.android.numberslight.network.model.NumberDetailsEntity

fun getNumberDetailsEntity(): NumberDetailsEntity {
    return NumberDetailsEntity(
            1,
            "text",
            "/image.php?text=千五百"
    )
}

fun getNumbers() : List<Numbers> {
    return listOf(Numbers(
            "1",
            "text"
    ))
}

fun getNLEntity() : List<NLEntity> {
    return listOf(NLEntity(
            "1",
            "text"
    ))
}