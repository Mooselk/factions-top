package net.novucs.ftop.gui.element.button;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiButtonContent {

    private final String text;
    private final List<String> lore;
    private final Material material;
    private ItemStack item;

    private GuiButtonContent(String text, List<String> lore, Material material) {
        this.text = text;
        this.lore = lore;
        this.material = material;
    }

    public String getText() {
        return text;
    }

    public List<String> getLore() {
        return lore;
    }

    public Material getMaterial() {
        return material;
    }

    public String random() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
     
       return generatedString;
    }
    
    public ItemStack getItem() {
        if (item == null) {
        	if (material == null) {
        		item = new ItemStack(Material.RED_WOOL, 1);
            	ItemMeta meta = item.getItemMeta();
            	meta.setDisplayName(text);
            	meta.setLore(lore);
            	item.setItemMeta(meta);
        	} else {
        		item = new ItemStack(material, 1);
            	ItemMeta meta = item.getItemMeta();
            	meta.setDisplayName(text);
            	meta.setLore(lore);
            	item.setItemMeta(meta);
        	}
        }
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuiButtonContent that = (GuiButtonContent) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(lore, that.lore) &&
                material == that.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, lore, material);
    }

    @Override
    public String toString() {
        return "GuiButtonContent{" +
                "text='" + text + '\'' +
                ", lore=" + lore +
                ", material=" + material +
                '}';
    }

    public static class Builder {

        private String text;
        private List<String> lore = new ArrayList<>();
        private Material material = Material.AIR;

        public void text(String text) {
            this.text = text;
        }

        public void lore(List<String> lore) {
            this.lore = lore;
        }

        public void material(Material material) {
            this.material = material;
        }

        public GuiButtonContent build() {
            return new GuiButtonContent(text, lore, material);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(text, builder.text) &&
                    Objects.equals(lore, builder.lore) &&
                    material == builder.material;
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, lore, material);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "text='" + text + '\'' +
                    ", lore=" + lore +
                    ", material=" + material +
                    '}';
        }
    }
}
