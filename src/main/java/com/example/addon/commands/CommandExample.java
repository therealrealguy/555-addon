//this was made by chat gpt it most likely does not work
package com.example.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import meteordevelopment.meteorclient.utils.player.ChatUtils;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CommandExample extends Command {
    public CommandExample() {
        super("example", "Sends a message.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            // Send a message to the player who executed the command
            sendChatMessage(context.getSource(), "Hello, world!");
            return SINGLE_SUCCESS;
        });
    }
    
    private void sendChatMessage(CommandSource source, String message) {
        source.sendFeedback(new LiteralText(message), false);
    }

    // Intercept incoming chat messages
    public static void onChatMessage(Text message) {
        String messageText = message.getString();
        if (messageText.equalsIgnoreCase("hi")) {
            // Send a reply of "hello" to the chat
            ChatUtils.sendMessage("hello");
        }
    }
}
