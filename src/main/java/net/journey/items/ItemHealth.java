package net.journey.items;

import net.journey.init.JourneySounds;
import net.journey.util.Config;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.PlayerHelper;
import net.slayer.api.SlayerAPI;

import java.util.List;

public class ItemHealth extends ItemFood {

    public int max = Config.maxHealthNormal;
    public int maxSentry = Config.maxHealthSentry;
    public double hearts;
    public boolean isSentry;

    public ItemHealth(String name, String actual, int hearts, int food, boolean sat, boolean isSentry) {
        super(food, sat);
        this.hearts = hearts;
        this.isSentry = isSentry;
        setMaxStackSize(8);
        setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack i, World w, EntityPlayer p) {
        if (!isSentry && p.getMaxHealth() < max) {
            p.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(p.getMaxHealth() + hearts);
            PlayerHelper.getPersistedpTag(p).setDouble("health", p.getMaxHealth());
            JourneySounds.playSound(JourneySounds.SUMMON_TABLE, w, p);
		}
        if (isSentry && p.getMaxHealth() < maxSentry) {
            p.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(p.getMaxHealth() + hearts);
            PlayerHelper.getPersistedpTag(p).setDouble("health", p.getMaxHealth());
            JourneySounds.playSound(JourneySounds.SUMMON_TABLE, w, p);
		}
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag par4) {
        list.add(SlayerAPI.Colour.RED + "Adds " + hearts / 2F + " Heart(s)");
        list.add(SlayerAPI.Colour.RED + "Max health: " + max);
        if (isSentry) {
            list.add(SlayerAPI.Colour.GOLD + "Recommended only if player has reached max health");
        }
    }
}
