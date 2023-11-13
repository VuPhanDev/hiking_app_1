package com.animsh.runningtracker.bottomnav

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.animsh.runningtracker.R
import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.ui.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_post.*
import java.io.IOException
import java.io.InputStream


@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {

    private val viewModel: PostViewModel by viewModels()

    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_IMAGE_PICK = 2

    private var selectedImageBitmap: Bitmap? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_back.setOnClickListener{
            requireActivity().onBackPressed()
        }

        btn_add_img.setOnClickListener {
//            showImageSourceDialog()
            val galleryIntent = Intent(Intent.ACTION_PICK)
            galleryIntent.type = "image/*"
            startActivityForResult(galleryIntent, REQUEST_IMAGE_PICK)
        }

        btn_post.setOnClickListener {
            val description = ed_des_post.text.toString()

            if (selectedImageBitmap != null) {
                val post = Post(selectedImageBitmap, description)
                viewModel.insertPost(post)
                Toast.makeText(context, "Post Success", Toast.LENGTH_SHORT).show()
                requireActivity().onBackPressed()
            } else {
                Toast.makeText(context, "Photos have not been added yet", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showImageSourceDialog() {
        val items = arrayOf("Camera", "Gallery")

        AlertDialog.Builder(requireContext())
            .setTitle("Choose Image Source")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> dispatchTakePictureIntent()
                    1 -> dispatchPickPictureIntent()
                }
            }
            .show()
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    private fun dispatchPickPictureIntent() {
        val pickPhotoIntent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhotoIntent, REQUEST_IMAGE_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                if (resultCode == Activity.RESULT_OK) {
//                    val imageBitmap = data?.extras?.get("data") as Bitmap
//                    val a = ed_des_post.text.toString()
//                    val post = Post(imageBitmap,a)
//                    viewModel.insertPost(post)
                }
            }

            REQUEST_IMAGE_PICK -> {
                if (resultCode == Activity.RESULT_OK) {
                    val selectedImageUri: Uri? = data?.data
                    selectedImageBitmap = selectedImageUri?.let { uriToBitmap(requireContext(), it) }
                    ivPostImage.setImageURI(selectedImageUri)
                }
            }
        }
    }

    fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
        return try {
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}