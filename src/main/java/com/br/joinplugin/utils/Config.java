package com.br.joinplugin.utils;

import com.br.joinplugin.Main;

public class Config {
    public static String ServerName = Main.getInstance().getConfig().getString("Config.ServerName").replace("&", "§");
    public static boolean JoinMsg = Main.getInstance().getConfig().getBoolean("JoinMensagem.Active");
    public static boolean JoinTitle = Main.getInstance().getConfig().getBoolean("JoinMensagem.Title.Active");

    public static boolean JoinGlobal = Main.getInstance().getConfig().getBoolean("JoinMensagem.Global");

    public static boolean JoinPrivate = Main.getInstance().getConfig().getBoolean("JoinMensagem.Private");


    public static boolean QuitMsg = Main.getInstance().getConfig().getBoolean("QuitMensagem.Active");

}
