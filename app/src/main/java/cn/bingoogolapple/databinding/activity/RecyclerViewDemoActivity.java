package cn.bingoogolapple.databinding.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class RecyclerViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            users.add(new User("user" + i, "phone" + i, 18 + i, i % 2 == 0));
        }
        recyclerView.setAdapter(new UserAdapter(this, users));
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemUserBinding mBinding;

        public ViewHolder(final View view, final ItemUserBinding binding) {
            super(view);
            mBinding = binding;
        }

        @UiThread
        public void bind(final User user) {
            mBinding.setUser(user);
        }
    }

    private static class UserAdapter extends RecyclerView.Adapter<ViewHolder>  {
        private LayoutInflater mInflater;
        private List<User> mUsers;

        public UserAdapter(Context context, List<User> users) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mUsers = users;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
            final ItemUserBinding binding = DataBindingUtil.inflate(mInflater, R.layout.item_user, viewGroup, false);
            return new ViewHolder(binding.getRoot(), binding);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.bind(mUsers.get(position));
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return mUsers == null ? 0 : mUsers.size();
        }
    }

}
