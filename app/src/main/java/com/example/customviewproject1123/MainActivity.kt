package com.example.customviewproject1123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private lateinit var autoCompleteTextView : AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        val data = listOf<String>(
            "可愛女人","星晴","鬥牛","龍捲風","雙截棍","開不了口","爸，我回來了",
            "威廉古堡","安靜","世界末日","對不起","簡單愛","我們在成長","最後的戰役",
            "回到過去","半島鐵盒","半獸人","以父之名","妳聽得到","東風破","軌跡",
            "七里香","園遊會","外婆","漂移","一路向北","夜曲","黑色毛衣","霍元甲",
            "髮如雪","千里之外","迷迭香","黃金甲","菊花台","不能說的秘密","牛仔很忙","彩虹","甜甜的",
            "周大俠","稻香","說好的幸福呢","畫沙","超人不會飛"
        )

        val arrayAdapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_dropdown_item_1line,data)
        autoCompleteTextView.apply {
            setAdapter(arrayAdapter)
            threshold = 1
        }






    }
}