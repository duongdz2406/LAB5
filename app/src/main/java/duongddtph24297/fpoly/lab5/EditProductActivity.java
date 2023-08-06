package duongddtph24297.fpoly.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProductActivity extends AppCompatActivity
         {
    private EditText edtName, edtPrice, edtDes;
    private Button btnSave, btnDelete;
    String pid, strName, strPrice, strDes;
    GetProducDetailsTask productDetailsTask;
    SaveProductDetailsTask saveProductDetailsTask;
    DeleteProductTask deleteProductTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        edtName = (EditText) findViewById(R.id.edtProductName);
        edtPrice = (EditText) findViewById(R.id.edtProductPrice);
        edtDes = (EditText) findViewById(R.id.edtProductDes);
        btnSave =  findViewById(R.id.btnSave);
        btnDelete =  findViewById(R.id.btnDelete);
        pid = getIntent().getStringExtra(Constants.TAG_PID);
        productDetailsTask = new
                GetProducDetailsTask(this,edtName,edtPrice,edtDes);
        productDetailsTask.execute(pid);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = edtName.getText().toString();
                strPrice = edtPrice.getText().toString();
                strDes = edtDes.getText().toString();
                saveProductDetailsTask = new SaveProductDetailsTask(getApplicationContext());


                saveProductDetailsTask.execute(pid, strName, strPrice, strDes);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProductTask = new DeleteProductTask(getApplicationContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Deleting product...");
                builder.setMessage("Are you sure you want delete this product?");

                builder.setNegativeButton("Yes", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                deleteProductTask.execute(pid);
                                dialogInterface.dismiss();

                                Toast.makeText(EditProductActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setPositiveButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                builder.show();
            }
        });
    }

    }


