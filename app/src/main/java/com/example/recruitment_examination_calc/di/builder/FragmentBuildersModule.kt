package com.example.recruitment_examination_calc.di.builder

import com.example.recruitment_examination_calc.view.CalcFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCalcFragment(): CalcFragment
}
