package org.discord.bot.eckort;

import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

public class Main {
    private static final String APIKEY = System.getenv("DC_Eckort_Token");

    public static void main(String[] args) {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(APIKEY);
    }
}