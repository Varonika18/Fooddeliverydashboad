package com.example.dashboard;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity4 extends AppCompatActivity {
    EditText editText,editText2,editText4,editText5,editText11,editText12,editText13;
    Button button;
    LinearLayout layout,linearLayout;
    ImageView imageView,imageView5;
    private final int GALLERY_REQ_CODE=1000;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        editText=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName2);
        editText11=findViewById(R.id.editTextTextPersonName11);
        editText12=findViewById(R.id.editTextTextPersonName12);
        editText13=findViewById(R.id.editTextTextPersonName13);
        editText4=findViewById(R.id.editTextTextPersonName4);
        editText5=findViewById(R.id.editTextTextPersonName5);

        button=findViewById(R.id.button4);
        layout=findViewById(R.id.layout);
        imageView=findViewById(R.id.imageView);
        imageView5=findViewById(R.id.imageView5);
        linearLayout=findViewById(R.id.linearlayout);
        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName2,
                "[5-9]{1}[0-9]{9}",R.string.invalid_mobile);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName11,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName12,
                "[5-9]{1}[0-9]{9}",R.string.invalid_mobile);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName13,
                "[5-9]{1}[0-9]{9}",R.string.invalid_mobile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),
                            "From Validate Succefully....",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Validation Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        layout.setOnClickListener(v->mGetContent.launch("image/*"));

    }
    ActivityResultLauncher<String> mGetContent=registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if(result!=null){
                        imageView.setImageURI(result);
                    }
                }
            });
}