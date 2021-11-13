package com.example.recruitment_examination_calc.viewmodel

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recruitment_examination_calc.logic.CalcExecute
import javax.inject.Inject

class CalcViewModel @Inject constructor(): ViewModel() {
    // 入力
    private var inputNumberA: String = ""
    private var inputNumberB: String = ""
    // 演算子
    private val inputOperator: MutableLiveData<String> = MutableLiveData("")
    private var isNotPushedOperator = true
    // 計算結果
    val calcResult: MutableLiveData<String> = MutableLiveData("")

    init {
        calcResult.value = ""
    }

    // 数字押下
    fun onClickNumber0() { concatNumber("0") }
    fun onClickNumber1() { concatNumber("1") }
    fun onClickNumber2() { concatNumber("2") }
    fun onClickNumber3() { concatNumber("3") }
    fun onClickNumber4() { concatNumber("4") }
    fun onClickNumber5() { concatNumber("5") }
    fun onClickNumber6() { concatNumber("6") }
    fun onClickNumber7() { concatNumber("7") }
    fun onClickNumber8() { concatNumber("8") }
    fun onClickNumber9() { concatNumber("9") }

    /**
     * 数字の文字列連結
     * @param num
     */
    private fun concatNumber(num: String) {
        if(isNotPushedOperator) {
            inputNumberA += num
            calcResult.value += num
        } else if (!isNotPushedOperator) {
            inputNumberB += num
            calcResult.value += num
        }
    }

    // 演算子押下
    fun onClickPlus() { concatOperator("+") }
    fun onClickMinus() { concatOperator("-") }
    fun onClickAsterisk() { concatOperator("*") }
    fun onClickSolidus() { concatOperator("/") }

    /**
     * 演算子の文字列連結
     * @param ope
     */
    private fun concatOperator(ope: String) {
        if (inputNumberA.isNotBlank() && isNotPushedOperator) {
            inputOperator.value = ope
            calcResult.value = calcResult.value + inputOperator.value
            isNotPushedOperator = false
        }
    }

    /**
     * 結果出力(=押下時)
     * @param view
     * @return result
     */
    fun onClickEqual(view: View) {
        if (inputNumberB.isBlank()) return

        val inA = inputNumberA.toInt()
        val inB = inputNumberB.toInt()

        if (inA == 0 && inB == 0) {
            // 0除算アラート
            zeroAlert(view.context)
        } else {
            inputOperator.value?.let {
                val result = callTwoItemsCalc(inA, inB, it)
                calcResult.value += "\n" + result.toString() + "\n"
                inputNumberA = ""
                inputNumberB = ""
                isNotPushedOperator = true
            }
        }
    }

    /**
     * 2項計算
     * @param inA
     * @param inB
     * @param op
     * @return result
     */
    private fun callTwoItemsCalc(inA: Int, inB: Int, op: String): Int {
        return CalcExecute.twoItemsCalc(
            inputA = inA,
            inputB = inB,
            operator = op
        )
    }

    /**
     * 0除算アラート
     * @param context
     */
    private fun zeroAlert(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("ERROR！")
            .setMessage("0除算になっています")
            .setPositiveButton("OK"){ _, _ -> }
            .show()
    }
}