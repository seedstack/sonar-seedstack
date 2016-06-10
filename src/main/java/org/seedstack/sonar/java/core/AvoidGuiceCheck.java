/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java.core;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

import java.util.HashMap;
import java.util.Map;

@Rule(key = "SEEDSTACK-2",
        name = "Guice classes should not be used when a javax.inject alternative exists",
        description = "This rule detects usage of Guice classes that have standard alternatives",
        tags = "seedstack",
        priority = Priority.MAJOR
)
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.PORTABILITY_COMPLIANCE)
@SqaleConstantRemediation("5min")
public class AvoidGuiceCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static Map<String, String> FORBIDDEN_GUICE_CLASSES = new HashMap<String, String>();
    private JavaFileScannerContext context;

    static {
        FORBIDDEN_GUICE_CLASSES.put("com.google.inject.Provider", "javax.inject.Provider");
        FORBIDDEN_GUICE_CLASSES.put("com.google.inject.Inject", "javax.inject.Inject");
        FORBIDDEN_GUICE_CLASSES.put("com.google.inject.name.Named", "javax.inject.Named");
        FORBIDDEN_GUICE_CLASSES.put("com.google.inject.Singleton", "javax.inject.Singleton");
    }

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitIdentifier(IdentifierTree tree) {
        if (tree.symbol().isTypeSymbol()) {
            String fullyQualifiedName = tree.symbolType().fullyQualifiedName();
            if (FORBIDDEN_GUICE_CLASSES.containsKey(fullyQualifiedName)) {
                context.addIssue(tree, this, String.format("Replace usage of %s with %s", fullyQualifiedName, FORBIDDEN_GUICE_CLASSES.get(fullyQualifiedName)));
            }
        }

        super.visitIdentifier(tree);
    }
}
