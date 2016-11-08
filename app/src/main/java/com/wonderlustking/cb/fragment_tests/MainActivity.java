package com.wonderlustking.cb.fragment_tests;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicateWithActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTest fragmentTest = (FragmentTest) fragmentManager.findFragmentById(R.id.firstFragment);

        if(fragmentTest == null) {
            fragmentTest = new FragmentTest();
            fragmentTransaction.add(R.id.firstFragment, fragmentTest);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void sendToActivity(String message) {
        FragmentResult result = (FragmentResult) fragmentManager.findFragmentById(R.id.secondFragment);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(result == null){
            Bundle bundle = new Bundle();
            bundle.putString("message",message);
            result = new FragmentResult();
            result.setArguments(bundle);
            fragmentTransaction.add(R.id.secondFragment, result);
            fragmentTransaction.commit();
        }else{
            result.updateMessage(message);
        }
    }
}
