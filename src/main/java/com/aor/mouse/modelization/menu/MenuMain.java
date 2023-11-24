package com.aor.mouse.modelization.menu;

import java.util.Arrays;
import java.util.List;

public class MenuMain {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuMain() {
        super();
        this.entries = Arrays.asList("Start", "Guide", "Exit");
    }
    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedGuide() {return isSelected(1);}
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

}
