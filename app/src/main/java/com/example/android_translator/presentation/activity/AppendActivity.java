package com.example.android_translator.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_translator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppendActivity extends AppCompatActivity {
    @BindView(R.id.label_header_append)
    private TextView header;
    @BindView(R.id.edit_text_word_append)
    private EditText word;
    @BindView(R.id.edit_text_translate_append)
    private EditText translate;
    @BindView(R.id.edit_text_translate_append)
    private Button buttonAppend;
    @BindView(R.id.list_of_possible_translation_append)
    private RecyclerView listAppend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_append);
        ButterKnife.bind(this);
    }
}
