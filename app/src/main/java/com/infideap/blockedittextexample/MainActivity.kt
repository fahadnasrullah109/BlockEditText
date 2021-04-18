package com.infideap.blockedittextexample

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.infideap.blockedittext.BlockEditText
import com.infideap.blockedittext.CardPrefix
import com.infideap.blockedittextexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
        val amexEditText: BlockEditText = findViewById(R.id.blockEditText_amex)
        amexEditText.setNumberOfBlock(3)
        amexEditText.setDefaultLength(4)
        amexEditText.setLengthAt(1, 6)
        amexEditText.setLengthAt(2, 5)
        amexEditText.setHint("Amex")
        amexEditText.setSeparatorCharacter('-')
        amexEditText.setInputType(InputType.TYPE_CLASS_NUMBER)
        amexEditText.setEdiTextBackground(ContextCompat.getDrawable(this, R.drawable.selector_edittext_round_border_line))
        amexEditText.setTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length >= amexEditText.maxLength) {
                    amexEditText.setBackgroundColor(Color.GREEN)
                } else amexEditText.setBackgroundColor(Color.TRANSPARENT)
            }

            override fun afterTextChanged(s: Editable) {}
        })
        val cardEditText: BlockEditText = findViewById(R.id.blockEditText_card)
        cardEditText.addCardPrefix(CardPrefix.amex(this))
        val icNumberEditText: BlockEditText = findViewById(R.id.blockEditText_ic_number)
        // Data Binding
        binding.idNumber = "980201-01-1234"
        binding.numberOfBlockId = 3

        icNumberEditText.setDefaultLength(6)
        icNumberEditText.setLengthAt(1, 2)
        icNumberEditText.setLengthAt(2, 4)


        //val customFontEditText: BlockEditText = findViewById(R.id.blockEditText_custom_font)
//        customFontEditText.setTypeface(Typeface.createFromAsset(resources.assets, "Quicksand-Light.ttf"))

        val customTextColorEditText: BlockEditText = findViewById(R.id.blockEditText_custom_text_color)
//        customTextColorEditText.setHintTextColor(Color.BLACK)
        customTextColorEditText.setInputTextColor(ColorStateList(
                arrayOf(
                        intArrayOf(android.R.attr.state_focused),
                        intArrayOf()),
                intArrayOf(ContextCompat.getColor(this,R.color.colorPrimary), Color.BLACK),
        ))


    }
}