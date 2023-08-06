package duongddtph24297.fpoly.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {
    private EditText edtName, edtPrice, edtDescription;
    private Button btnAdd;
    String strName,strPrice,strDes;
    CreateNewProducTask newProductTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        edtName = (EditText)findViewById(R.id.edtProductName);
        edtPrice = (EditText)findViewById(R.id.edtProductPrice);
        edtDescription = (EditText)findViewById(R.id.edtProductDes);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        newProductTask = new CreateNewProducTask(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strName = edtName.getText().toString();
                strPrice = edtPrice.getText().toString();
                strDes = edtDescription.getText().toString();
                newProductTask.execute(strName,strPrice,strDes);
            }
        });

        }
}