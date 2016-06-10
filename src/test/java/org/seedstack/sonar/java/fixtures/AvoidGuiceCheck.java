/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java.fixtures;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.seedstack.seed.Application;

@Singleton // Noncompliant {{Replace usage of com.google.inject.Singleton with javax.inject.Singleton}}
public class AvoidGuiceCheck {
    @Inject // Noncompliant {{Replace usage of com.google.inject.Inject with javax.inject.Inject}}
    @Named("toto") // Noncompliant {{Replace usage of com.google.inject.name.Named with javax.inject.Named}}
    private Application application;

    static class MyProvider implements Provider<String> { // Noncompliant {{Replace usage of com.google.inject.Provider with javax.inject.Provider}}
        @Override
        public String get() {
            return "foo";
        }
    }
}
