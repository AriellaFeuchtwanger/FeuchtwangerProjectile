package feuchtwanger.Projectile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity{

    private TextView answer;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_answer);

        answer = (TextView) findViewById(R.id.answer);

        Intent intent = getIntent();

        double angle = intent.getDoubleExtra("Angle", 0.0);
        double velocity = intent.getDoubleExtra("Velocity", 0.0);
        double time = intent.getDoubleExtra("Time", 0.0);

        Projectile p = new Projectile(angle, velocity, time);
        double x = p.getX();

        answer.setText(Double.toString(x));
    }
}
