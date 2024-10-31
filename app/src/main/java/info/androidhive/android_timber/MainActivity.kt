package info.androidhive.android_timber

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import timber.log.Timber


@Suppress("DIVISION_BY_ZERO")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Timber.d("Hello from Timber!")

        // boolean
        val isWeekend = false
        Timber.d("This prints the boolean value. Is weekend: %b", isWeekend)

        // integer
        val a = 100
        Timber.d("Integer a value is: %d", a)

        // float
        val pi = 3.14159f
        Timber.d("Pi value is: %f", pi)

        try {
            val ans = 10 / 0
            Timber.d("Value of a: %d", ans)
        } catch (e: Exception) {
            Timber.e(e)

            // or
            Timber.e("Exception in math operation: %s", e.message)
        }
    }
}