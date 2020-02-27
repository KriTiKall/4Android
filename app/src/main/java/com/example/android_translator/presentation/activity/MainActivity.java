package com.example.android_translator.presentation.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.android_translator.R;
import com.example.android_translator.data_perform.TranslationField;
import com.example.android_translator.data_perform.TranslationFieldMockItems;
import com.example.android_translator.domain.MockTranslateUseCase;
import com.example.android_translator.presentation.MainActivityPresenter;
import com.example.android_translator.presentation.render.TranslateRender;

/**
 * Почитать про View и передачу их
 */

//MVVM MVI

    // каждой view по презентару
public class MainActivity extends MvpAppCompatActivity {
    @BindView(R.id.main_recycler)
    private RecyclerView listTranslation;
    @InjectPresenter
    private MainActivityPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<TranslationField> data = new TranslationFieldMockItems().getList(12);
        TranslateRender render = new TranslateRender();
        render.setData(data);

        listTranslation.setAdapter(render);
        listTranslation.setLayoutManager(new LinearLayoutManager(this));
    }

    @ProvidePresenter
    MainActivityPresenter providePresent(){
        return new MainActivityPresenter(new MockTranslateUseCase());
    }

    showTranslate(TranslationField translationField){

    }

    public List<TranslationField> getList() {
        List<TranslationField> list = new ArrayList();
        list.add(new TranslationField(0,"foreword", "предсловие"));
        list.add(new TranslationField(1,"required", "требуемый"));
        list.add(new TranslationField(2,"relate", "относиться"));
        list.add(new TranslationField(3,"familiar", "знакомый"));
        list.add(new TranslationField(4,"either", "любой"));
        list.add(new TranslationField(5,"distinct", "отчетливый"));
        return list;
    }
}
