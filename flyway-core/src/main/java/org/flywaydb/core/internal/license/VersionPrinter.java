/*
 * Copyright © Red Gate Software Ltd 2010-2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.license;

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.logging.Log;
import org.flywaydb.core.api.logging.LogFactory;
import org.flywaydb.core.extensibility.FlywayExtension;
import org.flywaydb.core.internal.util.DateUtils;
import org.flywaydb.core.internal.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.ServiceLoader;

import static java.time.temporal.ChronoUnit.DAYS;

public class VersionPrinter {
    private static final Log LOG = LogFactory.getLog(VersionPrinter.class);
    public static ClassLoader classLoader = VersionPrinter.class.getClassLoader();
    private static final String version = readVersion();

    public static final Edition EDITION =

            Edition.COMMUNITY







            ;

    private VersionPrinter() { }

    public static String getVersion() {
        return version;
    }

    public static void printVersion(



    ) {

        printVersionOnly();







    }

    public static void printVersionOnly() {
        LOG.info(EDITION + " " + version + " by Redgate");
        printExtensionVersions();
    }

    private static void printExtensionVersions() {
        ServiceLoader<FlywayExtension> loader = ServiceLoader.load(FlywayExtension.class, classLoader);
        for (FlywayExtension extension : loader) {
            LOG.info( ">\t" + extension.getDescription());
        }
    }






































    private static String readVersion() {
        try {
            return FileCopyUtils.copyToString(
                    VersionPrinter.class.getClassLoader().getResourceAsStream("org/flywaydb/core/internal/version.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FlywayException("Unable to read Flyway version: " + e.getMessage(), e);
        }
    }
}