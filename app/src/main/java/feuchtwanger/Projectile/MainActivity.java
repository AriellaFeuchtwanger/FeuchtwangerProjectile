package feuchtwanger.Projectile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load("http://usercontent2.hubimg.com/8968837_f260.jpg").into(imageView);

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
                MainActivity.this.showAnswer();
            }
        });
    }

    private void showAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);

        double angleA = Double.parseDouble(angleTB.getText().toString());
        double velocityA = Double.parseDouble(velocityTB.getText().toString());
        double timeA = Double.parseDouble(timeTB.getText().toString());

        intent.putExtra("Angle", angleA);
        intent.putExtra("Velocity", velocityA);
        intent.putExtra("Time", timeA);

        startActivity(intent);
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
}
