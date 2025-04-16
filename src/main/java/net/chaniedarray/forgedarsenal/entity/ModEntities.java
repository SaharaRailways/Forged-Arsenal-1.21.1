package net.chaniedarray.forgedarsenal.entity;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.entity.custom.DaggerProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DaggerProjectileEntity> IRON_DAGGER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ForgedArsenal.MOD_ID, "iron_dagger"),
            EntityType.Builder.<DaggerProjectileEntity>create(DaggerProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());
    public static final EntityType<DaggerProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ForgedArsenal.MOD_ID, "tomahawk"),
            EntityType.Builder.<DaggerProjectileEntity>create(DaggerProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());

    public static void registerModEntities() {
        ForgedArsenal.LOGGER.info("Registering Mod Entities for " + ForgedArsenal.MOD_ID);

    }
}
