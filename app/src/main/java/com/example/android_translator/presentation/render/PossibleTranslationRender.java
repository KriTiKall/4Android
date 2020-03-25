package com.example.android_translator.presentation.render;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.List;
import java.util.UUID;

public class PossibleTranslationRender extends RecyclerView.Adapter<PossibleTranslationRender.PossibleTranslationViewHolder> {

    private List<String> data;

    @NonNull
    @Override
    public PossibleTranslationRender.PossibleTranslationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.possible_translation_layout, parent, false);

        return new PossibleTranslationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PossibleTranslationViewHolder holder, int position) {
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

    public class PossibleTranslationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.possible_word)
        TextView possibleTranslation;

        public PossibleTranslationViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String translation) {
            possibleTranslation.setText(translation);
        }
    }
}
