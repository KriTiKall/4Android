package com.example.android_translator.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.presentation.presenters.AppendActivityPresenter;
import com.example.android_translator.presentation.presenters.TextChangeHandler;
import com.example.android_translator.presentation.render.PossibleTranslationRender;
import com.example.android_translator.presentation.view.AppendView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * RxBind
 * cool link arch -> https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started
 */

public class AppendActivity extends MvpAppCompatActivity implements AppendView, TextView.OnEditorActionListener {

    @BindView(R.id.label_header_append)
    TextView header;
    @BindView(R.id.edit_text_word_append)
    EditText word;
    @BindView(R.id.list_of_possible_translation_append)
    RecyclerView listAppend;

    @InjectPresenter
    AppendActivityPresenter presenter;

    @ProvidePresenter
    AppendActivityPresenter providePresent() {
        return new AppendActivityPresenter();
    }

    private String wordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_append);
        ButterKnife.bind(this);

        word.setOnEditorActionListener(this);
    }

    @Override
    public void setTextHandler(TextChangeHandler textHandler) {
        textHandler.onChange(Observable.just(word.getText().toString()));
    }

    @Override
    public void initRecycler(List<String> data) {
        wordString = word.getText().toString();
        PossibleTranslationRender render = new PossibleTranslationRender(wordString);
        render.setData(data);

        listAppend.setAdapter(render);
        listAppend.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEND) {
            String strOfWord = word.getText().toString();

            Log.w("AppendActivity", "________________________________________\'" + strOfWord + "\'");

            if (strOfWord == null || strOfWord.equals(""))
                v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));

            setTextHandler(presenter.getTextHandler());
            return true;
        }
        return false;
    }
}