package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class RSComponentVillageLibrary extends RSComponentVillage
{
    private int averageGroundLevel = -1;

    public RSComponentVillageLibrary(RSComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static RSComponentVillageLibrary func_74898_a(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 15, 16, 16, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new RSComponentVillageLibrary(par0ComponentVillageStartPiece, par7, par2Random, var8, par6) : null;
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

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 16 - 1, 0);
        }
		
        //Clears space above
        for (int i = 0; i <= 15; i++)
        {
            for (int j = 0; j <= 14; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, 1, i, par3StructureBoundingBox);
            }
        }

		//Foundation
		for (int i = 2; i <= 13; i++)
        {
            for (int j = 2; j <= 12; j++)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, j, 0, i, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.planks.blockID, 1, j, 0, i, par3StructureBoundingBox);
            }
        }

		//Log pillars
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 4, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 5, 4, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 9, 4, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 13, 4, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 10, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 5, 10, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 9, 10, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 13, 4, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 10, 8, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 9, 10, 8, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 13, 5, 8, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 10, 11, par3StructureBoundingBox);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 9, 6, 11, 9, 10, 11, Block.wood.blockID, Block.wood.blockID, false);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 13, 5, 11, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 1, 10, 14, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 5, 10, 14, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 9, 10, 14, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, Block.wood.blockID, 0, 13, 5, 14, par3StructureBoundingBox);
        
        //Base supports
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 1, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 1, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 5, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 5, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 9, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 9, 1, 0, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 13, 0, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 13, 1, 0, par3StructureBoundingBox);

        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 1, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 1, 1, 15, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 5, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 5, 1, 15, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 9, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 9, 1, 15, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 13, 0, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 13, 1, 15, par3StructureBoundingBox);

        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 8, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 11, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 0, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 1, 14, par3StructureBoundingBox);

        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 14, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 14, 1, 1, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 14, 0, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 14, 1, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 14, 0, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 14, 1, 8, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 14, 0, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 14, 1, 11, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, 1, 14, 0, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 14, 1, 14, par3StructureBoundingBox);

		//Spruce stair lower trim
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 0, 2, 1, 0, 3, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 0, 1, 4, 0, 1, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 0, 1, 12, 0, 1, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 0, 2, 13, 0, 3, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 0, 5, 13, 0, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 0, 0, false);

		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 13, 0, 9, 13, 0, 10, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 13, 0, 12, 13, 0, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 0, 5, 1, 0, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 0, 9, 1, 0, 10, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 0, 12, 1, 0, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 2, 0, 14, 4, 0, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 6, 0, 14, 8, 0, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4);
		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 10, 0, 14, 12, 0, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4);

		//Leaf trim
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 1, 9, 13, 1, 10, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 1, 12, 13, 1, 13, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 1, 1, 7, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 1, 9, 1, 1, 10, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 1, 12, 1, 1, 13, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 1, 14, 4, 1, 14, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 1, 14, 8, 1, 14, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 1, 14, 12, 1, 14, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 1, 4, 4, 1, 4, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 1, 5, 9, 1, 7, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 1, 8, 12, 1, 8, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);

		//Log cross beams
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 4, 4, 5, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 5, 4, 8, 5, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 5, 5, 9, 5, 7, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 5, 8, 12, 5, 8, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 5, 9, 13, 5, 10, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 5, 12, 13, 5, 13, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 14, 4, 5, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 5, 14, 8, 5, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 5, 14, 12, 5, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 5, 1, 5, 7, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 9, 1, 5, 10, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 12, 1, 5, 13, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		
		//Upper log cross beams
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 10, 4, 4, 10, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 10, 4, 8, 10, 4, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 10, 5, 9, 10, 7, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 10, 9, 9, 10, 10, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 10, 12, 9, 10, 13, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 10, 14, 4, 10, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 10, 14, 8, 10, 14, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 4), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 10, 5, 1, 10, 7, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 10, 9, 1, 10, 10, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 10, 12, 1, 10, 13, Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), Block.wood.blockID, this.getMetadataWithOffset(Block.wood.blockID, 8), false);
		
		//Walls
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 5, 8, 4, 5, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 5, 8, 4, 7, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 5, 2, 4, 13, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 13, 12, 4, 13, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 12, 1, 9, 12, 4, 13, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 10, 1, 9, 12, 4, 9, DecoDefs.barkLogStripped.blockID, DecoDefs.barkLogStripped.blockID, false);

		this.fillWithMetadataBlocksIfEmpty(par1World, par3StructureBoundingBox, 1, 6, 4, 9, 10, 14, DecoDefs.barkLogStripped.blockID, 0);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 6, 5, 8, 10, 13, 0, 0, false);
		
		//Floor
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 5, 8, 5, 13, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 5, 9, 12, 5, 13, Block.planks.blockID, 1, Block.planks.blockID, 1, false);

		//Wall arches
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 2, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 4, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 6, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 8, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 10, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 12, 4, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 2, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 4, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 6, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 8, 4, 4, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 10, 4, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 12, 4, 8, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 2, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 4, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 6, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 8, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 10, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 12, 4, 14, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 1, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 1, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 1, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 1, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 1, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 1, 4, 13, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 9, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 9, 4, 7, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 13, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 13, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 13, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 13, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 13, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3) + 4, 13, 4, 13, par3StructureBoundingBox);

		//Wall arch trapdoors
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 3, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 2, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 7, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 1, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 11, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 2, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 2, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 3, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 2, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 2, 4, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 7, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 2, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 3, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 2, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 1, 4, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 11, 4, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 3, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 2, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 3, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 2, 8, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 3, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 4, 2, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 2, 2, 14, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 7, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 8, 2, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 6, 2, 14, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 11, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 12, 2, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 3, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 2, 14, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 2, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 1, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 3, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 2, 5, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 1, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 1, 4, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 3, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 1, 2, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 1, 2, 9, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 9, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 9, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 9, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 9, 3, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 9, 2, 5, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 2, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 13, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 3, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 2, 5, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 13, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 8, 13, 4, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 3, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 13, 2, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 3, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 13, 2, 9, par3StructureBoundingBox);
		
		//Patio
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 1, 1, 5, 3, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 5, 1, 13, 5, 1, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 5, 1, 13, 5, 7, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 2, 12, 5, 2, Block.woodSingleSlab.blockID, 9, Block.woodSingleSlab.blockID, 9, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 12, 5, 3, 12, 5, 7, Block.woodSingleSlab.blockID, 9, Block.woodSingleSlab.blockID, 9, false);

		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 5, 5, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2) + 4, 9, 5, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 12, 5, 4, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 5, 3, 11, 5, 3, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 8, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 5, 4, 11, 5, 7, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, false);
		
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 6, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 7, 0, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 8, 0, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 1, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 1, 1, 3, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 2, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.gateSpruce.blockID, this.getMetadataWithOffset(DecoDefs.gateSpruce.blockID, 0), 3, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 4, 1, 1, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 10, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.gateSpruce.blockID, this.getMetadataWithOffset(DecoDefs.gateSpruce.blockID, 0), 11, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 12, 1, 1, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 13, 1, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 13, 1, 3, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 13, 1, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.gateSpruce.blockID, this.getMetadataWithOffset(DecoDefs.gateSpruce.blockID, 1), 13, 1, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodSpruceSidingAndCorner.blockID, 14, 13, 1, 7, par3StructureBoundingBox);
		
		//Door
		if (this.startPiece.GetAbandonmentLevel(par1World) <= 1) {
			this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 7, 1, 5, 2, (BlockDoor) RSDecoIntegration.doorSpruce);
		}
		else {
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 1, 5, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 2, 5, par3StructureBoundingBox);
		}
		
		//Patio roof
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 14, 5, 0, DecoDefs.woodSlab.blockID, 0, DecoDefs.woodSlab.blockID, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 14, 5, 0, 14, 5, 6, DecoDefs.woodSlab.blockID, 0, DecoDefs.woodSlab.blockID, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 5, 1, 0, 5, 14, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 5, 15, 14, 5, 15, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 12, 6, 2, 12, 6, 7, Block.woodSingleSlab.blockID, 1, Block.woodSingleSlab.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 6, 2, 1, 6, 3, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 6, 2, 11, 6, 2, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 6, 3, 11, 6, 7, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 6, 3, 8, 6, 3, Block.grass.blockID, Block.grass.blockID, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 6, 3, 10, 6, 3, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 6, 4, 10, 6, 8, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		
		//Lower roof face
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 13, 6, 11, 13, 8, 11, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 6, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 6, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 7, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 6, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 6, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 13, 7, 12, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 14, 5, 9, 14, 5, 13, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, false);
		
		//Lower roof
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 6, 9, 12, 6, 13, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 7, 10, 12, 7, 12, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 8, 11, 12, 8, 11, Block.planks.blockID, 1, Block.planks.blockID, 1, false);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 14, 5, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 14, 5, 8, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 11, 6, 8, 13, 6, 8, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 14, 6, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 14, 6, 9, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 7, 9, 13, 7, 9, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 14, 7, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2) + 4, 14, 7, 10, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 8, 10, 13, 8, 10, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 3), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3), 14, 8, 10, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 14, 5, 14, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 6, 14, 13, 6, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 14, 6, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 14, 6, 13, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 7, 13, 13, 7, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 14, 7, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 3) + 4, 14, 7, 12, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 8, 12, 13, 8, 12, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 2), 14, 8, 12, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 9, 11, 14, 9, 11, Block.planks.blockID, 5, Block.planks.blockID, 5, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 14, 8, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 15, 9, 11, par3StructureBoundingBox);
		
		//Lower roof under rim
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 1, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 2, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 3, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 4, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 5, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 6, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 7, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 8, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 9, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 11, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 12, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, 13, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 0, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 1, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 2, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 3, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 4, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 5, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 6, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 7, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 8, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 9, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 11, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 12, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, 13, 4, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 15, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 0, 4, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 4, 15, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 14, 4, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 14, 4, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 14, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 14, 4, 15, par3StructureBoundingBox);
		
		//Upper level details
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 9, 3, 4, 9, 3, DecoDefs.pergola.blockID, DecoDefs.pergola.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 9, 3, 8, 9, 3, DecoDefs.pergola.blockID, DecoDefs.pergola.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 9, 15, 4, 9, 15, DecoDefs.pergola.blockID, DecoDefs.pergola.blockID, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 9, 15, 8, 9, 15, DecoDefs.pergola.blockID, DecoDefs.pergola.blockID, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 6, 5, 0, 6, 7, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 6, 9, 0, 6, 10, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 6, 12, 0, 6, 13, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 6, 15, 4, 6, 15, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 15, 8, 6, 15, Block.leaves.blockID, 12, Block.leaves.blockID, 12, false);
		
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 2, 7, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 2, 8, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 8, 7, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 8, 8, 3, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 2, 7, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 2, 8, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 8, 7, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 8, 8, 15, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 7, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 8, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 7, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 8, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 7, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 12, 0, 8, 13, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 7, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 10, 8, 5, par3StructureBoundingBox);
		
		//Upper roof faces
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 11, 4, 5, 14, 4, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, this.getMetadataWithOffset(DecoDefs.strippedLog.blockID, 5), 4, 13, 4, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, this.getMetadataWithOffset(DecoDefs.strippedLog.blockID, 5), 6, 13, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 2, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 12, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 4, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 4, 12, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 8, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 7, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 7, 12, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 11, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 12, 4, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 10, 3, 8, 10, 3, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 1) + 8, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 11, 14, 5, 14, 14, DecoDefs.strippedLog.blockID, 1, DecoDefs.strippedLog.blockID, 1, false);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, this.getMetadataWithOffset(DecoDefs.strippedLog.blockID, 5), 4, 13, 14, par3StructureBoundingBox);
        this.fillCurrentPositionBlocksDownwards(par1World, DecoDefs.strippedLog.blockID, this.getMetadataWithOffset(DecoDefs.strippedLog.blockID, 5), 6, 13, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 2, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 3, 12, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 4, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 4, 12, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 8, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 7, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 7, 12, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 11, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.barrelEmpty.blockID, 1, 6, 12, 14, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 10, 15, 8, 10, 15, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 0) + 8, false);
		
		//Ceiling
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 11, 5, 2, 11, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 12, 5, 3, 12, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 13, 5, 4, 13, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 0, 0, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 11, 5, 8, 11, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 12, 5, 7, 12, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 13, 5, 6, 13, 13, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0) + 4, 0, 0, false);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 14, 4, 5, 14, 14, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
		
		//Upper roof
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 0, 10, 3, 0, 10, 15, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 1, 10, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 1, 10, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 1, 11, 4, 1, 11, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 1, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 2, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 1, 11, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 2, 11, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 2, 12, 4, 2, 12, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 2, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 3, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 2, 12, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 3, 12, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 13, 4, 3, 13, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 3, 13, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 4, 13, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 3, 13, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1) + 4, 4, 13, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 4, 14, 4, 4, 14, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 4, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0), 4, 14, 15, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 10, 10, 3, 10, 10, 15, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 9, 10, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 9, 10, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 9, 11, 4, 9, 11, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 9, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 8, 11, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 9, 11, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 8, 11, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 12, 4, 8, 12, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 8, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 7, 12, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 8, 12, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 7, 12, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 7, 13, 4, 7, 13, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 7, 13, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 6, 13, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 7, 13, 15, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 0) + 4, 6, 13, 15, par3StructureBoundingBox);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 14, 4, 6, 14, 14, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 6, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(DecoDefs.cherryStairs.blockID, 1), 6, 14, 15, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 15, 3, 5, 15, 15, Block.planks.blockID, 5, Block.planks.blockID, 5, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(RSDecoIntegration.cherryStairs.blockID, 3) + 4, 5, 15, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(RSDecoIntegration.cherryStairs.blockID, 3) + 4, 5, 14, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(RSDecoIntegration.cherryStairs.blockID, 2) + 4, 5, 15, 16, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.cherryStairs.blockID, this.getMetadataWithOffset(RSDecoIntegration.cherryStairs.blockID, 2) + 4, 5, 14, 15, par3StructureBoundingBox);
		
		//Upper roof under rim
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 3) + 8, 0, 9, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 0, 9, 15, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 10, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorCherry.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorCherry.blockID, 2) + 8, 10, 9, 14, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.woodSlab.blockID, 8, 10, 9, 15, par3StructureBoundingBox);
		
		//Windows
		if (this.startPiece.GetAbandonmentLevel(par1World) == 0) {
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 2, 5, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 3, 5, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 11, 2, 9, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 11, 3, 9, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 3, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 3, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 11, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 11, 3, 13, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 2, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 3, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 2, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 3, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 2, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 2, 3, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 12, 2, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 12, 3, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 12, 2, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 12, 3, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 7, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 8, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 7, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 8, 4, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 7, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 3, 8, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 7, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 7, 8, 14, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 7, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 8, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 7, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 8, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 7, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 1, 8, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 9, 7, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, DecoDefs.glassStained.blockID, 3, 9, 8, 6, par3StructureBoundingBox);
		}
		else {
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 2, 5, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 3, 5, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 11, 2, 9, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 11, 3, 9, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 3, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 3, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 11, 2, 13, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 11, 3, 13, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 2, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 3, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 2, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 3, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 2, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 2, 3, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 12, 2, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 12, 3, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 12, 2, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 12, 3, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 7, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 8, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 7, 4, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 8, 4, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 7, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 3, 8, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 7, 14, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 7, 8, 14, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 7, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 8, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 7, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 8, 10, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 7, 12, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 8, 12, par3StructureBoundingBox);

			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 7, 6, par3StructureBoundingBox);
			this.placeBlockAtCurrentPosition(par1World, 0, 0, 9, 8, 6, par3StructureBoundingBox);
		}
		
		//Inside 1st floor
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 3, 12, 11, 3, 12, Block.woodSingleSlab.blockID, 8, 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 0, 3, 4, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, this.getMetadataWithOffset(Block.stairsWoodOak.blockID, 3) + 4, 3, 4, 11, par3StructureBoundingBox);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 4, 12, 10, 4, 12, Block.bookShelf.blockID, 0, false);
		this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 0, 11, 4, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, this.getMetadataWithOffset(Block.stairsWoodOak.blockID, 3) + 4, 11, 4, 11, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 5, 1, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 3) + 2, 4, 1, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 2) + 2, 6, 1, 12, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 9, 1, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 3) + 2, 8, 1, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 2) + 2, 10, 1, 12, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 8, 1, 9, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 0) + 2, 8, 1, 8, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 2) + 2, 9, 1, 9, par3StructureBoundingBox);

		this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 5, 6, 8, 5, 6, 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 4, 5, 6, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 4, 1, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 5, 1, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 5, 2, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 6, 2, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 6, 3, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1) + 4, 7, 3, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 7, 4, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 0), 8, 5, 6, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 4, 1, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 4, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 5, 2, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 5, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 6, 3, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 6, 4, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 7, 4, 7, par3StructureBoundingBox);
		
		//Inside 2nd floor
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 6, 5, 5, 6, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 1), 0, 0, false);
		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 6, 6, 5, 8, 6, 5, Block.stairsWoodSpruce.blockID, this.getMetadataWithOffset(Block.stairsWoodSpruce.blockID, 2), 0, 0, false);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 3) + 12, 5, 6, 6, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 5, 6, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 6, 6, 7, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 0) + 12, 7, 6, 7, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 2, 6, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 3, 6, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 4, 6, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, RSDecoIntegration.oakWoodChair.blockID, this.getMetadataWithOffset(RSDecoIntegration.trapdoorCherry.blockID, 1) + 2, 3, 6, 6, par3StructureBoundingBox);

		this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 3, 6, 8, 7, 6, 10, RSDecoIntegration.carpet.blockID, 6, RSDecoIntegration.carpet.blockID, 6, false);

		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 2, 6, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative.blockID, 15, 5, 6, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.bed.blockID, this.getMetadataWithOffset(Block.bed.blockID, 2), 3, 6, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.bed.blockID, this.getMetadataWithOffset(Block.bed.blockID, 2) + 8, 3, 6, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.bed.blockID, this.getMetadataWithOffset(Block.bed.blockID, 2), 4, 6, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.bed.blockID, this.getMetadataWithOffset(Block.bed.blockID, 2) + 8, 4, 6, 13, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 9, 8, 6, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 9, 8, 6, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 8, 7, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 8, 7, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 8, 8, 12, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 2) + 8, 8, 8, 13, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 8, 6, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 8, 7, 11, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, DecoDefs.trapdoorSpruce.blockID, this.getMetadataWithOffset(DecoDefs.trapdoorSpruce.blockID, 1) + 12, 8, 8, 11, par3StructureBoundingBox);
		
        this.spawnVillagers(par1World, par3StructureBoundingBox, 2, 1, 2, 1);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int par1)
    {
        return 1;
    }
}
