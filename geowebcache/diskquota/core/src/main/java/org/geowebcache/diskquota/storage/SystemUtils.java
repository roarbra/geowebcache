/**
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * <p>You should have received a copy of the GNU Lesser General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 *
 * @author Gabriel Roldan (OpenGeo) 2010
 */
package org.geowebcache.diskquota.storage;

import org.springframework.util.Assert;

public class SystemUtils {

    private static SystemUtils INSTANCE = new SystemUtils();

    public static void set(SystemUtils instance) {
        Assert.notNull(instance, "SystemUtils instance must be non null");
        INSTANCE = instance;
    }

    public static SystemUtils get() {
        return INSTANCE;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public int currentTimeMinutes() {
        return (int) (currentTimeMillis() / 1000 / 60);
    }
}
