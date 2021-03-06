package com.example.android_translator.presentation.render;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.dao.TranslationFieldDao;
import com.example.android_translator.presentation.activity.MainActivity;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeTranslationRender  extends RecyclerView.Adapter<ChangeTranslationRender.ChangeTranslationViewHolder> {

    private List<String> data;

    private String wordString;

    private ViewGroup parent;

    private TranslationFieldDao database = App.getInstance()
            .getAppDataBase()
            .daoAccess();

    public ChangeTranslationRender(String word) {
        this.wordString = word;
    }

    @NonNull
    @Override
    public ChangeTranslationRender.ChangeTranslationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.change_translation_layout, parent, false);

        return new ChangeTranslationRender.ChangeTranslationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChangeTranslationRender.ChangeTranslationViewHolder holder, int position) {
        String translation = data.get(position);
        holder.bind(translation);
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ChangeTranslationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.Change_word)
        TextView possibleTranslation;

        public ChangeTranslationViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(String translation) {
            possibleTranslation.setText(translation);
        }

        @Override
        public void onClick(View v) {
            Log.d("ChangeRender", "--------------word: " + wordString + ", translate: " + possibleTranslation.getText().toString());

            database.update(new TranslationField(
                    wordString,
                    possibleTranslation.getText().toString()
            ));

            Intent backToMain = new Intent(parent.getContext(), MainActivity.class);
            parent.getContext().startActivity(backToMain);
        }
    }
}