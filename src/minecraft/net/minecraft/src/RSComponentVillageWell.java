package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class RSComponentVillageWell extends RSComponentVillage
{
    private final boolean field_74924_a = true;
    private int averageGroundLevel = -1;

    public RSComponentVillageWell(RSComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, int par4, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = 0;
        this.boundingBox = new StructureBoundingBox(par4, 63, par5, par4 + 6 - 1, 77, par5 + 6 - 1);
    }

    /**
     * Initiates construction of the Structure BTAComponent picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
    	StructureVillagePieces.getNextStructureComponentVillagePath((RSComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 2, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 1, this.getComponentType());
    	StructureVillagePieces.getNextStructureComponentVillagePath((RSComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 3, this.getComponentType());
    	StructureVillagePieces.getNextStructureComponentVillagePath((RSComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 2, 2, this.getComponentType());
    	StructureVillagePieces.getNextStructureComponentVillagePath((RSComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, 0, this.getComponentType());
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 3, 0);
        }
		
        //Clears space above
        for (int i = -1; i <= 6; i++)
        {
            for (int j = -1; j <= 6; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, 11, i, par3StructureBoundingBox);
            }
        }

        //Base
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, -1, 10, -1, 6, 10, 6, RSDecoIntegration.stoneTypesStoneBrick.blockID, 1, RSDecoIntegration.stoneTypesStoneBrick.blockID, 1, false);
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 10, 0, 4, 10, 4, RSDecoIntegration.stoneTypesSmooth.blockID, 1, RSDecoIntegration.stoneTypesSmooth.blockID, 1, false);
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 9, 1, 3, 9, 3, RSDecoIntegration.stoneTypesSmooth.blockID, 1, RSDecoIntegration.stoneTypesSmooth.blockID, 1, false);

		this.placeBlockAtCurrentPosition(par1World,Block.waterMoving.blockID, 0, 1, 10, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World,Block.waterMoving.blockID, 0, 2, 10, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World,Block.waterMoving.blockID, 0, 2, 10, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World,Block.waterMoving.blockID, 0, 3, 10, 2, par3StructureBoundingBox);

		//Pillars
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 13, 2, 11, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 12, 2, 12, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 12, 2, 13, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 14, 2, 14, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 13, 0, 11, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 0, 12, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 0, 13, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 0, 14, 0, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 13, 4, 11, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 4, 12, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 4, 13, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 4, 14, 0, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 13, 4, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 4, 12, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 4, 13, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 4, 14, 4, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.andesiteSmoothMouldingandDecorative.blockID, 13, 0, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 0, 12, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 0, 13, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 0, 14, 4, par3StructureBoundingBox);

		//Benches and leaves
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 13, 1, 11, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 12, 1, 12, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 13, 1, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 12, 1, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 13, 3, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 12, 3, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 13, 3, 11, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakMouldingAndDecorative.blockID, 12, 3, 12, 1, par3StructureBoundingBox);

        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 11, 0, 3, 11, 0, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, false);
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 11, 1, 0, 11, 3, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, false);
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 11, 4, 3, 11, 4, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, false);
        this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 11, 1, 4, 11, 3, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, false);
        
        //Awning
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 15, 0, 4, 15, 4, RSDecoIntegration.pergola.blockID, RSDecoIntegration.pergola.blockID, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 15, -1, 4, 15, -1, DecoDefs.trapdoorSpruce.blockID, 1, DecoDefs.trapdoorSpruce.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 15, 5, 4, 15, 5, DecoDefs.trapdoorSpruce.blockID, 0, DecoDefs.trapdoorSpruce.blockID, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, -1, 15, 0, -1, 15, 4, DecoDefs.trapdoorSpruce.blockID, 3, DecoDefs.trapdoorSpruce.blockID, 3, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 15, 0, 5, 15, 4, DecoDefs.trapdoorSpruce.blockID, 2, DecoDefs.trapdoorSpruce.blockID, 2, false);

		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 2, 15, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 3, 15, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 4, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 3, 15, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 2, 15, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 1, 15, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 0, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 1, 15, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 2, 15, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 1, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 2, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 3, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 2, 15, 3, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 1, 2, 16, 2, par3StructureBoundingBox);
		
		//Awning underside
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceMouldingAndDecorative.blockID, 15, 1, 14, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceMouldingAndDecorative.blockID, 15, 2, 14, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceMouldingAndDecorative.blockID, 15, 2, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceMouldingAndDecorative.blockID, 15, 3, 14, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.lanternPaperBroken.blockID, 0, 1, 13, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.lanternPaperBroken.blockID, 0, 2, 13, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.lanternPaperBroken.blockID, 0, 2, 13, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.lanternPaperBroken.blockID, 0, 3, 13, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 8, 2, 14, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 8, 3, 14, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 11, 4, 14, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 9, 3, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 9, 2, 14, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 9, 1, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 10, 0, 14, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, 8, 1, 14, 1, par3StructureBoundingBox);

        return true;
    }
}
