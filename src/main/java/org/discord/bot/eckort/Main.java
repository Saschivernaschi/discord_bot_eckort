package org.discord.bot.eckort;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.discord.bot.eckort.listener.CommandListener;
import org.discord.bot.eckort.listener.CommandManager;
import org.discord.bot.eckort.listener.commands.PingPongCommand;

public class Main {
    private static final String APIKEY = System.getenv("DC_Eckort_Token");
    public static final String PREFIX = "/E ";

    public static void main(String[] args) {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(APIKEY);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGE_REACTIONS);

        builder.addEventListeners(new CommandListener());
        CommandManager.getInstance().addCommand("Ping", new PingPongCommand());
        //start bot
        ShardManager shardManager = builder.build();
    }
}