package de.kqray.invisibleitemframe;

import de.kqray.invisibleitemframe.Commands.AddItemsForIFC;
import de.kqray.invisibleitemframe.Commands.GiveInvisibleItemFrame;
import de.kqray.invisibleitemframe.Commands.ItemFrameCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.md_5.bungee.chat.TextComponentSerializer;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class InvisibleItemFrame extends JavaPlugin {
    public static ArrayList<Player> hack = new ArrayList<>();
    @Override
    public void onEnable() {
        //getCommand("CraftInvisibleItemFrame").setExecutor(new ItemFrameCommand());
        //getCommand("AddInvisibleItemFrameRecipe").setExecutor(new AddItemsForIFC());
        //getCommand("GiveInvisibleItemFrame").setExecutor(new GiveInvisibleItemFrame());
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new PlayerJoinEvent(), this);
        registerItemRecipe();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic


    }
    private void registerItemRecipe() {
        ItemStack item = new ItemStack(Material.ITEM_FRAME);

        net.minecraft.world.item.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = new NBTTagCompound();
        NBTTagCompound entityTag = new NBTTagCompound();
        entityTag.a("Invisible", NBTTagByte.a(true));
        compound.a("EntityTag", entityTag);
        nmsItem.c(compound);
        item = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta itemMeta = item.getItemMeta();
        //TODO: change item meta
        itemMeta.displayName(ComponentSerialization.etAndHEX.deserialize("&cInvisible Itemframe"));
        item.setItemMeta(itemMeta);
        ShapedRecipe craftRum = new ShapedRecipe(NamespacedKey.fromString("frames:invisible_item_frame"), item);
        craftRum.shape("xxx","xyx","xxx");
        craftRum.setIngredient('x', Material.GLASS_PANE);
        craftRum.setIngredient('y', Material.ITEM_FRAME);
        Bukkit.getServer().addRecipe(craftRum);


    }



}
