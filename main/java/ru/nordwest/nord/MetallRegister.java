package ru.nordwest.nord;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.nordwest.nord.block.BaseMetalOre;
import ru.nordwest.nord.block.BaseMetallBlock;
import ru.nordwest.nord.item.ItemMetallBlock;
import ru.nordwest.nord.item.ItemMetallDrop;
import ru.nordwest.nord.item.ItemMetallIngot;
import ru.nordwest.nord.item.ItemMetallOre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MetallRegister {
        public static class Ores {
                public final String name;
                public final float hard;
                /**
                 * Sets or removes the tool and level required to harvest this block.
                 * <p/>
                 * param toolClass Class
                 * param level Harvest level:
                 * Wood:    0
                 * Stone:   1
                 * Iron:    2
                 * Diamond: 3
                 * Gold:    0
                 */
                public final int harvest;

                public Ores(String name, float hard, int harvest) {
                        this.name = name;
                        this.hard = hard;
                        this.harvest = harvest;
                }
        }

        public static final String[] metall_list = new String[]{"alluminum", "chrome",
                "iron", "titan", "tungsten", "zing", "gold", "cobalt", "copper",
                "nickel", "tin", "platinum", "plumbum", "silver", "antimony", "brass",
                "bronze", "castiron", "duralumin", "electrum", "invar", "nichrome", "steel", "tnc"};

        public static final String[] ore_list = new String[]{"bauxite", "chromite",
                "crocoite", "uvarovite", "cobaltite", "skutterudite", "azurite",
                "brochantite", "copper", "almandine", "hematite", "limonite",
                "magnetite", "pyrite", "olivine", "gold_quartz", "millerite",
                "pentlandite", "proustite", "cerussite", "dundas", "vanadinite",
                "tin", "ilmenite", "titanite", "wolframite", "blende", "zincite",
                "argentite", "galena", "silver"};

        public static final List<Ores> ores = new ArrayList<Ores>();
        private static final HashMap<String, Block> metall_block = new HashMap<String, Block>();
        private static final HashMap<String, Item> metall_ingot = new HashMap<String, Item>();

        private static final HashMap<String, ItemStack> metall_ore = new HashMap<String, ItemStack>();
        private static final HashMap<String, ItemStack> metall_drop = new HashMap<String, ItemStack>();
        private static final HashMap<String, ItemStack> metall_powder = new HashMap<String, ItemStack>();
        private static final HashMap<String, ItemStack> metall_clear_powder = new HashMap<String, ItemStack>();

        static public void preInit() {
                ores.add(new Ores("bauxite", 2, 3));
                ores.add(new Ores("chromite", 2, 2));
                ores.add(new Ores("crocoite", 2, 2));
                ores.add(new Ores("uvarovite", 2, 2));
                ores.add(new Ores("cobaltite", 2, 3));
                ores.add(new Ores("skutterudite", 2, 3));
                ores.add(new Ores("azurite", 2, 2));
                ores.add(new Ores("brochantite", 2, 2));
                ores.add(new Ores("copper", 2, 1));
                ores.add(new Ores("almandine", 2, 2));
                ores.add(new Ores("hematite", 2, 2));
                ores.add(new Ores("limonite", 2, 2));
                ores.add(new Ores("magnetite", 2, 2));
                ores.add(new Ores("pyrite", 2, 2));
                ores.add(new Ores("olivine", 2, 3));
                ores.add(new Ores("gold_quartz", 2, 3));
                ores.add(new Ores("millerite", 2, 2));
                ores.add(new Ores("pentlandite", 2, 2));
                ores.add(new Ores("proustite", 2, 2));
                ores.add(new Ores("cerussite", 2, 2));
                ores.add(new Ores("dundas", 2, 3));
                ores.add(new Ores("vanadinite", 2, 2));
                ores.add(new Ores("tin", 1, 1));
                ores.add(new Ores("ilmenite", 2, 2));
                ores.add(new Ores("titanite", 2, 3));
                ores.add(new Ores("wolframite", 2, 3));
                ores.add(new Ores("blende", 2, 3));
                ores.add(new Ores("zincite", 2, 3));
                ores.add(new Ores("argentite", 2, 3));
                ores.add(new Ores("galena", 2, 2));
                ores.add(new Ores("silver", 2, 3));
        }

        static public void init() {
        /*
         * Регестрируем Металлы: блоки, слитки, пыль, рецепт
	*/
                Item item;
                Block block = null;
                for (final String metall : MetallRegister.metall_list) {
                        block = new BaseMetallBlock(Material.iron)
                                .setBlockName(metall + "_block")
                                .setCreativeTab(Nord.metalsTab)
                                .setBlockTextureName(metall + "_block").setHardness(3.0F)
                                .setHardness(5.0F);
                        block.setHarvestLevel("pickaxe", 2);
                        GameRegistry.registerBlock(block, ItemMetallBlock.class, metall
                                + "_block");
                        MetallRegister.metall_block.put(metall, block);
                        item = new ItemMetallIngot().setUnlocalizedName(metall + "_ingot")
                                .setTextureName(metall + "_ingot");
                        GameRegistry.registerItem(item, metall + "_ingot");
                        MetallRegister.metall_ingot.put(metall, item);
                        for (int i = 0; i < 4; i++) {
                                GameRegistry.addRecipe(new ItemStack(block, 1, i), "xxx",
                                        "xxx", "xxx", 'x', new ItemStack(item, 1, i));
                        }
                }

                /**
                 * Регестрируем руды, дропу, пыль и чистую пыль
                 */
                final Item drop = new ItemMetallDrop("drop").setUnlocalizedName("drop");
                GameRegistry.registerItem(drop, "drop");

                final Item powder = new ItemMetallDrop("powder")
                        .setUnlocalizedName("powder");
                GameRegistry.registerItem(powder, "powder");

                final Item clear_powder = new ItemMetallDrop("clear_powder")
                        .setUnlocalizedName("clear_powder");
                GameRegistry.registerItem(clear_powder, "clear_powder");

                for (int i = 0; i < MetallRegister.ores.size(); i++) {
                        final String name = MetallRegister.ores.get(i).name;
                        if ((i % 16) == 0) {
                                block = new BaseMetalOre(Material.rock, i)
                                        .setCreativeTab(Nord.metalsTab).setResistance(5.0F).setBlockName("ore_" + i);
                                GameRegistry.registerBlock(block, ItemMetallOre.class, "ore_"
                                        + i);
                        }
                        if (block != null) {
                                MetallRegister.metall_ore.put(name, new ItemStack(block, 1,
                                        i % 16));
                                MetallRegister.metall_drop.put(name, new ItemStack(drop, 1, i));
                                MetallRegister.metall_powder.put(name, new ItemStack(powder, 1,
                                        i));
                                MetallRegister.metall_clear_powder.put(name, new ItemStack(
                                        clear_powder, 1, i));
                        }
                }

        }

        public static ItemStack getMetallBlock(final String name, final int quality, final int quantaty) {
                if (MetallRegister.metall_block.containsKey(name)) {
                        return new ItemStack(MetallRegister.metall_block.get(name), quantaty,
                                quality % 4);
                } else {
                        System.err.println("Can't catch block name. Unknown metall block: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getMetallIngot(final String name, final int quality, final int quantity) {
                if (MetallRegister.metall_ingot.containsKey(name)) {
                        return new ItemStack(MetallRegister.metall_ingot.get(name), quantity,
                                quality % 4);
                } else {
                        System.err.println("Can't catch ingot name. Unknown metall: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getMetallPowder(final String name, final int quantaty) {
                if (MetallRegister.metall_ingot.containsKey(name)) {
                        return new ItemStack(MetallRegister.metall_block.get(name), quantaty, 5);
                } else {
                        System.err.println("Can't catch powder name. Unknown metall: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getOre(final String name, final int quantaty) {
                if (MetallRegister.metall_ore.containsKey(name)) {
                        ItemStack item = MetallRegister.metall_ore.get(name);
                        item.stackSize = quantaty;
                        return item;
                } else {
                        System.err.println("Unknown Ore: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getOreDrop(final String name, final int quantaty) {
                if (MetallRegister.metall_drop.containsKey(name)) {
                        ItemStack item = MetallRegister.metall_drop.get(name);
                        item.stackSize = quantaty;
                        return item;
                } else {
                        System.err.println("Can't catch the drop. Unknown Ore: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getOrePowder(final String name, final int quantaty) {
                if (MetallRegister.metall_powder.containsKey(name)) {
                        ItemStack item = MetallRegister.metall_powder.get(name);
                        item.stackSize = quantaty;
                        return item;
                } else {
                        System.err.println("Can't catch the powder. Unknown Ore: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }

        public static ItemStack getOreClearPowder(final String name, final int quantaty) {
                if (MetallRegister.metall_clear_powder.containsKey(name)) {
                        ItemStack item = MetallRegister.metall_clear_powder.get(name);
                        item.stackSize = quantaty;
                        return item;
                } else {
                        System.err.println("Can't catch clear powder. Unknown Ore: " + name);
                        System.err.println("Game has crashed:)");
                        return null;
                }
        }
}
