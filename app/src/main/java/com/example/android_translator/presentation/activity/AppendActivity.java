package com.example.android_translator.presentation.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.repository.DataBaseRepository;
import com.example.android_translator.presentation.presenters.AppendActivityPresenter;
import com.example.android_translator.presentation.render.PossibleTranslationRender;
import com.example.android_translator.presentation.view.AppendView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

/**
 * RxBind
 * cool link arch -> https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started
 */

public class AppendActivity extends MvpAppCompatActivity implements AppendView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_append);
        ButterKnife.bind(this);
    }

//    @Override
//    public Observable<CharSequence> getTextFromEditText() {
//        return RxTextView.textChanges(word).debounce(500, TimeUnit.MILLISECONDS);
//    }

    @Override
    public void initRecycler(List<String> data) {
        PossibleTranslationRender render = new PossibleTranslationRender();
        render.setData(data);
        listAppend.setAdapter(render);
        listAppend.setLayoutManager(new LinearLayoutManager(this));
    }

    public void appendWord(View v){
        App.getInstance()
                .getAppDataBase()
                .daoAccess()
                .insert(new TranslationField(UUID.randomUUID().hashCode(),
                        word.getText().toString(),
                        ((EditText)v).getText().toString()));
    }
}
