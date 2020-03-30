package com.example.android_translator.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.dao.TranslationFieldDao;
import com.example.android_translator.presentation.presenters.MainActivityPresenter;
import com.example.android_translator.presentation.render.TranslateRender;
import com.example.android_translator.presentation.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.main_recycler)
    RecyclerView listTranslation;

    @InjectPresenter
    MainActivityPresenter mainPresenter;

    @ProvidePresenter
    MainActivityPresenter providePresent() {
        return new MainActivityPresenter();
    }

    private TranslationFieldDao database = App.getInstance()
            .getAppDataBase()
            .daoAccess();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuAppend = getMenuInflater();
        menuAppend.inflate(R.menu.append, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_append_translation:
                Intent intent = new Intent(this, AppendActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
