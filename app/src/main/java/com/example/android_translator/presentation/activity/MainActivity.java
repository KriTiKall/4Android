package com.example.android_translator.presentation.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.android_translator.R;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.domain.MockTranslateUseCase;
import com.example.android_translator.presentation.presenters.MainActivityPresenter;
import com.example.android_translator.presentation.render.MainView;
import com.example.android_translator.presentation.render.TranslateRender;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.main_recycler)
    RecyclerView listTranslation;

    @InjectPresenter
    MainActivityPresenter mainPresenter;

    @ProvidePresenter
    MainActivityPresenter providePresent() {
        return new MainActivityPresenter(new MockTranslateUseCase());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initRecycler(List<TranslationField> data) {
        TranslateRender render = new TranslateRender();
        render.setData(data);
        listTranslation.setAdapter(render);
        listTranslation.setLayoutManager(new LinearLayoutManager(this));
    }
}
