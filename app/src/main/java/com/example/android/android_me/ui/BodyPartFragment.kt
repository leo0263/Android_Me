/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.android_me.R


/**
 * Mandatory empty constructor for the fragment manager to instantiate the fragment
 */
class BodyPartFragment : Fragment() {

    var imageList: List<kotlin.Int> = emptyList()
    var partIndex = 0

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the Android-Me fragment layout
        val rootView = inflater.inflate(R.layout.fragment_body_part, container, false)

        // Get a reference to the ImageView in the fragment layout
        val imageView = rootView.findViewById<View>(R.id.body_part_image_view) as ImageView

        // Set the image to any image asset
        imageList.let {
            imageView.setImageResource(imageList[partIndex])
        }

        // Return the rootView
        return rootView
    }

}
