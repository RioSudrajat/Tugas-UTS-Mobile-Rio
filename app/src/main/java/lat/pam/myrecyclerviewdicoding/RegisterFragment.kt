package lat.pam.myrecyclerviewdicoding
import android.content.Context // <-- Tambahkan import ini
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText // <-- Tambahkan import ini

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val btnRegister = view.findViewById<Button>(R.id.btn_register)
        val tvToLogin = view.findViewById<TextView>(R.id.tv_to_login)

        val etName = view.findViewById<TextInputEditText>(R.id.et_name)
        val etEmail = view.findViewById<TextInputEditText>(R.id.et_email_register)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            // TODO: Tambahkan validasi (pastikan tidak kosong, dll)

            val sharedPref = activity?.getSharedPreferences("ShopperPref", Context.MODE_PRIVATE) ?: return@setOnClickListener
            with (sharedPref.edit()) {
                putString("USER_NAME", name)
                putString("USER_EMAIL", email)
                apply() // Simpan secara asynchronous
            }

            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        tvToLogin.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}