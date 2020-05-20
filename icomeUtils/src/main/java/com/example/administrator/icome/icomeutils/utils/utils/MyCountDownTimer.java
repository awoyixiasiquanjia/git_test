package com.example.administrator.icome.icomeutils.utils.utils;

import android.os.CountDownTimer;

/**
  * @explain 倒计时
  * @author Mr.su.
  * @creat 2020/2/21
  **/
public class MyCountDownTimer  extends CountDownTimer {
    public   CountDownTimerListener countDownTimerListener;
    public interface CountDownTimerListener{
        void onFinish();
        void onTick(long millisUntilFinished);
    }

    public MyCountDownTimer(long millisInFuture, long countDownInterval,CountDownTimerListener countDownTimerListener) {
        super(millisInFuture, countDownInterval);
        this.countDownTimerListener = countDownTimerListener;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        countDownTimerListener.onTick(millisUntilFinished);
    }
    @Override
    public void onFinish() {
        countDownTimerListener.onFinish();
    }


    public void onDestory(){
        cancel();
        countDownTimerListener =null;
    }
}
