package com.example.rock_paper_scissors
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        btn_mora.setOnClickListener {
            if (ed_name.length() < 1) {
                tv_text.text = "Your Name"
                return@setOnClickListener
            }
            val playerName = ed_name.text
            val comMora = (Math.random() * 3).toInt()
            val playerMoraText = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            val comMoraText = when(comMora) {
                0 -> "布"
                1 -> "石頭"
                else -> "剪刀"
            }
            tv_name.text = "名字\n$playerName"
            tv_mmora.text = "我方出拳\n$playerMoraText"
            tv_cmora.text = "手機出拳\n$comMoraText"
            when {
                btn_scissor.isChecked && comMora == 2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1 -> {
                    tv_winner.text = "Winner\n$playerName"
                    tv_text.text = "你獲勝！！！"
                }
                btn_scissor.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "Winner\n 手機"
                    tv_text.text = "可惜，手機獲勝了！"
                }
                else -> {
                    tv_winner.text = "勝利者\n 平手"
                    tv_text.text = "平局，請再試一次！"
                }
            }
        }
    }
}