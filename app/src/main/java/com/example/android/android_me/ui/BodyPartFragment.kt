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
import java.util.ArrayList

/**
 * Mandatory empty constructor for the fragment manager to instantiate the fragment
 */
class BodyPartFragment : Fragment() {

    companion object {

        // TODO (3) Create final Strings to store state information about the list of images and list index

        // Tag for logging
        private const val TAG = "BodyPartFragment"
        private const val IMAGE_IDS = "image_id"
        private const val LIST_INDEX = "list_index"
    }

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private var mImageIds: List<Int> = emptyList()
    private var mListIndex: Int = 0

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // read last state, if any
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS)
            mListIndex = savedInstanceState.getInt(LIST_INDEX)
        }

        // Inflate the Android-Me fragment layout
        val rootView = inflater.inflate(R.layout.fragment_body_part, container, false)

        // Get a reference to the ImageView in the fragment layout
        val imageView = rootView.findViewById<View>(R.id.body_part_image_view) as ImageView

        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if (mImageIds.isNotEmpty()) {
            // Set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds[mListIndex])

            // TODO (1) Set a click listener on the image view and on a click increment the list index and set the image resource
            // TODO (2) If you reach the end of a list of images, set the list index back to 0 (the first item in the list)

            imageView.setOnClickListener {
                mListIndex++
                if (mListIndex >= mImageIds.size) mListIndex = 0
                imageView.setImageResource(mImageIds[mListIndex])
            }
        }

        // Return the rootView
        return rootView
    }

    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed

    fun setImageIds(imageIds: List<Int>) {
        mImageIds = imageIds
    }

    fun setListIndex(index: Int) {
        mListIndex = index
    }

    // TODO (4) Override onSaveInstanceState and save the current state of this fragment

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntegerArrayList(IMAGE_IDS, mImageIds as ArrayList<Int>?)
        outState.putInt(LIST_INDEX, mListIndex)
    }
}
