package com.example.android_translator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import data_perform.TranslationField;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_recycler)
    RecyclerView listTranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
