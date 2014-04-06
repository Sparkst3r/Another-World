/**
 * Released under Creative Commons 0 as defined by http://creativecommons.org/publicdomain/zero/1.0/
 * TinkersConstruct
 */
package com.sparkst3r.anotherworld.core.plugins;

/**
 * Code from https://github.com/SlimeKnights/TinkersConstruct/tree/master/src/main/java/tconstruct/plugins
 * 
 * Interface for AnotherWorld compat plugins
 *
 * Do not include mod API usage directly in this file except for IMC! This must be constructable even
 * when the target mod isn't available due to Java not allowing static abstracts.
 */
public interface ICompatPlugin {

    /** Mod ID the plugin handles 
     * @return Mod id
     */
    public abstract String getModId();
    
    /** Called during TCon PreInit */
    public abstract void preInit();

    /** Called during TCon Init */
    public abstract void init();

    /** Called during TCon PostInit */
    public abstract void postInit();

}
