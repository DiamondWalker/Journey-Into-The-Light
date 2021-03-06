package net.journey.api.scroll;

import net.minecraft.util.ResourceLocation;

import java.util.LinkedHashMap;

/*
 * Code by TimeConqueror
 */
public class ScrollCategory {

    /**
     * Size of Category. The real size will be multiplied by 256.
     */
    private int categorySize;
    private String categoryKey;
    private ResourceLocation backgroundTexture;
    private String id;
    /**
     * The list of the entries that are binded to the category
     */
    private LinkedHashMap<String, ScrollEntry> entryList = new LinkedHashMap<>();

    public ScrollCategory(String categoryKey, /*@NotNull*/ ResourceLocation backgroundTexture) {
        this(categoryKey, backgroundTexture, 2);
    }


    public ScrollCategory(String categoryKey, /*@NotNull*/ ResourceLocation backgroundTexture, int categorySize) {
        this.categorySize = categorySize;
        this.categoryKey = categoryKey;
        this.backgroundTexture = backgroundTexture;
        this.id = this.categoryKey.toUpperCase().replace(' ', '_');
    }

    public int getCategorySize() {
        return categorySize;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public LinkedHashMap<String, ScrollEntry> getEntryList() {
        return entryList;
    }

    public void addEntryToCategory(ScrollEntry ScrollEntry) {
        entryList.put(ScrollEntry.getId(), ScrollEntry);
    }

    public ScrollEntry getEntry(String entryID) {
        if (!entryList.containsKey(entryID)) {
            throw new IndexOutOfBoundsException("Attempt to get nonexistent Entry \"" + entryID + "\" in \"" + categoryKey + "\" Category.\n\tAvailable Entry Names: " + entryList.toString());
        }
        return entryList.get(entryID);
    }

    public ResourceLocation getBackgroundTexture() {
        return backgroundTexture;
    }

    public String getId() {
        return id;
    }

    public int getEntryCount() {
        return entryList.size();
    }
}
