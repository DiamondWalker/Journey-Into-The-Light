package net.journey.items;

import net.journey.util.PotionEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.item.ItemModFood;

public class ItemGoldenFood extends ItemModFood {

	private final boolean op;

	public ItemGoldenFood(int heal, float sat, boolean wolf, boolean isOP) {
		super(heal, sat, wolf);
		op = isOP;
		this.setAlwaysEdible();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack i) {
		return op;
	}

    @Override
    public EnumRarity getRarity(ItemStack i) {
        return !op ? EnumRarity.RARE : EnumRarity.EPIC;
    }

    @Override
    protected void onFoodEaten(ItemStack i, World w, EntityPlayer p) {
        if (!w.isRemote) {
            p.addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.absorption, 2400, 0)));
            if (op) {
                p.addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.regeneration, 600, 4)));
                p.addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.resistance, 6000, 0)));
                p.addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.fireResistance, 6000, 0)));
            }
        } else {
            super.onFoodEaten(i, w, p);
        }
    }
}