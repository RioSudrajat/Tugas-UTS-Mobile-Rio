package lat.pam.myrecyclerviewdicoding

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val price: String,
    @DrawableRes val imageResource: Int
)
