package org.seedstack.sonar.java.core.fixtures;

import org.seedstack.seed.core.internal.jndi.SeedContextFactory;

import javax.naming.NamingException;

/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

public class AvoidInternalCheck {
    private SeedContextFactory seedContextFactory; // Noncompliant {{Remove usage of org.seedstack.seed.core.internal.jndi.SeedContextFactory type}}

    public void someMethod() throws NamingException {
        seedContextFactory.getInitialContext(null);
    }

}
