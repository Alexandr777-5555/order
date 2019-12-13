package area.answers;

import java.util.ArrayList;
import java.util.List;

public class AnswerStockStoreRegister {

    private List<AnswerProductItem> items;

    public void addItem(AnswerProductItem item) {
        if (items == null) {
            items = new ArrayList<>(10);
        }
        items.add(item);
    }

    public List<AnswerProductItem> getItems() {
        return items;
    }


}

