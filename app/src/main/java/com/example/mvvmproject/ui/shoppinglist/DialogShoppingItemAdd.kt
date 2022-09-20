package com.example.mvvmproject.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmproject.R
import com.example.mvvmproject.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class DialogShoppingItemAdd(context: Context, var dialogListener: DialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = evName.text.toString()
            val amount = evAmount.text.toString()
            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Fill the Required Field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name, amount.toInt())
            dialogListener.addButtonClick(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}