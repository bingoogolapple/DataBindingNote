package cn.bingoogolapple.databinding.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.bingoogolapple.databinding.R;
import cn.bingoogolapple.databinding.databinding.FragmentDemoBinding;
import cn.bingoogolapple.databinding.model.User;
import cn.bingoogolapple.databinding.viewmodel.UserViewModel;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 下午3:20
 * 描述:
 */
public class DemoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDemoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo, container, false);
        final UserViewModel userViewModel = new UserViewModel();
        userViewModel.setUser(new User("王浩", "12345678912", 24, true));
        binding.setFragmentUserViewModel(userViewModel);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userViewModel.setUser(new User("新用户名哈哈", "12345678912", 24, false));
            }
        }, 3000);

        return binding.getRoot();
    }

}
