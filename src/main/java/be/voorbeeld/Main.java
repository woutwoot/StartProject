package be.voorbeeld;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Dit is je belangrijkste bestand. Het is het eerste bestand wat wordt ingeladen door de server.
 */
public class Main extends JavaPlugin implements Listener {

    /**
     * Deze methode wordt als 1e aangeroepen bij het opstarten van je plugin.
     */
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this); //Om er voor te zorgen dat events werken.
        getLogger().info("Hello World!");
    }

    /**
     * Deze methode wordt aangeroepen bij afsluiten van je plugin
     */
    @Override
    public void onDisable(){
        getLogger().info("Goodbye World :(");
    }

    /**
     * Deze methdode wordt aangeroepen elke keer als een speler beweegt in het spel. Je mag de naam van de methode zelf kiezen.
     */
    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event){
        Location waarIsDeSpelerNu = event.getPlayer().getLocation();
        event.getPlayer().getWorld().playEffect(waarIsDeSpelerNu, Effect.SMOKE, 5);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /**
         * Deze methode zal aangeroepen worden als je /start uitvoert in het spel. (of gewoon start in de console)
         */
        if (command.getName().equalsIgnoreCase("start")) {
            sender.sendMessage(ChatColor.DARK_RED + "Je hebt /start gebruikt!");
            return true;
        }
        return false;
    }
}
