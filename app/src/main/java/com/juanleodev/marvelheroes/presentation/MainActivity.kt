package com.juanleodev.marvelheroes.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.juanleodev.marvelheroes.databinding.ActivityMainBinding
import com.juanleodev.marvelheroes.presentation.heroeslist.HeroesListActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animationWatcher()
    }

    private fun animationWatcher() {
        var animationFinihed = false
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                while(!animationFinihed) {
                    if (binding.splashMotionContainer.progress == 1.0f) {
                        animationFinihed = true
                        delay(TimeUnit.SECONDS.toMillis(1))
                        val intent = Intent(
                            this@MainActivity,
                            HeroesListActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}