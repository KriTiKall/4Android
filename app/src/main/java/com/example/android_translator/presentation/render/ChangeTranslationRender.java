package com.example.android_translator.presentation.render;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_translator.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeTranslationRender  extends RecyclerView.Adapter<ChangeTranslationRender.ChangeTranslationViewHolder> {

    private List<String> data;

    @NonNull
    @Override
    public ChangeTranslationRender.ChangeTranslationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

    public class ChangeTranslationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.Change_word)
        TextView possibleTranslation;

        public ChangeTranslationViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String translation) {
            possibleTranslation.setText(translation);
        }
    }
}
