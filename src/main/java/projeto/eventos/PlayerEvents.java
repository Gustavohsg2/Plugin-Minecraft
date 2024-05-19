package projeto.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import projeto.ProjetoBasileia;

public class PlayerEvents implements Listener {
    ProjetoBasileia plugin;
    public PlayerEvents(ProjetoBasileia plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void quandoQuebrarBloco(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(b.getType() != Material.GRASS_BLOCK) return;

        p.sendMessage("§7Você quebrou um bloco de grama!");
        // tickes, 1 segundo é == 20 tickes || E o amplifier começa do 0, 1, 2, 3.
        p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 30, 2, true, true));
    }
}
