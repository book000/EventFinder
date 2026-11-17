import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.PluginCommandYamlParser;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommandPermissionTest {
    @Test
    public void commandAndViewPermissionsAreDeclaredForOperatorsByDefault() throws Exception {
        try (InputStream input = getClass().getResourceAsStream("/plugin.yml")) {
            assertNotNull(input);
            Map<?, ?> yaml = new Yaml().load(input);
            Map<?, ?> permissions = (Map<?, ?>) yaml.get("permissions");
            assertNotNull(permissions);
            for (String name : new String[]{"eventfinder.command.event", "eventfinder.view"}) {
                Map<?, ?> permission = (Map<?, ?>) permissions.get(name);
                assertNotNull("Missing permission: " + name, permission);
                assertEquals(name, PermissionDefault.OP,
                    PermissionDefault.getByName((String) permission.get("default")));
            }
        }
    }

    @Test
    public void eventMutationsRequirePermissionGrantedToOperatorsByDefault() throws Exception {
        PluginDescriptionFile description;
        try (InputStream input = getClass().getResourceAsStream("/plugin.yml")) {
            assertNotNull(input);
            description = new PluginDescriptionFile(input);
        }
        Plugin plugin = (Plugin) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{Plugin.class},
            (proxy, method, args) -> {
                if (method.getName().equals("getDescription")) return description;
                if (method.getName().equals("isEnabled")) return true;
                if (method.getName().equals("getName")) return description.getName();
                return null;
            });
        PluginCommand command = (PluginCommand) PluginCommandYamlParser.parse(plugin).stream()
            .filter(candidate -> candidate.getName().equals("event"))
            .findFirst().orElseThrow(AssertionError::new);
        assertEquals("eventfinder.command.event", command.getPermission());
        Map<?, ?> yaml;
        try (InputStream input = getClass().getResourceAsStream("/plugin.yml")) {
            yaml = new Yaml().load(input);
        }
        Map<?, ?> permissions = (Map<?, ?>) yaml.get("permissions");
        Map<?, ?> permission = (Map<?, ?>) permissions.get(command.getPermission());
        assertNotNull(permission);
        PermissionDefault permissionDefault = PermissionDefault.getByName((String) permission.get("default"));
        assertEquals(PermissionDefault.OP, permissionDefault);

        AtomicInteger executions = new AtomicInteger();
        command.setExecutor((sender, cmd, label, args) -> {
            executions.incrementAndGet();
            return true;
        });
        command.setPermissionMessage("");
        for (boolean operator : new boolean[]{false, true}) {
            CommandSender sender = (CommandSender) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class<?>[]{CommandSender.class}, (proxy, method, args) -> {
                    if (method.getName().equals("isOp")) return operator;
                    if (method.getName().equals("hasPermission")) {
                        return command.getPermission().equals(args[0]) && permissionDefault.getValue(operator);
                    }
                    return null;
                });
            command.execute(sender, "event", new String[]{"filter", "test"});
            assertEquals(operator ? 1 : 0, executions.get());
        }
    }
}
