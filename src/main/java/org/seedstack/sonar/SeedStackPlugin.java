/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar;

import org.seedstack.sonar.java.SeedStackCheckRegistrar;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * Entry point of Sonar SeedStack plugin.
 */
public class SeedStackPlugin extends SonarPlugin {

    @Override
    public List getExtensions() {
        return Arrays.asList(
                // server extensions -> objects are instantiated during server startup
                SeedStackRulesDefinition.class,

                // batch extensions -> objects are instantiated during code analysis
                SeedStackCheckRegistrar.class);
    }
}
