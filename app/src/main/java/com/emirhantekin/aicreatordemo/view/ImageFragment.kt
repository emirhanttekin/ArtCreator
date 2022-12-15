package com.emirhantekin.aicreatordemo.view

import android.app.AlertDialog
import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.emirhantekin.aicreatordemo.ApiState
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.databinding.FragmentImageBinding
import com.emirhantekin.aicreatordemo.di.viewModelModule
import com.emirhantekin.aicreatordemo.model.UserViewModel
import com.emirhantekin.aicreatordemo.service.APIClient
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private val mUserViewModel : UserViewModel by sharedViewModel()



    private  var byteArray : ByteArray?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel.viewModelScope.launch {
            launch(Dispatchers.IO) {

                try {
                    val response = APIClient.Text2ImageClient.service.generateImage(
                        "${ApiState.tempHead}, ${ApiState.tempCategory}, highly-detailed masterpiece trending HQ",
                        7.5,
                        512,
                        512,
                        "k_lms",
                        50,
                        "//paid key"
                    )

                    val byte = response.body()?.byteStream()?.readBytes()


                    byte?.let {
                        byteArray = it
                    }
                    println("biggestfan"+byteArray)

                        println("kendidebug")
                        mUserViewModel.insertData(User(0,byteArray!!,ApiState.tempHead))


                    val bitmap = BitmapFactory.decodeByteArray(byte, 0, byte!!.size)
                    mUserViewModel.viewModelScope.launch {
                        binding.image.setImageBitmap(bitmap)

                    }

                }catch (e: Exception){
                    println("message"+e.localizedMessage)
                }



            }


            delay(2000)


            if(byteArray != null){

            }



        }













        binding.imageView7.setOnClickListener {
            findNavController().navigateUp()


        }
        binding.dowloadimg.setOnClickListener {
            val bitmap = (binding.image.drawable as BitmapDrawable).bitmap
            val values = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, "ImageName.jpg")
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())


            }
            val resolver = requireContext().contentResolver
            val url = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

            if (url != null) {
                resolver.openOutputStream(url).use { out ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                }
            }
            val builder = AlertDialog.Builder(requireContext())

// Set the message and title for the alert

                .setTitle("Fotoğraf galeriye yüklendi")

// Add a positive action to the alert
            builder.setPositiveButton("OK") { dialog, id ->
                // You can add code here to handle the "OK" button being clicked
            }

// Show the alert
            val dialog = builder.create()
            dialog.show()


        }


    }
}



