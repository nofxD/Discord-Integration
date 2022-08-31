package ovh.nof.dcintegration;

import java.util.regex.Pattern;

/**
 * Source: https://github.com/Javacord/Javacord/blob/master/javacord-api/src/main/java/org/javacord/api/util/DiscordRegexPattern.java
 */
public final class DiscordRegexPattern {

  public static final Pattern USER_MENTION =
      Pattern.compile("(?x)                  # enable comment mode \n"
          + "(?<!                # negative lookbehind \n"
          + "                    # (do not have uneven amount of backslashes before) \n"
          + "    (?<!\\\\)       # negative lookbehind (do not have one backslash before) \n"
          + "    (?:\\\\{2}+)    # exactly two backslashes \n"
          + "    {0,1000000000}+ # 0 to 1_000_000_000 times \n"
          + "                    # (basically *, but a lookbehind has to have a maximum length) \n"
          + "    \\\\            # the one escaping backslash \n"
          + ")                   # \n"
          + "<@!?+               # '<@' or '<@!' \n"
          + "(?<id>[0-9]++)      # the user id as named group \n"
          + ">                   # '>'");

  public static final Pattern ROLE_MENTION =
      Pattern.compile("(?x)                  # enable comment mode \n"
          + "(?<!                # negative lookbehind \n"
          + "                    # (do not have uneven amount of backslashes before) \n"
          + "    (?<!\\\\)       # negative lookbehind (do not have one backslash before) \n"
          + "    (?:\\\\{2}+)    # exactly two backslashes \n"
          + "    {0,1000000000}+ # 0 to 1_000_000_000 times \n"
          + "                    # (basically *, but a lookbehind has to have a maximum length) \n"
          + "    \\\\            # the one escaping backslash \n"
          + ")                   # \n"
          + "<@&                 # '<@&' \n"
          + "(?<id>[0-9]++)      # the role id as named group \n"
          + ">                   # '>'");
}