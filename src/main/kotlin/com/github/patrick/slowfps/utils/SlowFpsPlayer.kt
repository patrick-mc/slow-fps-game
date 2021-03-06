/*
 * Copyright (C) 2020 PatrickKR
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * Contact me on <mailpatrickkr@gmail.com>
 */

package com.github.patrick.slowfps.utils

import org.bukkit.GameMode.ADVENTURE
import org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH
import org.bukkit.entity.Player

/**
 * This class represents the game player of this plugin.
 */
class SlowFpsPlayer(val player: Player, val team: SlowFpsTeam) {
    /**
     * This sets the player's gameMode to adventure and sets the health to max.
     */
    fun prepare() {
        player.gameMode = ADVENTURE
        player.health = player.getAttribute(GENERIC_MAX_HEALTH).baseValue
    }
}