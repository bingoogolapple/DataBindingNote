package cn.bingoogolapple.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.databinding.R;
import cn.bingoogolapple.databinding.databinding.ActivityHelloworldBinding;
import cn.bingoogolapple.databinding.model.User;
import cn.bingoogolapple.databinding.viewmodel.UserViewModel;

//import cn.bingoogolapple.databinding.databinding.HelloworldBinding;

public class HelloworldActivity extends AppCompatActivity {
    // 默认是layout的文件名
    private ActivityHelloworldBinding mBinding;
//    private HelloworldBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_helloworld);

        final UserViewModel userViewModel = new UserViewModel();
        userViewModel.setUser(new User("bingoogolapple", "12345678912", 24, true));
        mBinding.setActivityUserViewModel(userViewModel);

        mBinding.setTest("我是test");

        List<String> strList = new ArrayList<>();
        strList.add("strList1");
        strList.add("strList2");
        mBinding.setStrList(strList);

        List<User> userList = new ArrayList<>();
        userList.add(new User("userList1", "userList1Phone", 18, true));
        userList.add(new User("userList2", "userList2Phone", 20, false));
        mBinding.setUserList(userList);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userViewModel.setUser(new User("新用户名", "88888888888", 30, false));
//                mBinding.setActivityUserViewModel(userViewModel);
            }
        }, 3000);
    }
}