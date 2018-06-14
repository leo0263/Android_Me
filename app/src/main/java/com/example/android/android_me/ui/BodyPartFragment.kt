package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets

class BodyPartFragment : Fragment() {

    // constructor for instantiating the fragment
    fun BodyPartFragment() {

    }

    /**
     * inflate the fragment layout and sets any image resources
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // inflate the body part fragment layout
        val rootView: View = inflater.inflate(R.layout.fragment_body_part, container, false)

        // get reference to ImageView in the fragment layout
        val imageView: ImageView = rootView.findViewById(R.id.body_part_image_view)

        // set the ImageView to display
        imageView.setImageResource(AndroidImageAssets.getHeads()[0])

        return rootView
    }
}