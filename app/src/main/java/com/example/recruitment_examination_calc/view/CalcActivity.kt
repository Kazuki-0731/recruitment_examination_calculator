package com.example.recruitment_examination_calc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recruitment_examination_calc.R
import com.example.recruitment_examination_calc.databinding.ActivityCalcBinding
import com.example.recruitment_examination_calc.viewmodel.CalcViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class CalcActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var binding: ActivityCalcBinding

    private lateinit var viewModel: CalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calc)

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(CalcViewModel::class.java)

        replaceFragment(CalcFragment(), R.id.calc_content_view)
    }

    private fun replaceFragment(fragment: Fragment, layoutResId: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(layoutResId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}