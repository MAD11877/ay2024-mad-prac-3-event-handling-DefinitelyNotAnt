package sg.edu.np.mad.madpractical3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("John Doe", "MAD Developer",1,false);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        final String[] flwText = {"Follow"};
        btnFollow.setText(flwText[0]);
        btnFollow.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),flwText[0]+"ed",Toast.LENGTH_SHORT).show();
            if (flwText[0].equals("Follow")){
                flwText[0] = "Unfollow";
                btnFollow.setText(flwText[0]);
            }
            else{
                flwText[0] = "Follow";
                btnFollow.setText(flwText[0]);
            }
        });
    }
}