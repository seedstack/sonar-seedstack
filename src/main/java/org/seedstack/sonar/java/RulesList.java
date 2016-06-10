/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java;

import org.seedstack.sonar.java.core.AvoidGuiceCheck;
import org.seedstack.sonar.java.core.AvoidInternalCheck;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.ArrayList;
import java.util.List;

public final class RulesList {
    private RulesList() {
    }

    public static List<Class> getChecks() {
        ArrayList<Class> classes = new ArrayList<Class>();
        classes.addAll(getJavaChecks());
        classes.addAll(getJavaTestChecks());
        return classes;
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        ArrayList<Class<? extends JavaCheck>> classes = new ArrayList<Class<? extends JavaCheck>>();
        classes.add(AvoidInternalCheck.class);
        classes.add(AvoidGuiceCheck.class);
        return classes;
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return new ArrayList<Class<? extends JavaCheck>>();
    }
}
