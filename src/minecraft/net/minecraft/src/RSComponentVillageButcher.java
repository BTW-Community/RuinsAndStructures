package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class RSComponentVillageButcher extends RSComponentVillage
{
    private int averageGroundLevel = -1;

    public RSComponentVillageButcher(RSComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static RSComponentVillageButcher func_74906_a(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 13, 10, 17, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new RSComponentVillageButcher(par0ComponentVillageStartPiece, par7, par2Random, var8, par6) : null;
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

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 10 - 1, 0);
        }
		
        //Clears space above
        for (int i = 0; i <= 16; i++)
        {
            for (int j = 0; j <= 12; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, 1, i, par3StructureBoundingBox);
            }
        }

		//Foundation
		for (int i = 2; i <= 8; i++)
        {
            for (int j = 2; j <= 10; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, 0, i, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.planks.blockID, 1, j, 0, i, par3StructureBoundingBox);
            }
        }

		for (int i = 9; i <= 14; i++)
        {
            for (int j = 2; j <= 10; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, -1, i, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.dirt.blockID, 1, j, -2, i, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.grass.blockID, 1, j, -1, i, par3StructureBoundingBox);
            }
        }
		
		//Log pillars
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 5, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 4, 5, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 7, 5, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 11, 4, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 7, 5, 3, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 11, 5, 3, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 11, 5, 6, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 5, 9, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 7, 5, 9, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 11, 5, 9, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 5, 5, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 5, 9, par3StructureBoundingBox);
        
        //Base supports
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 1, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 1, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 4, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 4, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 7, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 7, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 11, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 11, 1, 0, par3StructureBoundingBox);
		
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 5, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 9, par3StructureBoundingBox);
		
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 12, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 12, 1, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 12, 0, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 12, 1, 3, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 12, 0, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 12, 1, 6, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 12, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 12, 1, 9, par3StructureBoundingBox);
		
		//Spruce stair lower trim
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 2, 0, 1, 3, 0, 1, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 5, 0, 1, 6, 0, 1, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 8, 0, 9, 10, 0, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 0, 2, 1, 0, 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 0, 6, 1, 0, 8, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 11, 0, 2, 11, 0, 2, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 11, 0, 4, 11, 0, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 11, 0, 7, 11, 0, 8, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 8, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 9, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 10, 0, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 2, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 3, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 4, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 5, 0, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 6, 0, 9, par3StructureBoundingBox);
		
		//Leaf trim
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 1, 1, 3, 1, 1, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 1, 1, 6, 1, 1, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 1, 9, 10, 1, 9, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 1, 2, 1, 1, 4, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 1, 6, 1, 1, 8, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 1, 4, 11, 1, 5, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 1, 7, 11, 1, 8, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		
		//Log cross beams
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 1, 3, 5, 1, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 5, 1, 6, 5, 1, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 5, 3, 10, 5, 3, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 8, 10, 5, 8, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 9, 6, 5, 9, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 5, 9, 10, 5, 9, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 2, 1, 5, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 6, 1, 5, 8, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 5, 4, 11, 5, 5, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 5, 7, 11, 5, 8, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 5, 2, 7, 5, 2, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		
		//Inner cross beams
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 2, 6, 5, 2, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 5, 4, 10, 5, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 2, 2, 5, 8, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 5, 5, 10, 5, 7, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		
		//Walls
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 2, 6, 4, 2, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 2, 2, 4, 8, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 8, 10, 4, 8, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 10, 1, 4, 10, 4, 8, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 4, 10, 4, 4, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		
		//Doors
		if (this.startPiece.GetAbandonmentLevel(par1World) <= 1) {
			this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 9, 1, 4, 0, (BlockDoor) DecoDefs.doorSpruce);
			this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 4, 1, 8, 2, (BlockDoor) DecoDefs.doorSpruce);
		}
		else {
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 1, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 2, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 4, 1, 8, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 4, 2, 8, par3StructureBoundingBox);
		}
		//Back awning
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 3, 1, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 3, 2, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 5, 1, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 5, 2, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 3, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 4, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 5, 3, 9, par3StructureBoundingBox);
		
		//Wall arches
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 2, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 6, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 8, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 10, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 7, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 1, 7, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 8, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 10, 4, 3, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 2, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 6, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 8, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 10, 4, 9, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 1, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 1, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 1, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 1, 4, 8, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 11, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 11, 4, 8, par3StructureBoundingBox);
		
		//Wall arch trapdoors
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 3, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 5, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 6, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 6, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 2, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 9, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 1, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 9, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 1, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 1, 3, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 3, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 5, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 6, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 6, 2, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 6, 1, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 2, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 1, 9, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 9, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 10, 2, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 2, 9, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 1, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 2, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 2, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 1, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 3, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 2, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 3, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 2, 6, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 11, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 11, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 11, 3, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 11, 2, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 11, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 11, 2, 4, par3StructureBoundingBox);
		
		//Front porch
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 9, 5, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 10, 5, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 11, 5, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1), 9, 5, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1), 10, 5, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1), 11, 5, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3), 12, 5, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.gateSpruce.blockID, this.getMetadataWithOffset(DecoDefs.gateSpruce.blockID, 1), 11, 1, 2, par3StructureBoundingBox);
		
		//Roof faces
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 6, 1, 4, 8, 1, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 2, 6, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 6, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 7, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 6, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 5, 6, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 5, 7, 1, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 0, 6, 5, 0, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 6, 9, 4, 8, 9, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 2, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 7, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 5, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 5, 7, 9, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 10, 6, 5, 10, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 6, 6, 11, 8, 6, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 6, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 6, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 7, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 6, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 6, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 11, 7, 7, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 12, 5, 4, 12, 5, 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, false);
		
		//Ceiling
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 6, 3, 3, 6, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 6, 3, 5, 6, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 6, 7, 5, 6, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 5, 9, 6, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 7, 9, 6, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, false);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 7, 5, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, 6, 5, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, 6, 5, 4, par3StructureBoundingBox);
		
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 6, 2, 6, 6, 2, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 6, 2, 2, 6, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 6, 8, 10, 6, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 6, 4, 10, 6, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 4, 10, 6, 4, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 2, 6, 6, 4, Block.planks.blockID, 1, Block.planks.blockID, 1, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 7, 2, 5, 7, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 7, 5, 10, 7, 7, Block.planks.blockID, 1, Block.planks.blockID, 1, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 8, 2, 4, 8, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 8, 6, 10, 8, 6, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		
		//Roof
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 0, 5, 10, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 1, 5, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 1, 5, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 6, 1, 1, 6, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 1, 6, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 1, 6, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 2, 6, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 2, 6, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 7, 1, 2, 7, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 2, 7, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 2, 7, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 3, 7, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 3, 7, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 8, 1, 3, 8, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 3, 8, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 3, 8, 10, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 5, 0, 8, 5, 2, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 8, 5, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 7, 5, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 7, 5, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 6, 1, 7, 6, 3, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 6, 9, 7, 6, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 7, 6, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 7, 6, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 6, 6, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 6, 6, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 7, 1, 6, 7, 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 7, 8, 6, 7, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 6, 7, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 6, 7, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 5, 7, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 5, 7, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 8, 1, 5, 8, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 8, 7, 5, 8, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 5, 8, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 5, 8, 10, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 4, 8, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 4, 8, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 4, 9, -1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 4, 9, 11, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 9, 0, 4, 9, 10, Block.planks.blockID, 5, Block.planks.blockID, 5, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 5, 2, 12, 5, 2, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 12, 5, 3, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 6, 3, 11, 6, 3, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 12, 6, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 12, 6, 4, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 7, 4, 11, 7, 4, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 12, 7, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 12, 7, 5, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 8, 5, 11, 8, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 12, 8, 5, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 5, 10, 12, 5, 10, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 12, 5, 9, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 6, 9, 11, 6, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 12, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 12, 6, 8, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 7, 8, 11, 7, 8, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 12, 7, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 12, 7, 7, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 8, 7, 11, 8, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 12, 8, 7, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 12, 8, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 13, 9, 6, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 9, 6, 12, 9, 6, Block.planks.blockID, 5, Block.planks.blockID, 5, false);

		//Roof under rim
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 10, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 8, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 8, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 9, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 11, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 12, 4, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 8, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 9, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 11, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 12, 4, 10, par3StructureBoundingBox);

		//Back garden
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 2, 15, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 6, 2, 15, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 11, 2, 15, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, -1, 10, 1, -1, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, -1, 10, 11, -1, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, -1, 15, 5, -1, 15, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, -1, 15, 10, -1, 15, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);

		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 1, 0, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 1, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 2, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 1, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 1, 0, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 1, 0, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 1, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 1, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 2, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 11, 0, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 11, 1, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 11, 2, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 11, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 11, 0, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 11, 0, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 11, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 11, 1, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 11, 2, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 2, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 2, 1, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 2, 2, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 3, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 4, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 5, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 5, 1, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 5, 2, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 7, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 7, 1, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 7, 2, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 8, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.hedgeOakSidingAndCorner.blockID, 14, 9, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 10, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 10, 1, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 10, 2, 15, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 3, 10, 11, 3, 15, DecoDefs.pergola.blockID, 0, DecoDefs.pergola.blockID, 0, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 3, 10, 9, 3, 13, 0, 0, false);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs. barkLog.blockID, 0, 1, 3, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs. barkLog.blockID, 0, 6, 3, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs. barkLog.blockID, 0, 11, 3, 15, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 3, 9, 0, 3, 15, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2), DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 12, 3, 9, 12, 3, 15, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3), DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 3, 16, 11, 3, 16, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0), DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0), false);
		
		//Garden decorations
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, -1, 10, 4, -1, 12, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, -1, 13, 4, -1, 14, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, -1, 12, 8, -1, 12, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, -1, 11, 10, -1, 12, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 3, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 4, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 2, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 5, 0, 14, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 10, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 10, 0, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 10, 0, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 10, 0, 13, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.cobblestoneWall.blockID, 0, 7, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 7, 1, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 7, 2, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 7, 3, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 12, 7, 3, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.lanternPaperBroken.blockID, 0, 7, 2, 12, par3StructureBoundingBox);
		
		//Inside
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 0, 3, 7, 0, 4, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 1, 3, 6, 1, 3, DecoDefs.stoneTypesSmooth.blockID, 1, DecoDefs.stoneTypesSmooth.blockID, 1, false);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 1, 3, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, 6, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, 6, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, 7, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, this.getMetadataWithOffset(Block.wood.blockID, 9), 7, 4, 4, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.gateSpruce.blockID, this.getMetadataWithOffset(DecoDefs.gateSpruce.blockID, 0), 3, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 4, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 8, 5, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 6, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 7, 1, 5, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 8, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 8, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 8, 3, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.pergola.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 9, 3, 5, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 6, 1, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 7, 1, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 6, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 7, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 5, 1, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 5, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 5, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 1, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 8, 3, 7, par3StructureBoundingBox);
		
		//Windows
		if (this.startPiece.GetAbandonmentLevel(par1World) == 0) {
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 3, 2, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 3, 3, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 5, 2, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 5, 3, 2, par3StructureBoundingBox);
			
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 2, 2, 3, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 2, 3, 3, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 2, 2, 7, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 2, 3, 7, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 9, 2, 8, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.glassStained.blockID, 3, 9, 3, 8, par3StructureBoundingBox);
		}
		else {
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 2, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 3, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 5, 2, 2, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 5, 3, 2, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 2, 3, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 3, 3, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 2, 7, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 3, 7, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 2, 8, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 3, 8, par3StructureBoundingBox);
		}
		
        this.spawnVillagers(par1World, par3StructureBoundingBox, 4, 1, 2, 2);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int par1)
    {
        return par1 == 0 ? 4 : 0;
    }
}
