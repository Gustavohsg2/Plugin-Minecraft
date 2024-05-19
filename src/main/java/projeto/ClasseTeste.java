package projeto;
import org.bukkit.Bukkit;
import static projeto.ProjetoBasileia.*;

public class ClasseTeste {
    public static void exibirPessoas() {
        for(String mensagens : getInstance().getConfig().getStringList("Config.lista"))
            Bukkit.getConsoleSender().sendMessage(mensagens.replace("&", "§"));
    }
}
