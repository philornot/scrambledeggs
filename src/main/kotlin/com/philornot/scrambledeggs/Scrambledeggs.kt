package com.philornot.scrambledeggs

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

/**
 * Main entrypoint for the Scrambled Eggs mod.
 *
 * Loaded by Fabric Loader on both client and dedicated server during startup.
 * Delegates content registration to dedicated registry objects.
 */
object Scrambledeggs : ModInitializer {

    const val MOD_ID = "scrambledeggs"
    private val logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.initialize()
        logger.info("Scrambled Eggs mod initialized!")
    }
}