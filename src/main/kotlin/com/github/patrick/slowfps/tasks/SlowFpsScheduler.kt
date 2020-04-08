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

package com.github.patrick.slowfps.tasks

import com.github.patrick.slowfps.process.SlowFpsGame.Companion.slowFpsProjectiles
import com.github.patrick.slowfps.process.SlowFpsGame.Companion.slowFpsTeams
import com.github.patrick.slowfps.process.SlowFpsProcess.stopProcess

class SlowFpsScheduler : Runnable {
    private var rhythmTask: SlowFpsTask? = null

    init {
        rhythmTask = SlowFpsTitleTask()
    }

    /**
     * When an object implementing interface `Runnable` is used
     * to create a thread, starting the thread causes the object's
     * `run` method to be called in that separately executing
     * thread.
     *
     *
     * The general contract of the method `run` is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread.run
     */
    override fun run() {
        slowFpsProjectiles.removeIf { it.dead }
        slowFpsTeams.removeIf { it.dead }
        rhythmTask = rhythmTask?.execute()
        if (rhythmTask == null) stopProcess()
    }
}