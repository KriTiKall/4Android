package data_perform;

import java.util.ArrayList;
import java.util.List;

public class TranslationFieldMockItems implements MockItems<TranslationField> {
    /**
     * Method for test filling recycler by translation field
     * @param length
     * @return
     */
    @Override
    public List<TranslationField> getList(int length) {
        List<TranslationField> list = new ArrayList();
        for(int i = 0; i < length; i++)
            list.add(new TranslationField(i,"concurrency", "совпадения"));
        return list;
    }
}
