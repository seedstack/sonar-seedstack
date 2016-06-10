/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.sonar.java.core;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class AvoidGuiceCheckTest {
    @Test
    public void detected() {
        AvoidGuiceCheck check = new AvoidGuiceCheck();
        JavaCheckVerifier.verify("src/test/java/org/seedstack/sonar/java/fixtures/AvoidGuiceCheck.java", check);
    }
}
