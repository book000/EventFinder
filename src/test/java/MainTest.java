import com.tomacheese.eventfinder.I18nMsgType;
import com.tomacheese.eventfinder.Main;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class MainTest {
    @Test
    public void isCorrectI18nFile() {
        try (InputStream is = Main.class.getResourceAsStream("/i18n/")) {
            if (is == null) {
                fail("i18n resource folder is not found.");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            List<String> lang = new ArrayList<>();
            String resource;
            while ((resource = br.readLine()) != null) {
                if (!resource.endsWith(".yml")) {
                    continue;
                }
                lang.add(resource.substring(0, resource.length() - 4));
            }
            List<String> missed = lang.stream()
                .filter(l -> Arrays.stream(Locale.getAvailableLocales())
                    .anyMatch(locale -> locale.toString().equals(l)))
                .collect(Collectors.toList());

            if (!missed.isEmpty()) {
                fail(String.format("The following language files have incorrect language names: %s", String.join(", ", missed)));
            }
        } catch (IOException e) {
            fail(String.format("Failed to read the language file: %s %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }

    @Test
    public void isAllDefinedI18nFileContents() {
        try (InputStream is = Main.class.getResourceAsStream("/i18n/")) {
            if (is == null) {
                fail("i18n resource folder is not found.");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String resource;
            while ((resource = br.readLine()) != null) {
                if (!resource.endsWith(".yml")) {
                    continue;
                }
                List<String> msgTypes = new ArrayList<>();

                try (InputStream file = Main.class.getResourceAsStream("/i18n/" + resource)) {
                    assert file != null;
                    try (BufferedReader br_file = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {
                        String line;
                        while ((line = br_file.readLine()) != null) {
                            if (line.isEmpty()) continue;
                            msgTypes.add(line.split(": ")[0]);
                        }
                        List<String> notFounds = Arrays.stream(I18nMsgType.values())
                            .map(Enum::name)
                            .filter(name -> !msgTypes.contains(name))
                            .collect(Collectors.toList());

                        if (!notFounds.isEmpty()) {
                            fail(String.format("The language file %s does not have the following definition: %s", resource, String.join(", ", notFounds)));
                        }
                    }
                }
            }
        } catch (IOException e) {
            fail(String.format("Failed to read the language file: %s %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }
}
