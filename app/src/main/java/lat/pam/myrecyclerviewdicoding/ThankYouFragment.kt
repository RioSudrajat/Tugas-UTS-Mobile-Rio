package lat.pam.myrecyclerviewdicoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ThankYouFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_thank_you, container, false)

        val btnBackToHome = view.findViewById<Button>(R.id.btn_back_to_home)
        btnBackToHome.setOnClickListener {
            findNavController().navigate(R.id.action_thankyou_to_home)
        }

        return view
    }
}