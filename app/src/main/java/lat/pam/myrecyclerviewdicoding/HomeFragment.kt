package lat.pam.myrecyclerviewdicoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment ini
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvBestSellers = view.findViewById<RecyclerView>(R.id.rv_best_sellers)
        val bestSellerList = createBestSellerList() // <-- Buat data dummy baru
        val bestSellerAdapter = ProductAdapter(bestSellerList) { product ->
            findNavController().navigate(R.id.action_home_to_checkout)
        }
        rvBestSellers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvBestSellers.adapter = bestSellerAdapter

        val tvSeeAllBestSellers = view.findViewById<TextView>(R.id.tv_see_all_best_seller)
        tvSeeAllBestSellers.setOnClickListener {
            // TODO: Ganti R.id.action_home_to_order dengan ID navigasi yang benar
            findNavController().navigate(R.id.action_home_to_order)
        }

        val rvFeaturedProducts = view.findViewById<RecyclerView>(R.id.rv_featured_products)
        val featuredList = createFeaturedList()
        val featuredAdapter = ProductAdapter(featuredList) { product ->
            findNavController().navigate(R.id.action_home_to_checkout)
        }
        rvFeaturedProducts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFeaturedProducts.adapter = featuredAdapter

        val tvSeeAllFeatured = view.findViewById<TextView>(R.id.tv_see_all_featured)
        tvSeeAllFeatured.setOnClickListener {
            // TODO: Ganti R.id.action_home_to_order dengan ID navigasi yang benar
            findNavController().navigate(R.id.action_home_to_order)
        }


        val btnProfile = view.findViewById<ImageButton>(R.id.btn_profile)
        btnProfile.setOnClickListener {

            Toast.makeText(context, "Membuka Halaman Profil...", Toast.LENGTH_SHORT).show()

            // TODO: Ganti R.id.action_home_to_profile dengan ID navigasi yang benar
        }
    }


    override fun onResume() {
        super.onResume()
        (activity as? AppCompatActivity)?.supportActionBar?.title = ""
    }

    private fun createFeaturedList(): List<Product> {
        return listOf(
            Product("Capcay", "Rp 25.000", R.drawable.capcay),
            Product("Pecel Lele", "Rp 28.000", R.drawable.lele),
            Product("Ayam Penyet Sambal Hijau", "Rp 35.000", R.drawable.penyet),
        )
    }

    private fun createBestSellerList(): List<Product> {
        return listOf(
            Product("Bebek Goreng", "Rp 35.000", R.drawable.begor),
            Product("Mie Ayam Bakso", "Rp 20.000", R.drawable.miayam),
            Product("Ketoprak", "Rp 22.000", R.drawable.ketoprak),
        )
    }
}

