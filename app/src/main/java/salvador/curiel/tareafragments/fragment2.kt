package salvador.curiel.tareafragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_fragment2.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var editTextUrl: EditText?= null
var btnGo: Button?= null
var web1: WebView?= null

/**
 * A simple [Fragment] subclass.
 * Use the [fragment2.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val contenedor:View = inflater.inflate(R.layout.fragment_fragment2, container, false)

        editTextUrl = contenedor.findViewById(R.id.url)
        btnGo = contenedor.findViewById(R.id.BtnIr)
        web1 = contenedor.findViewById(R.id.webNav)

        web1!!.webChromeClient = WebChromeClient()

        val ajustes = web1!!.settings
        ajustes.javaScriptEnabled = true

        btnGo!!.setOnClickListener {
            web1!!.loadUrl((cargaUrl(url!!.text.toString())))
        }

        return contenedor
    }

    fun cargaUrl(url:String):String{
        if(url.startsWith("http://")){
            return url
        }else if(url.startsWith("www")){
            return "http://$url"
        }else{
            return "https://www.youtube.com/watch?v=Ahha3Cqe_fk"
        }
        return url
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
