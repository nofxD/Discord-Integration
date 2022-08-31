package ovh.nof.dcintegration;

import org.bukkit.plugin.java.JavaPlugin;

public final class PluginConfig {

  public static String WEBHOOK = JavaPlugin
      .getPlugin(DiscordIntegrationPlugin.class)
      .getConfig()
      .getString("webhook");
}