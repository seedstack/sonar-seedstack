/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java;

import org.seedstack.sonar.SeedStackRulesDefinition;
import org.sonar.plugins.java.api.CheckRegistrar;

/**
 * Provide the "checks" (implementations of rules) classes that are gonna be executed during
 * source code analysis.
 */
public class SeedStackCheckRegistrar implements CheckRegistrar {

    @Override
    public void register(RegistrarContext registrarContext) {
        // Call to registerClassesForRepository to associate the classes with the correct repository key
        registrarContext.registerClassesForRepository(
                SeedStackRulesDefinition.REPOSITORY_KEY,
                RulesList.getJavaChecks(),
                RulesList.getJavaTestChecks()
        );
    }
}
