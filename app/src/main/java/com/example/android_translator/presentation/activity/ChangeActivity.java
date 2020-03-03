package com.example.android_translator.presentation.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.presentation.presenters.AppendActivityPresenter;
import com.example.android_translator.presentation.presenters.ChangeActivityPresenter;
import com.example.android_translator.presentation.render.ChangeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeActivity extends MvpAppCompatActivity implements ChangeView {
    @BindView(R.id.label_header_change)
    TextView header;
    @BindView(R.id.edit_text_word_change)
    EditText word;
    @BindView(R.id.edit_text_translate_change)
    EditText translate;
    @BindView(R.id.button_change)
    Button buttonChange;
    @BindView(R.id.list_of_possible_translation_change)
    RecyclerView listChange;

    @InjectPresenter
    ChangeActivityPresenter presenter;

    @ProvidePresenter
    ChangeActivityPresenter providePresent() {
        return new ChangeActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        ButterKnife.bind(this);
    }
}
