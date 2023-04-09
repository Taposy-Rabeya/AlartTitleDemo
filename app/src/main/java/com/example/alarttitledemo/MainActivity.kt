package com.example.alarttitledemo

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alarttitledemo.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlertDialog.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setIcon(R.drawable.question)
                .setTitle("Alart Dialog")
                .setMessage("Do you want to exit")
                .setNeutralButton("Cancel") { dialog, which ->
                    Toast.makeText(this, "System Canceled", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Yes") { dialog, which ->
                    finish()
                }

//                        .setPositiveButton("Yes", DialogInterface.OnClickListener {
//                                dialog, id -> finish()

                .setCancelable(false)
            val alert = dialogBuilder.create()
                alert.show()
        }
    }
}
