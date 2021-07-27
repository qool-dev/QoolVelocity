package dev.qool.qoolvelocity;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public final class QoolVelocity extends JavaPlugin {

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : getServer().getWorlds()) {
                    for (Entity entity : world.getEntities()) {
                        for (String tag : entity.getScoreboardTags()) {
                            if (tag.startsWith("Velocity_")) {
                                String positionSet = tag.replaceFirst("Velocity_", "");
                                try {
                                    String xString = positionSet.split("_")[0];
                                    String yString = positionSet.split("_")[1];
                                    String zString = positionSet.split("_")[2];
                                    double x = Double.parseDouble(xString);
                                    double y = Double.parseDouble(yString);
                                    double z = Double.parseDouble(zString);
                                    entity.setVelocity(new Vector(x, y, z));
                                    entity.removeScoreboardTag(tag);
                                } catch (Exception e) {

                                }
                            }
                            if (tag.startsWith("addVelocity_")) {
                                String positionSet = tag.replaceFirst("addVelocity_", "");
                                try {
                                    String xString = positionSet.split("_")[0];
                                    String yString = positionSet.split("_")[1];
                                    String zString = positionSet.split("_")[2];
                                    double x = Double.parseDouble(xString);
                                    double y = Double.parseDouble(yString);
                                    double z = Double.parseDouble(zString);
                                    entity.setVelocity(entity.getVelocity().clone().add(new Vector(x, y, z)));
                                    entity.removeScoreboardTag(tag);
                                } catch (Exception e) {

                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0, 0);
    }

}
