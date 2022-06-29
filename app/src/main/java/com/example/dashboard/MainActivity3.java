package com.example.dashboard;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity3 extends AppCompatActivity {
    EditText editText,editText2,editText3,editText4,editText5;
    Button button;
    LinearLayout layout;
    ImageView imageView;
    private final int GALLERY_REQ_CODE=1000;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName2);
        editText3=findViewById(R.id.editTextTextPersonName3);
        editText4=findViewById(R.id.editTextTextPersonName4);
        editText5=findViewById(R.id.editTextTextPersonName5);

        button=findViewById(R.id.button);
        layout=findViewById(R.id.layout);
        imageView=findViewById(R.id.imageView);
        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName,
                RegexTemplate.NOT_EMPTY,R.string.invalid_sname);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName2,
                RegexTemplate.NOT_EMPTY,R.string.invalid_aname);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName5,
                RegexTemplate.NOT_EMPTY,R.string.invalid_des);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName3,
                RegexTemplate.NOT_EMPTY,R.string.invalid_pname);
        awesomeValidation.addValidation(this,R.id.editTextTextPersonName4,
                RegexTemplate.NOT_EMPTY,R.string.invalid_title);

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