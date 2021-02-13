package ru.mirea.adapter;

/**
 * Адаптер для американской вилки (переходник)
 */
public class AmericanPlugAdapter extends RussianPlug {
    private final AmericanPlug americanPlug;

    public AmericanPlugAdapter(AmericanPlug americanPlug) {
        this.americanPlug = americanPlug;
    }

    @Override
    public int getPins() {
        int americanPins = americanPlug.getPins();
        return americanPins == 3? 2 : americanPins;
    }
}
