package de.kqray.invisibleitemframe;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ComponentSerialization {

    private ComponentSerialization() {} // prevent instantiation

    public static final LegacyComponentSerializer
            sectionAndHEX = LegacyComponentSerializer.builder()
            .character('§').hexCharacter('#').hexColors().build(),
            unusualSectionAndHEX = LegacyComponentSerializer.builder()
                    .character('§').hexCharacter('#').hexColors()
                    .useUnusualXRepeatedCharacterHexFormat().build(),
            etAndHEX = LegacyComponentSerializer.builder()
                    .character('&').hexCharacter('#').hexColors().build(),
            etOnly = LegacyComponentSerializer.builder()
                    .character('&').build(),
            sectionOnly = LegacyComponentSerializer.builder()
                    .character('§').build();

}
