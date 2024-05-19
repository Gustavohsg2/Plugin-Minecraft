package projeto;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import projeto.comandos.Ajuda;
import projeto.eventos.PlayerEvents;
import projeto.eventos.ServerEvents;

public class ProjetoBasileia extends JavaPlugin {
    private static ProjetoBasileia instance;

    @Override
    public void onEnable(){
        ConsoleCommandSender b = Bukkit.getConsoleSender();
        instance = this;
        loadConfig();
        b.sendMessage("§a[" + getDescription().getName() + "] §fPlugin foi iniciado");
        b.sendMessage("§a[" + getDescription().getName() + "] §f" + getDescription().getAuthors());
        registrarEventos();
        registrarComandos();
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§eO Plugin foi desligado!");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
    public static ProjetoBasileia getInstance() {
        return instance;
    }
    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(this), this);
        Bukkit.getPluginManager().registerEvents(new ServerEvents(this), this);
    }
    private void registrarComandos() {
        getCommand("ajuda").setExecutor(new Ajuda());
    }
}
