package ovh.nof.dcintegration;

import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class PluginChatListener implements Listener {

  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
    if (!isAllowed(event.getMessage())) {
      return;
    }
    final WebhookMessageBuilder builder = new WebhookMessageBuilder();

    builder.setUsername(event.getPlayer().getName());
    builder.setAvatarUrl("https://mc-heads.net/avatar/" + event.getPlayer().getUniqueId());
    builder.setContent(event.getMessage());

    DiscordIntegrationPlugin.client.send(builder.build());
  }

  private boolean isAllowed(String str) {
    return !str.startsWith("/") &&
        !str.contains("@everyone") &&
        !str.contains("@here") &&
        !DiscordRegexPattern.USER_MENTION.matcher(str).find() &&
        !DiscordRegexPattern.ROLE_MENTION.matcher(str).find();
  }
}