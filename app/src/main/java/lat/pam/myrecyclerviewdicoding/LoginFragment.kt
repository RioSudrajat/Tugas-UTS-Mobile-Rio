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
import com.google.android.material.textfield.TextInputEditText
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin = view.findViewById<Button>(R.id.btn_login)
        val tvToRegister = view.findViewById<TextView>(R.id.tv_to_register)


        val etEmail = view.findViewById<TextInputEditText>(R.id.et_email)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()

            // TODO: Validasi login di sini

            // Simpan data ke SharedPreferences
            val sharedPref = activity?.getSharedPreferences("ShopperPref", Context.MODE_PRIVATE) ?: return@setOnClickListener
            with (sharedPref.edit()) {

                putString("USER_NAME", "Pengguna BelanjaIn")
                putString("USER_EMAIL", email)
                apply()
            }

            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        tvToRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_auth, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}