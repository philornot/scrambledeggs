package com.philornot.scrambledeggs

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item

/**
 * Central registry for all custom items added by the Scrambled Eggs mod.
 *
 * Items are registered during mod initialization via [initialize].
 */
object ModItems {

        /**
         * Scrambled eggs — a food item crafted from 3 eggs in any arrangement.
         *
         * Restores 5 hunger points (2.5 drumsticks) with moderate saturation,
         * comparable to vanilla cooked chicken.
         */
    val SCRAMBLED_EGGS: Item = register("scrambled_eggs") { properties ->
        Item(
            properties.food(
                FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.6f)
                    .build()
            ).component(
                net.minecraft.core.component.DataComponents.CONSUMABLE,
                net.minecraft.world.item.component.Consumable.builder().build()
            )
        )
    }

    /**
     * Registers an [Item] to the game's item registry under the mod's namespace.
     *
     * The [factory] receives pre-configured [Item.Properties] with the registry
     * key already set, as required since Minecraft 1.21.2+.
     *
     * @param name the registry path for the item, e.g. `"scrambled_eggs"`
     * @param factory lambda that receives [Item.Properties] and returns an [Item]
     * @return the registered [Item] instance
     */
    private fun register(name: String, factory: (Item.Properties) -> Item): Item {
        val id = Identifier.fromNamespaceAndPath(Scrambledeggs.MOD_ID, name)
        val key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id)
        val properties = Item.Properties().setId(key)
        return Registry.register(BuiltInRegistries.ITEM, key, factory(properties))
    }

    /**
     * Triggers static initialization of all items in this object.
     *
     * Call this from [Scrambledeggs.onInitialize] to ensure items are
     * registered before the game processes recipes and other data.
     */
    fun initialize() {
        SCRAMBLED_EGGS.let { }
    }
}