/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar;

import org.seedstack.sonar.java.RulesList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

/**
 * Declare rule metadata in server repository of rules.
 * That allows to list the rules in the page "Rules".
 */
public class SeedStackRulesDefinition implements RulesDefinition {
    public static final String REPOSITORY_KEY = "seedstack";
    private static final String JAVA_KEY = "java";

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, JAVA_KEY);
        repository.setName("SeedStack");

        AnnotationBasedRulesDefinition.load(repository, JAVA_KEY, RulesList.getChecks());
        repository.done();
    }
}
