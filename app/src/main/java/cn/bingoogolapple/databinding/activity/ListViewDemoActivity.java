package cn.bingoogolapple.databinding.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.databinding.R;
import cn.bingoogolapple.databinding.databinding.ItemUserBinding;
import cn.bingoogolapple.databinding.model.User;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 下午5:04
 * 描述:
 */
public class ListViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(R.id.listView);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            users.add(new User("user" + i, "phone" + i, 18 + i, i % 2 == 0));
        }
        listView.setAdapter(new UserAdapter(this, users));
    }

    private static class UserAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<User> mUsers;

        public UserAdapter(Context context, List<User> users) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mUsers = users;
        }

        @Override
        public int getCount() {
            return mUsers == null ? 0 : mUsers.size();
        }

        @Override
        public User getItem(int position) {
            return mUsers == null?null:mUsers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemUserBinding binding;
            if (convertView == null) {
                binding = DataBindingUtil.inflate(mInflater, R.layout.item_user, parent, false);
            } else {
                binding = DataBindingUtil.getBinding(convertView);
            }
            binding.setUser(getItem(position));
            convertView = binding.getRoot();
            return convertView;
        }
    }

}
