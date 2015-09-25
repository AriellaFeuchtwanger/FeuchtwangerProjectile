package feuchtwanger.Projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView angle;
    TextView velocity;
    TextView time;
    TextView answer2;
    Button calculate;
    TextView answer;
    EditText angleTB;
    EditText velocityTB;
    EditText timeTB;
    double angleA;
    double velocityA;
    double timeA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        angle = (TextView) findViewById(R.id.angle);
        angleTB = (EditText) findViewById(R.id.angleTB);
        velocity = (TextView) findViewById(R.id.velocity);
        velocityTB = (EditText) findViewById(R.id.velocityTB);
        time = (TextView) findViewById(R.id.time);
        timeTB = (EditText) findViewById(R.id.timeTB);
        answer = (TextView) findViewById(R.id.answer);
        answer2 = (TextView) findViewById(R.id.answer2);

        calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                angleA = Double.parseDouble(angleTB.getText().toString());
                velocityA = Double.parseDouble(velocityTB.getText().toString());
                timeA = Double.parseDouble(timeTB.getText().toString());
                Projectile p = new Projectile(angleA, velocityA, timeA);
                answer.setText(Double.toString(p.getX()));
                answer = (TextView) findViewById(R.id.answer);
                answer2.setText(Double.toString(p.getY()));
                answer = (TextView) findViewById(R.id.answer2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showAnswer(){

        double radians = Math.toRadians(angleA);
        final Double answerA = (Math.sin(radians)) * velocityA * timeA;
        answer.setText(answerA.toString());
        answer = (TextView) findViewById(R.id.answer);
    }
}
