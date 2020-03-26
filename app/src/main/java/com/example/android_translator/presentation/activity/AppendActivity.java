package com.example.android_translator.presentation.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.presentation.presenters.AppendActivityPresenter;
import com.example.android_translator.presentation.render.PossibleTranslationRender;
import com.example.android_translator.presentation.view.AppendView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    private String wordString;

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
        PossibleTranslationRender render = new PossibleTranslationRender(wordString);
        render.setData(data);
        listAppend.setAdapter(render);
        listAppend.setLayoutManager(new LinearLayoutManager(this));
    }
}
