package data_perform;

import java.util.ArrayList;
import java.util.List;

public class TranslationFieldMockList implements MockList<TranslationField> {
    /**
     * Method for test filling recycler by translation field
     * @param length
     * @return
     */
    @Override
    public List<TranslationField> getList(int length) {
        List<TranslationField> list = new ArrayList();
        for(int i = 0; i < length; i++)
            list.add(new TranslationField("concurrency", "совпадения"));
        return list;
    }

    public List<TranslationField> getList() {
        List<TranslationField> list = new ArrayList();

        list.add(new TranslationField("foreword", "предсловие"));
        list.add(new TranslationField("required", "требуемый"));
        list.add(new TranslationField("relate", "относиться"));
        list.add(new TranslationField("familiar", "знакомый"));
        list.add(new TranslationField("either", "любой"));
        list.add(new TranslationField("distinct", "отчетливый"));

        return list;
    }
}
