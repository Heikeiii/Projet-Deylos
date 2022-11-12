package fr.dirzii.deyloshub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Sound.ENTITY_EXPERIENCE_ORB_PICKUP;

public class PluginListeners implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.getInventory().clear();
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassM = compass.getItemMeta();
        compassM.setDisplayName("§cServer Selector");
        //compassM.setLore();
        //compassM.addEnchant(Enchantment.CHANNELING, 25, true);
        //compassM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //compassM.setUnbreakable(true);
        compass.setItemMeta(compassM);

        player.getInventory().setItem(4, compass);
        player.updateInventory();

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cServer Selector")){

            Inventory inv = Bukkit.createInventory(null, 27, "§8Server Selector");

            ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta swordM = diamond_sword.getItemMeta();
            swordM.setDisplayName("§a HCF - En cours de développement");
            swordM.setUnbreakable(true);
            swordM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            swordM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            diamond_sword.setItemMeta(swordM);

            ItemStack iron_sword = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta ironswordM = diamond_sword.getItemMeta();
            ironswordM.setDisplayName("§c Practice - En cours de développement");
            ironswordM.setUnbreakable(true);
            ironswordM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ironswordM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            iron_sword.setItemMeta(ironswordM);


            inv.setItem(11, diamond_sword);
            inv.setItem(15, iron_sword);
            player.openInventory(inv);

        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        InventoryView invview = e.getView();

        if(current == null) return;

        if(invview.getTitle().equals("§8Server Selector")){
            e.setCancelled(true);
            player.closeInventory();

            if(current.getType() == Material.DIAMOND_SWORD || current.getType() == Material.IRON_SWORD) {
                player.sendMessage("§cEn cours de développement");
            }
        }
    }

    public ItemStack getItem(Material material, String customName) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }

    @EventHandler
    public void onPlayerVoid (PlayerMoveEvent e){
        Player player = (Player) e.getPlayer();
        if(player.getLocation().getBlockY() <= -20) {
            player.teleport(player.getWorld().getSpawnLocation());
            player.playSound(player.getLocation(), ENTITY_EXPERIENCE_ORB_PICKUP, 500.0f, 1.0f);
            player.sendMessage(ChatColor.DARK_AQUA + "Vous avez été téléporté au spawn!");
        }
    }


}
