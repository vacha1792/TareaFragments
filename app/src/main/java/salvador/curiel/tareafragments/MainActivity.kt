package salvador.curiel.tareafragments

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? = null


        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = fragment1.newInstance("", "")

            }
            R.id.navigation_dashboard -> {
                fragment = fragment2.newInstance("", "")
            }
            R.id.navigation_notifications -> {
                fragment = fragment3Creditos.newInstance("", "")
            }

        }
        if(fragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragmentPrincipal, fragment).commitNow()
        }

        false
    }



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navegador.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
