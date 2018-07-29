/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;

import com.android.settings.R;

import com.android.settings.development.DevelopmentSettings;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class OTAPreferenceController extends AbstractPreferenceController
                implements PreferenceControllerMixin {

    private static final String KEY_ABC_UPDATES = "abc_updates";
    Context mContext;

    public OTAPreferenceController(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public boolean isAvailable() {
        return DevelopmentSettings.isPackageInstalled(mContext, "com.abc.ota");
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        if (!isAvailable()) {
            return;
        }
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (!isAvailable()) {
            return true;
        }
        return false;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_ABC_UPDATES;
    }
}