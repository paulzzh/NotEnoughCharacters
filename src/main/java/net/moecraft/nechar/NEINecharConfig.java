package net.moecraft.nechar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.client.resources.Language;
import net.minecraft.util.EnumChatFormatting;
import net.vfyjxf.nechar.NechConfig;

import codechicken.nei.SearchTokenParser.ISearchParserProvider;
import codechicken.nei.SearchTokenParser.SearchMode;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEINecharConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {
        final List<Language> matchingLanguages = getMatchingLanguages();

        API.addSearchProvider(
            new NecharSearchParserProvider(
                '\0',
                "default",
                EnumChatFormatting.RESET,
                NecharDisplayFilter::new,
                matchingLanguages) {

                @Override
                public SearchMode getSearchMode() {
                    return SearchMode.ALWAYS;
                }

            });
        API.addSearchProvider(
            new NecharSearchParserProvider(
                '#',
                "tooltip",
                EnumChatFormatting.YELLOW,
                NecharTooltipFilter::new,
                matchingLanguages));

        NotEnoughCharacters.logger.info("search provider added!");
    }

    protected List<Language> getMatchingLanguages() {
        return ISearchParserProvider.getAllLanguages()
            .stream()
            .filter(
                lang -> Arrays.stream(NechConfig.neiAllowedLanguages)
                    .anyMatch(lang.getLanguageCode()::equals))
            .collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return NotEnoughCharacters.ID;
    }

    @Override
    public String getVersion() {
        return NotEnoughCharacters.VERSION;
    }
}
