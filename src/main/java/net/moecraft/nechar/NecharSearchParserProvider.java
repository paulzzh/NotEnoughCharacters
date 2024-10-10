package net.moecraft.nechar;

import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import net.minecraft.client.resources.Language;
import net.minecraft.util.EnumChatFormatting;

import codechicken.nei.ItemList.NothingItemFilter;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.SearchField;
import codechicken.nei.SearchTokenParser.ISearchParserProvider;
import codechicken.nei.SearchTokenParser.SearchMode;
import codechicken.nei.api.ItemFilter;

public class NecharSearchParserProvider implements ISearchParserProvider {

    protected final List<Language> matchingLanguages;
    protected final BiFunction<String, Pattern, ItemFilter> createFilter;
    protected final String name;
    protected final char prefix;
    protected final EnumChatFormatting highlightedColor;

    public NecharSearchParserProvider(char prefix, String name, EnumChatFormatting highlightedColor,
        BiFunction<String, Pattern, ItemFilter> createFilter, List<Language> matchingLanguages) {
        this.prefix = prefix;
        this.name = name;
        this.highlightedColor = highlightedColor;
        this.createFilter = createFilter;
        this.matchingLanguages = matchingLanguages;
    }

    @Override
    public ItemFilter getFilter(String searchText) {
        Pattern pattern = SearchField.getPattern(searchText);

        if (pattern != null) {
            final ItemFilter filter = this.createFilter.apply(searchText, pattern);
            return filter == null ? new NothingItemFilter() : filter;
        }

        return new NothingItemFilter();
    }

    @Override
    public List<Language> getMatchingLanguages() {
        return this.matchingLanguages;
    }

    @Override
    public char getPrefix() {
        return this.prefix;
    }

    @Override
    public EnumChatFormatting getHighlightedColor() {
        return this.highlightedColor;
    }

    @Override
    public SearchMode getSearchMode() {
        return SearchMode.fromInt(NEIClientConfig.getIntSetting("inventory.search." + this.name + "SearchMode"));
    }

}
