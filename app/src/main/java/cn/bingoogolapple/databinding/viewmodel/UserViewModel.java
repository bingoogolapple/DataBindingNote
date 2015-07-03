package cn.bingoogolapple.databinding.viewmodel;

import android.databinding.BaseObservable;

import cn.bingoogolapple.databinding.model.User;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 下午2:46
 * 描述:
 */
public class UserViewModel extends BaseObservable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
//        notifyPropertyChanged(BR.user);
        notifyChange();
    }
}