package com.example.android_translator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeActivity extends AppCompatActivity {
    @BindView(R.id.label_header_change)
    TextView header;
    @BindView(R.id.edit_text_word_change)
    EditText word;
    @BindView(R.id.edit_text_translate_change)
    EditText translate;
    @BindView(R.id.edit_text_translate_change)
    Button buttonChange;
    @BindView(R.id.list_of_possible_translation_change)
    RecyclerView listChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        ButterKnife.bind(this);
    }
}
