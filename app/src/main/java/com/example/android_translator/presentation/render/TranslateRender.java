package com.example.android_translator.presentation.render;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_translator.R;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.presentation.activity.ChangeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TranslateRender extends RecyclerView.Adapter<TranslateRender.TranslateViewHolder> {

    private List<TranslationField> data;

    @NonNull
    @Override
    public TranslateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translate_layout, parent, false);

        return new TranslateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TranslateViewHolder holder, int position) {
        TranslationField translate = data.get(position);
        holder.bind(translate);
    }

    public void setData(List<TranslationField> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TranslateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.main_word)
        TextView word;
        @BindView(R.id.main_translation)
        TextView translation;

        public TranslateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(TranslationField translate) {
            word.setText(translate.getWord());
            translation.setText(translate.getTranslation());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ChangeActivity.class);
            intent.putExtra("text", word.getText().toString());
            v.getContext().startActivity(intent);
        }
    }
}
