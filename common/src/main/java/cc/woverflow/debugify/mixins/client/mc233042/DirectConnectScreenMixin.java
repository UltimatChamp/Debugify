package cc.woverflow.debugify.mixins.client.mc233042;

import cc.woverflow.debugify.fixes.BugFix;
import net.minecraft.client.gui.screen.DirectConnectScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@BugFix(id = "MC-233042", env = BugFix.Env.CLIENT)
@Mixin(DirectConnectScreen.class)
public class DirectConnectScreenMixin {
    @Shadow private TextFieldWidget addressField;

    /**
     * Set setTextFieldFocused to false as it seems to fix the issue
     */
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;setTextFieldFocused(Z)V"))
    private void unfocusTextField(TextFieldWidget instance, boolean focused) {
        this.addressField.setTextFieldFocused(false);
    }
}
