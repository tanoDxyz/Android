/*
 * Copyright (c) 2019 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.browser.omnibar

import android.view.View
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
import javax.inject.Inject


class OmnibarScrolling @Inject constructor() {


    private var isScrollingEnabled = true

    val isOmnibarScrollingEnabled:Boolean get() = isScrollingEnabled

    fun enableOmnibarScrolling(toolbarContainer: View) {
        updateScrollFlag(SCROLL_FLAG_SCROLL or SCROLL_FLAG_ENTER_ALWAYS, toolbarContainer)
        isScrollingEnabled = true
    }

    fun disableOmnibarScrolling(toolbarContainer: View) {
        updateScrollFlag(0, toolbarContainer)
        isScrollingEnabled = false
    }

    private fun updateScrollFlag(flags: Int, toolbarContainer: View) {
        val params = toolbarContainer.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = flags
        toolbarContainer.layoutParams = params
    }
}
