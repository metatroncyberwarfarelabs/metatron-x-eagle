/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.eagle.server.module;

import org.apache.eagle.app.module.ApplicationGuiceModule;
import org.apache.eagle.app.service.ApplicationProviderService;
import org.apache.eagle.common.module.CommonGuiceModule;
import org.apache.eagle.metadata.persistence.MetadataStoreModuleFactory;
import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {
    private ApplicationProviderService appProviderInst;

    public ServerModule(ApplicationProviderService appProviderInst) {
        this.appProviderInst = appProviderInst;
    }

    @Override
    protected void configure() {
        install(new CommonGuiceModule());
        install(new ApplicationGuiceModule(appProviderInst));
        install(MetadataStoreModuleFactory.getModule());
    }
}
