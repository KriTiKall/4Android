package com.example.android_translator.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.dao.TranslationFieldDao;
import com.example.android_translator.presentation.presenters.ChangeActivityPresenter;
import com.example.android_translator.presentation.presenters.TextChangeHandler;
import com.example.android_translator.presentation.render.ChangeTranslationRender;
import com.example.android_translator.presentation.view.ChangeView;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeActivity extends MvpAppCompatActivity implements ChangeView, TextView.OnEditorActionListener {

    @BindView(R.id.label_header_change)
    TextView header;
    @BindView(R.id.edit_text_word_change)
    EditText word;
    @BindView(R.id.list_of_possible_translation_change)
    RecyclerView listChange;

    @InjectPresenter
    ChangeActivityPresenter presenter;

    @ProvidePresenter
    ChangeActivityPresenter providePresent() {
        return new ChangeActivityPresenter();
    }

    private String wordString;
    private String firstWord;
    private String translation;

    private TranslationFieldDao database = App.getInstance()
            .getAppDataBase()
            .daoAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        ButterKnife.bind(this);

        Bundle fromMain = getIntent()
                .getExtras();

        wordString = fromMain
                .get("text")
                .toString();
        translation = fromMain
                .get("t_text")
                .toString();
        firstWord = wordString;
        word.setText(wordString);

        word.setOnEditorActionListener(this);
    }

    @Override
    public void setTextHandler(TextChangeHandler textHandler) {

    }

    @Override
    public void initRecycler(List<String> data) {
        wordString = word.getText().toString();

        ChangeTranslationRender render = new ChangeTranslationRender(wordString);
        render.setData(data);

        listChange.setAdapter(render);
        listChange.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_SEND){
            String strOfWord = word.getText().toString();
            Log.w("ChangeActivity", "________________________________________\'" + strOfWord + "\'");
            if(strOfWord == null || strOfWord.equals("")){
                database.delete(new TranslationField(
                        firstWord,
                        translation
                ));
                v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
            }
            return true;
        }
        return false;
    }
}
