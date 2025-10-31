package lat.pam.myrecyclerviewdicoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        val btnPay = view.findViewById<Button>(R.id.btn_pay)
        btnPay.setOnClickListener {
            // TODO: Ambil data alamat & pembayaran di sini

            findNavController().navigate(R.id.action_checkout_to_thankyou)
        }

        return view
    }
}