package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StructureVillagePieces
{
    public static ArrayList getStructureVillageWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList var2 = new ArrayList();
        var2.add(new StructureVillagePieceWeight(RSComponentVillageHouseSmall.class, 4, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageChurch.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 1 + par1)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageLibrary.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageWoodHut.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageButcher.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageField.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 1 + par1, 4 + par1)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageField2.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageBlacksmith.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0, 1 + par1)));
        var2.add(new StructureVillagePieceWeight(RSComponentVillageHouse.class, 8, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 3 + par1 * 2)));
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            if (((StructureVillagePieceWeight)var3.next()).villagePiecesLimit == 0)
            {
                var3.remove();
            }
        }

        return var2;
    }

    private static int func_75079_a(List par0List)
    {
        boolean var1 = false;
        int var2 = 0;
        StructureVillagePieceWeight var4;

        for (Iterator var3 = par0List.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight)
        {
            var4 = (StructureVillagePieceWeight)var3.next();

            if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit)
            {
                var1 = true;
            }
        }

        return var1 ? var2 : -1;
    }

    private static RSComponentVillage func_75083_a(RSComponentVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeight par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8)
    {
        Class var9 = par1StructureVillagePieceWeight.villagePieceClass;
        Object var10 = null;

        if (var9 == RSComponentVillageHouseSmall.class)
        {
            var10 = RSComponentVillageHouseSmall.func_74912_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageChurch.class)
        {
            var10 = RSComponentVillageChurch.func_74919_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageLibrary.class)
        {
            var10 = RSComponentVillageLibrary.func_74898_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageWoodHut.class)
        {
            var10 = RSComponentVillageWoodHut.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageButcher.class)
        {
            var10 = RSComponentVillageButcher.func_74906_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageField.class)
        {
            var10 = RSComponentVillageField.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageField2.class)
        {
            var10 = RSComponentVillageField2.func_74902_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageBlacksmith.class)
        {
            var10 = RSComponentVillageBlacksmith.func_74915_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == RSComponentVillageHouse.class)
        {
            var10 = RSComponentVillageHouse.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }

        return (RSComponentVillage)var10;
    }

    /**
     * attempts to find a next Village BTAComponent to be spawned
     */
    private static RSComponentVillage getNextVillageComponent(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        int var8 = func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

        if (var8 <= 0)
        {
            return null;
        }
        else
        {
            int var9 = 0;

            while (var9 < 5)
            {
                ++var9;
                int var10 = par2Random.nextInt(var8);
                Iterator var11 = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

                while (var11.hasNext())
                {
                    StructureVillagePieceWeight var12 = (StructureVillagePieceWeight)var11.next();
                    var10 -= var12.villagePieceWeight;

                    if (var10 < 0)
                    {
                        if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        RSComponentVillage var13 = func_75083_a(par0ComponentVillageStartPiece, var12, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (var13 != null)
                        {
                            ++var12.villagePiecesSpawned;
                            par0ComponentVillageStartPiece.structVillagePieceWeight = var12;

                            if (!var12.canSpawnMoreVillagePieces())
                            {
                                par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(var12);
                            }

                            return var13;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = RSComponentVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (var14 != null)
            {
                return new RSComponentVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, var14, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure BTAComponent to be spawned, private Village function
     */
    private static RSComponentVillage getNextVillageStructureComponent(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            RSComponentVillage var8 = getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (var8 != null)
            {
                int var9 = (var8.boundingBox.minX + var8.boundingBox.maxX) / 2;
                int var10 = (var8.boundingBox.minZ + var8.boundingBox.maxZ) / 2;
                int var11 = var8.boundingBox.maxX - var8.boundingBox.minX;
                int var12 = var8.boundingBox.maxZ - var8.boundingBox.minZ;
                int var13 = var11 > var12 ? var11 : var12;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(var9, var10, var13 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var8);
                    par0ComponentVillageStartPiece.field_74932_i.add(var8);
                    return var8;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static RSComponentVillagePathGen getNextComponentVillagePath(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentVillageStartPiece.terrainType)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox var8 = RSComponentVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (var8 != null && var8.minY > 10)
            {
                RSComponentVillagePathGen var9 = new RSComponentVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, var8, par6);
                int var10 = (var9.boundingBox.minX + var9.boundingBox.maxX) / 2;
                int var11 = (var9.boundingBox.minZ + var9.boundingBox.maxZ) / 2;
                int var12 = var9.boundingBox.maxX - var9.boundingBox.minX;
                int var13 = var9.boundingBox.maxZ - var9.boundingBox.minZ;
                int var14 = var12 > var13 ? var12 : var13;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(var10, var11, var14 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var9);
                    par0ComponentVillageStartPiece.field_74930_j.add(var9);
                    return var9;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * attempts to find a next Structure BTAComponent to be spawned
     */
    static StructureComponent getNextStructureComponent(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentVillagePath(RSComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
    
    //Stub methods - used to make code compile, never actually called
    private static RSComponentVillage func_75083_a(ComponentVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeight par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8) {return null;}

    private static RSComponentVillage getNextVillageComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {return null;}

    private static RSComponentVillage getNextVillageStructureComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {return null;}

    private static RSComponentVillagePathGen getNextComponentVillagePath(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {return null;}

    static StructureComponent getNextStructureComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {return null;}

    static StructureComponent getNextStructureComponentVillagePath(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {return null;}
}
