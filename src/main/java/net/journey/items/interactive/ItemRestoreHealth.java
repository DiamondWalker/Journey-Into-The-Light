package net.journey.items.interactive;

import net.journey.init.JourneySounds;
import net.journey.init.JourneyTabs;
import net.journey.items.base.JItem;
import net.journey.util.PotionEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.List;

public class ItemRestoreHealth extends JItem {

	private int amount;
	private boolean restoreFullHealth;

	public ItemRestoreHealth(String name, String finalN, boolean restoreFullHealth) {
		super(name, finalN, JourneyTabs.UTIL);
		this.restoreFullHealth = restoreFullHealth;
		this.setMaxStackSize(1);
	}
	
	public ItemRestoreHealth(String name, String finalN, int amount) {
		super(name, finalN, JourneyTabs.UTIL);
		this.amount = amount;
		this.restoreFullHealth = false;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = player.getHeldItem(handIn);
        worldIn.playEvent(2002, player.getPosition(), PotionUtils.getPotionColor(PotionTypes.HEALING));
        worldIn.playSound(player.posX, player.posY, player.posZ, JourneySounds.SUMMON_TABLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
		if(!worldIn.isRemote) { 
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(PotionEffects.regeneration), 100, 1));
			stack.shrink(1);
			if(restoreFullHealth == true) {
				player.heal(player.getMaxHealth());
			}
			if(restoreFullHealth == false) {
				player.heal(amount);
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	@Override
	public void addInformation(ItemStack i, List l) {
		if (restoreFullHealth == true) { l.add("Restores player to full health"); }
		if (restoreFullHealth == false) { l.add("Restores " + amount + " health"); }
	}
}