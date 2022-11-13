package fr.dirzii.monplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerConnection  implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

        final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("Général", "dummy");

        objective.setDisplayName(ChatColor.GOLD + "DEYLOS");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        final Score datescore = objective.getScore(ChatColor.GRAY + format.format(date));
        final Score pseudo = objective.getScore(ChatColor.WHITE + "Pseudo : " + ChatColor.AQUA + p.getName());
        final Score espace = objective.getScore("                 ");
        final Score espace2 = objective.getScore("");

        final Score grade = objective.getScore(ChatColor.WHITE + "Grade : " + ChatColor.GRAY + "Joueur");
        final Score site = objective.getScore(ChatColor.YELLOW + "www.deylos.fr");

        datescore.setScore(5);
        espace.setScore(4);
        pseudo.setScore(3);
        grade.setScore(2);
        espace2.setScore(1);
        site.setScore(0);

        p.setScoreboard(scoreboard);


    }
}
