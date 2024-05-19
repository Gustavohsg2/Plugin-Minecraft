package projeto.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import projeto.utils.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static org.bukkit.Bukkit.getBukkitVersion;

public class Ajuda implements CommandExecutor {
    private HashMap<Player, Long> ajuda = new HashMap<>();

    // Os comandos funcionam como arrays, o nome é a base, os argumentos são armazenados no vetor args. Começando da 0, 1, 2...
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) // Se foi executado no console ele cancela o comando
            return false;
        Player p = (Player) s;

        // equalIgnoreCase ignora se foi digitado em maiúsculo ou minúsculo
        if(c.getName().equalsIgnoreCase("ajuda")) {
            // Responsável pelo cooldown
            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))){
                p.sendMessage("§7Aguarde! Comando em cooldown. Aguarde §c" + converter(p) + " segundos!");
                return false;
            }else ajuda.remove(p);
            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10)); // Define o cooldown


            if(args.length == 0){
                p.sendMessage("\n§7Digite /ajuda 1 - Para o servidor");
                p.sendMessage("§7Digite /ajuda 2 - Para o youtube\n");
                return true;
            } else if(args.length == 1){
                switch (args[0]){
                    case "1":
                        p.sendMessage("\n§7O servidor está na versão §c" + getBukkitVersion());

                        ItemStack i = new Item(Material.DIAMOND, 1 /*Qtd de itens*/, (short) 0 /*Id item*/)
                                .setName("§6Um diamante muito bonito")
                                .getItemStack();
                        //ItemMeta im = i.getItemMeta();
                        //im.setDisplayName("§6Um item muito legal!");
                        //im.setLore(Arrays.asList("§6Um diamante muito bonito", "É.... Um item muito legal..!"));
                        //i.setItemMeta(im);
                        p.getInventory().addItem(i); // Adiciona o item i no inventário do player.

                        return true;
                    case "2":
                        p.sendMessage("§7Nosso canal do youtube: §c https://www.youtube.com/@basileiamc");
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    //Função para converção e ver quanto tempo falta de cooldown.
    private Long converter(Player p){
        long time = System.currentTimeMillis() - ajuda.get(p);
        return  1 + TimeUnit.MILLISECONDS.toSeconds(time) * -1;
    }
}
