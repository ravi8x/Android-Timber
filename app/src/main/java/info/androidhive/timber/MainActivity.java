package info.androidhive.timber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // boolean
        boolean isWeekend = false;
        Timber.d("This prints the boolean value. Is weekend: %b", isWeekend);

        // integer
        int a = 100;
        Timber.d("Integer a value is: %d", a);

        // float
        float pi = 3.14159f;
        Timber.d("Pi value is: %f", pi);
    }

    @OnClick(R.id.btn_log_string)
    void logMessage() {
        Timber.d("Hello from Timber!");

        showToast();
    }

    @OnClick(R.id.btn_log_exception)
    void logException() {
        try {
            int a = 10 / 0;
            Timber.d("Value of a: %d", a);
        } catch (Exception e) {
            Timber.e(e);

            // or //

            Timber.e("Exception in math operation: %s", e.getMessage());
        }

        showToast();
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), "Check LogCat for message or error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
