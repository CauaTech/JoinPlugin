package com.br.joinplugin;

import com.br.joinplugin.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }



    @Override
    public void onEnable() {

        GetConfig();
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§5[JoinPlugin] §aPlugin iniciou com sucesso.!");
        Bukkit.getPluginManager().registerEvents(this, instance);

    }


    private void GetConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();

    }




    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player p  = e.getPlayer();
        if (Config.JoinMsg){
            if (Config.JoinGlobal) {
                String Mensagem = Main.getInstance().getConfig().getString("JoinMensagem.Mensagem").replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                e.setJoinMessage(Mensagem);
            }
            if (Config.JoinPrivate){
                e.setJoinMessage("");
                String Mensagem = Main.getInstance().getConfig().getString("JoinMensagem.Mensagem").replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                p.sendMessage(Mensagem);
            }

            if (Config.JoinTitle){
                String Line01 = Main.getInstance().getConfig().getString("JoinMensagem.Title.Lines.One").replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                String Line02 = Main.getInstance().getConfig().getString("JoinMensagem.Title.Lines.Two").replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                p.sendTitle(""+Line01,""+Line02);
            }
        }
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e){
        Player p  = e.getPlayer();
        if (Config.QuitMsg){
            String Mensagem = Main.getInstance().getConfig().getString("QuitMensagem.Mensagem").replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
            e.setQuitMessage(Mensagem);
        }

    }
}
