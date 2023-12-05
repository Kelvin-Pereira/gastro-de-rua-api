package com.dog.arquitetura.lang;

import com.dog.arquitetura.lang.annotation.NonNull;
import com.dog.arquitetura.lang.annotation.Nullable;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.text.Normalizer;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class Strings {
    private static final Pattern NORMALIZER = Pattern.compile("(\\p{InCombiningDiacriticalMarks}+)");
    private static final Pattern SYMBOLS = Pattern.compile("\\W+");
    private static final Pattern EXTRA_WHITESPACE = Pattern.compile("\\s+");

    public static Optional<String> notBlank(String primary, String... alternatives) {
        if (notBlank(primary)) return Optional.of(primary);
        for (int i = 0; i < alternatives.length; i++) {
            String s = alternatives[i];
            if (notBlank(s)) return Optional.of(s);
        }
        return Optional.empty();
    }

    private static boolean notBlank(String str) {
        return str != null && !str.isBlank();
    }

    public static String normalizeSpaces(String s) {
        if (s == null) return null;
        return EXTRA_WHITESPACE.matcher(s).replaceAll(" ").trim();
    }

    public static boolean normalizedEquals(@Nullable String a, @Nullable String b) {
        if (a == null) return b == null;
        if (b == null) return false;
        if (a.equalsIgnoreCase(b)) return true;
        var normA = normalize(a);
        var normB = normalize(b);
        return normA.equals(normB);
    }

    public static String normalize(@NonNull String s) {
        String n = Normalizer.normalize(normalizeSpaces(s), Normalizer.Form.NFD);
        return SYMBOLS.matcher(NORMALIZER.matcher(n).replaceAll(""))
                .replaceAll(" ")
                .toLowerCase();
    }

    public static String trimToNull(@Nullable String str) {
        if (str == null || str.isBlank()) return null;
        return str.trim();
    }

    @Nullable
    public static String capitalize(@Nullable String frase) {
        if (frase == null) return null;
        char[] chars = frase.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    public static boolean allEmpty(String first, String... others) {
        if (!first.isEmpty()) return false;
        for (String s : others) {
            if (!s.isEmpty()) return false;
        }
        return true;
    }

    public static String joinerVirgulaOuE(String first, String... others) {
        if (others.length == 0) return first;
        String[] array = Stream.concat(Stream.of(first), Stream.of(others))
                .filter(str -> str != null && !str.isEmpty())
                .toArray(String[]::new);
        if (array.length == 1) return array[0];
        if (array.length == 2) return array[0] + " e " + array[1];
        StringBuilder sb = new StringBuilder().append(array[0]);
        for (int i = 1; i < array.length - 1; i++) {
            sb.append(", ").append(array[i]);
        }
        sb.append(" e ").append(array[array.length - 1]);
        return sb.toString();
    }
}
