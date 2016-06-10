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

import java.util.regex.Pattern;

@Rule(key = "SEEDSTACK-1",
        name = "SeedStack internal classes should not be used",
        description = "This rule detects usage of any classes located in org.seedstack.**.internal.** packages",
        tags = "seedstack",
        priority = Priority.CRITICAL
)
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.MAINTAINABILITY_COMPLIANCE)
@SqaleConstantRemediation("30min")
public class AvoidInternalCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static Pattern INTERNAL_TYPE_PATTERN = Pattern.compile("^org\\.seedstack.*\\.internal\\..*");

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitIdentifier(IdentifierTree tree) {
        if (tree.symbol().isTypeSymbol()) {
            String fullyQualifiedName = tree.symbolType().fullyQualifiedName();
            if (INTERNAL_TYPE_PATTERN.matcher(fullyQualifiedName).matches()) {
                context.reportIssue(this, tree, String.format("Remove usage of %s", fullyQualifiedName));
            }
        }

        super.visitIdentifier(tree);
    }
}
