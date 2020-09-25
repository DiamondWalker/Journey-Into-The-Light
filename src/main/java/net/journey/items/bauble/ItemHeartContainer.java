package net.journey.items.bauble;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

import java.util.List;
import java.util.UUID;

public class ItemHeartContainer extends ItemBaubleBase implements IBauble {

    protected static final UUID HEALTH_MODIFIER = UUID.fromString("9769f32f-1489-40ab-aa87-2985aa3246fd");
    public double hearts;

    public ItemHeartContainer(double hearts) {
        this.hearts = hearts;
        setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BODY;
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier(HEALTH_MODIFIER, "Health Modifier", hearts, 0));
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(new AttributeModifier(HEALTH_MODIFIER, "Health Modifier", hearts, 0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack i, World worldIn, List<String> l, ITooltipFlag flagIn) {
        l.add(SlayerAPI.Colour.GOLD + "Grants " + hearts + " extra health points");
    }
}
