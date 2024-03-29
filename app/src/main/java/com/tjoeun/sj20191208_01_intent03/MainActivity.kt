package com.tjoeun.sj20191208_01_intent03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000이라는 숫자만 보면 어떤 의미로 쓰인 값인지 알기 어렵다.
//    상수로 이름을 지어줘서 읽기 편하게 가공

    val  REQ_CODE_FOR_INPUT_NAME = 1000//아무값이나 쓰고 싶은거 써라
    val  REQ_CODE_FOR_INPUT_NICNAME = 1001//아무값이나 쓰고 싶은거 써라



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inputNameBtn.setOnClickListener {
            val intent = Intent(this, EditNicNameActivity::class.java)

//            startActivity(intent) => 단순 이동을 위한 호출

//            결과를 받아오기 위한 "요청(REquest)"을 하면서 화면이동.
//            어떤 요청인지 구별해주는 숫자값 적어줘야함
            startActivityForResult(intent, REQ_CODE_FOR_INPUT_NICNAME)
        }




        inputNameBtn.setOnClickListener {
            val intent = Intent(this, EditNameActivity::class.java)

//            startActivity(intent) => 단순 이동을 위한 호출

//            결과를 받아오기 위한 "요청(REquest)"을 하면서 화면이동.
//            어떤 요청인지 구별해주는 숫자값 적어줘야함
            startActivityForResult(intent, REQ_CODE_FOR_INPUT_NAME)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤 요청에 대한 결과를 가져온건지 확인
        if (requestCode == REQ_CODE_FOR_INPUT_NAME) {

//            확인버튼을 누른게 맞는지 확인
            if (resultCode == Activity.RESULT_OK) {

//                결과를 담아둔 Intent가 실재 할때에만 실행됨.
                if (data != null) {
                    val inputName = data.getStringExtra("name")

                    nameTxt.text = inputName

                }

            }

        }else
            if (requestCode == REQ_CODE_FOR_INPUT_NICNAME) {
                if (resultCode == Activity.RESULT_OK){
                    if (data!=null){
                        nicNameTxt.text = data.getStringExtra("nicName")
                    }
                }
            }
    }


}
