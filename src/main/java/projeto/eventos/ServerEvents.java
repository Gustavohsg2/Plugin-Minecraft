package projeto.eventos;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import projeto.ProjetoBasileia;

public class ServerEvents implements Listener {
    ProjetoBasileia plugin;
    public ServerEvents(ProjetoBasileia plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void quandoPingar(ServerListPingEvent e) {
        String m;
        if (!Bukkit.hasWhitelist()) {
            m = plugin.getConfig().getString("configs.active").replace("&", "§");
        } else {
            m = plugin.getConfig().getString("configs.offline").replace("&", "§");
        }
        e.setMotd(m);
    }

}