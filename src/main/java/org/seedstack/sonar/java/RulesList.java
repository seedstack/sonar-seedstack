/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java;

import com.google.common.collect.ImmutableList;
import org.seedstack.sonar.java.core.AvoidInternalRule;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

public final class RulesList {
    private RulesList() {
    }

    public static List<Class> getChecks() {
        return ImmutableList.<Class>builder()
                .addAll(getJavaChecks())
                .addAll(getJavaTestChecks()).build();
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                .add(AvoidInternalRule.class)
                .build();
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                .build();
    }
}
