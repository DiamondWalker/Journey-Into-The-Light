package net.journey.client.render.mob.base;

import net.journey.client.render.base.RenderModMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTransparent extends RenderModMob {

    public RenderEntityTransparent(ModelBase model, float shadow, ResourceLocation tex) {
        super(model, shadow, tex);
    }

    public RenderEntityTransparent(ModelBase model, ResourceLocation tex) {
        super(model, tex);
    }

}
