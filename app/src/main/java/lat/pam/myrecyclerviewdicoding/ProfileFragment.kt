package lat.pam.myrecyclerviewdicoding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tv_profile_name)
        val tvEmail = view.findViewById<TextView>(R.id.tv_profile_email)
        val btnLogout = view.findViewById<Button>(R.id.btn_logout)

        val sharedPref = activity?.getSharedPreferences("ShopperPref", Context.MODE_PRIVATE)

        val name = sharedPref?.getString("USER_NAME", "Tamu") // "Tamu" adalah nilai default
        val email = sharedPref?.getString("USER_EMAIL", "email@example.com") // "email@example.com" adalah nilai default

        tvName.text = name
        tvEmail.text = email

        btnLogout.setOnClickListener {
            sharedPref?.edit()?.clear()?.apply()

            val intent = Intent(activity, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            activity?.finish()
        }
    }
}