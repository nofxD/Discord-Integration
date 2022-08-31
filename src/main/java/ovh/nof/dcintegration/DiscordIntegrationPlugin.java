package ovh.nof.dcintegration;

import club.minnced.discord.webhook.WebhookClient;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiscordIntegrationPlugin extends JavaPlugin {

  public static WebhookClient client;

  @Override
  public void onEnable() {
    this.saveDefaultConfig();
    this.getServer().getPluginManager().registerEvents(new PluginChatListener(), this);
    client = WebhookClient.withUrl(PluginConfig.WEBHOOK);
  }

  @Override
  public void onDisable() {
    client.close();
  }
}