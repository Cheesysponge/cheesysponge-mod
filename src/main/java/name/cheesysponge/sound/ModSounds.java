package name.cheesysponge.sound;

import name.cheesysponge.SpongeMod;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent SPONGE_ROD_FOUND_BLOCK = registerSoundEvent("sponge_rod_found_block");
    public static SoundEvent CHEESY_SPONGE_LAMP_BREAK = registerSoundEvent("cheesy_sponge_lamp_break");
    public static SoundEvent CHEESY_SPONGE_LAMP_STEP = registerSoundEvent("cheesy_sponge_lamp_step");
    public static SoundEvent CHEESY_SPONGE_LAMP_PLACE = registerSoundEvent("cheesy_sponge_lamp_place");
    public static SoundEvent CHEESY_SPONGE_LAMP_HIT = registerSoundEvent("cheesy_sponge_lamp_hit");
    public static SoundEvent CHEESY_SPONGE_LAMP_FALL = registerSoundEvent("cheesy_sponge_lamp_fall");
    public static SoundEvent HYPE_MUSIC = registerSoundEvent("hype_music");
    public static final BlockSoundGroup CHEESY_SPONGE_SOUNDS = new BlockSoundGroup(1f, 1f,
            ModSounds.CHEESY_SPONGE_LAMP_BREAK, ModSounds.CHEESY_SPONGE_LAMP_STEP, ModSounds.CHEESY_SPONGE_LAMP_PLACE,
            ModSounds.CHEESY_SPONGE_LAMP_HIT, ModSounds.CHEESY_SPONGE_LAMP_FALL);
    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(SpongeMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent((id)));
    }

}
