/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.rain.mvpframe.module;


import com.rain.mvpframe.base.GlobalApplication;
import com.rain.mvpframe.core.DataManager;
import com.rain.mvpframe.core.db.DbHelper;
import com.rain.mvpframe.core.db.DbHelperImpl;
import com.rain.mvpframe.core.http.HttpHelper;
import com.rain.mvpframe.core.http.HttpHelperImpl;
import com.rain.mvpframe.core.preference.PreferenceHelper;
import com.rain.mvpframe.core.preference.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final GlobalApplication application;

    public AppModule(GlobalApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    GlobalApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelperImpl) {
        return dbHelperImpl;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        return new DataManager(httpHelper, dbHelper, preferenceHelper);
    }

}
