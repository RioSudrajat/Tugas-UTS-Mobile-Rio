package lat.pam.myrecyclerviewdicoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val rvProducts = view.findViewById<RecyclerView>(R.id.rv_products)

        val productList = createDummyList()

        val productAdapter = ProductAdapter(productList) { product ->
            findNavController().navigate(R.id.action_order_to_checkout)
        }

        rvProducts.adapter = productAdapter
        return view
    }

    private fun createDummyList(): List<Product> {
        return listOf(
            Product("Capcay", "Rp 25.000", R.drawable.capcay),
            Product("Pecel Lele", "Rp 28.000", R.drawable.lele),
            Product("Ayam Penyet Sambal Hijau", "Rp 35.000", R.drawable.penyet),
            Product("Bebek Goreng", "Rp 35.000", R.drawable.begor),
            Product("Mie Ayam Bakso", "Rp 20.000", R.drawable.miayam),
            Product("Ketoprak", "Rp 22.000", R.drawable.ketoprak),
            )
    }
}
