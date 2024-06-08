package org.discord.bot.eckort.h2;

import org.h2.tools.Server;

import java.sql.*;

public class databaseManager {

    private Server server;

    private Connection conn;

    private final static String relativePath = "/src/main/resources/db"; // from the discord_bot_eckort folder
    private final static String dbName = "db";

    public databaseManager(){
        try {
            server = Server.createTcpServer("-tcpAllowOthers").start(); //will expose the database to the outside (intellij)
            Class.forName("org.h2.Driver"); //creates the driver wich is neede for the databse
            conn = DriverManager.getConnection(STR."jdbc:h2:.\{relativePath}/\{dbName}", "sa", "sa"); // creates the connection to the databse and if not present will create it
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
