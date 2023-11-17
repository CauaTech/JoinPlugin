package com.br.joinplugin.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class Holo {
    private static ArmorStand armorStand;

    public void create(Player p, String HoloName){
        despawn();
        HoloName.replace("&","§");
        ArmorStand Holo = p.getWorld().spawn(p.getLocation(), ArmorStand.class);
        Holo.setVisible(false);
        Holo.setGravity(false);
        Holo.setCustomNameVisible(true);
        Holo.setCustomName(""+HoloName);
        this.armorStand = Holo;
    }

    public static void despawn() {
        if (armorStand != null) {
            if (!armorStand.getLocation().getChunk().isLoaded())
                armorStand.getLocation().getChunk().load();
            armorStand.remove();
        }
    }

}
