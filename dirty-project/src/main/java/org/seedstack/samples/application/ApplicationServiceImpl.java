/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.samples.application;

import com.google.inject.Inject;
import org.seedstack.seed.Application;
import org.seedstack.seed.core.internal.jndi.SeedContextFactory;

public class ApplicationServiceImpl {
    @Inject
    private Application application;
    private SeedContextFactory seedContextFactory;
}
