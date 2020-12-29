package net.jitl.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.jitl.common.entity.EssenciaBoltEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

//Copy of default LightningBoltRenderer, but with with red color shift and shrunk size
@OnlyIn(Dist.CLIENT)
public class EssenciaBoltRenderer extends EntityRenderer<EssenciaBoltEntity> {
    public EssenciaBoltRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(EssenciaBoltEntity entityIn, float entityYaw, float partialTicks, @NotNull MatrixStack matrixStackIn, @NotNull IRenderTypeBuffer bufferIn, int packedLightIn) {
        float[] afloat = new float[8];
        float[] afloat1 = new float[8];
        float f = 0.0F;
        float f1 = 0.0F;
        Random random = new Random(entityIn.seed);

        for (int i = 7; i >= 0; --i) {
            afloat[i] = f;
            afloat1[i] = f1;
            f += (float) (random.nextInt(11) - 5);
            f1 += (float) (random.nextInt(11) - 5);
        }

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.lightning());
        Matrix4f matrix4f = matrixStackIn.last().pose();

        for (int layer = 0; layer < 4; ++layer) {
            Random random1 = new Random(entityIn.seed);

            for (int rayIndex = 0; rayIndex < 3; ++rayIndex) {
                int l = 7;
                int i1 = 0;
                if (rayIndex > 0) {
                    l = 7 - rayIndex;
                }

                if (rayIndex > 0) {
                    i1 = l - 2;
                }

                float f2 = afloat[l] - f;
                float f3 = afloat1[l] - f1;

                for (int j1 = l; j1 >= i1; --j1) {
                    boolean mainRay = rayIndex == 0;

                    float f4 = f2;
                    float f5 = f3;
                    if (mainRay) {
                        f2 += (float) (random1.nextInt(11) - 5);
                        f3 += (float) (random1.nextInt(11) - 5);
                    } else {
                        f2 += (float) (random1.nextInt(31) - 15);
                        f3 += (float) (random1.nextInt(31) - 15);
                    }

                    float oneDirectionExpansion = 0.1F + (float) layer * 0.2F;
                    if (mainRay) {
                        oneDirectionExpansion = (float) ((double) oneDirectionExpansion * ((double) j1 * 0.1D + 1.0D));
                    }

                    float anotherDirectionExpansion = 0.1F + (float) layer * 0.2F;
                    if (mainRay) {
                        anotherDirectionExpansion *= (float) (j1 - 1) * 0.1F + 1.0F;
                    }

                    // shrinking vanilla expansions
                    oneDirectionExpansion *= 1F / 3;
                    anotherDirectionExpansion *= 1F / 3;

                    quad(matrix4f, ivertexbuilder, f2, f3, j1, f4, f5, 1.0F, 0.25F, 0.1F, oneDirectionExpansion, anotherDirectionExpansion, false, false, true, false);
                    quad(matrix4f, ivertexbuilder, f2, f3, j1, f4, f5, 1.0F, 0.25F, 0.1F, oneDirectionExpansion, anotherDirectionExpansion, true, false, true, true);
                    quad(matrix4f, ivertexbuilder, f2, f3, j1, f4, f5, 1.0F, 0.25F, 0.1F, oneDirectionExpansion, anotherDirectionExpansion, true, true, false, true);
                    quad(matrix4f, ivertexbuilder, f2, f3, j1, f4, f5, 1.0F, 0.25F, 0.1F, oneDirectionExpansion, anotherDirectionExpansion, false, true, false, false);
                }
            }
        }

    }

    /**
     * @param r                         red channel: from 0 to 1
     * @param g                         green channel: from 0 to 1
     * @param b                         blue channel: from 0 to 1
     * @param oneDirectionExpansion     expansion from center to the start of quad
     * @param anotherDirectionExpansion expansion from center to the end of quad
     */
    private static void quad(Matrix4f matrix, IVertexBuilder builder, float startCenterX, float startCenterZ, int startY, float endCenterX, float endCenterZ, float r, float g, float b, float oneDirectionExpansion, float anotherDirectionExpansion, boolean boolean_, boolean boolean1_, boolean boolean2_, boolean boolean3_) {
        builder.vertex(matrix, startCenterX + (boolean_ ? anotherDirectionExpansion : -anotherDirectionExpansion), (float) (startY * 16), startCenterZ + (boolean1_ ? anotherDirectionExpansion : -anotherDirectionExpansion)).color(r, g, b, 0.9F).endVertex();
        builder.vertex(matrix, endCenterX + (boolean_ ? oneDirectionExpansion : -oneDirectionExpansion), (float) ((startY + 1) * 16), endCenterZ + (boolean1_ ? oneDirectionExpansion : -oneDirectionExpansion)).color(r, g, b, 0.9F).endVertex();
        builder.vertex(matrix, endCenterX + (boolean2_ ? oneDirectionExpansion : -oneDirectionExpansion), (float) ((startY + 1) * 16), endCenterZ + (boolean3_ ? oneDirectionExpansion : -oneDirectionExpansion)).color(r, g, b, 0.9F).endVertex();
        builder.vertex(matrix, startCenterX + (boolean2_ ? anotherDirectionExpansion : -anotherDirectionExpansion), (float) (startY * 16), startCenterZ + (boolean3_ ? anotherDirectionExpansion : -anotherDirectionExpansion)).color(r, g, b, 0.9F).endVertex();
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull EssenciaBoltEntity entityIn) {
        return AtlasTexture.LOCATION_BLOCKS;
    }
}
