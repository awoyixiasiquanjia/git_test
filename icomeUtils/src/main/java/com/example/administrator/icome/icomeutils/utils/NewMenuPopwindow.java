package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;

import java.util.List;

public class NewMenuPopwindow extends PopupWindow {
    private View conentView;
    private ListView lvContent;

    public NewMenuPopwindow(final Activity context, List<NewMenuPopwindowBean> list) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.newmenu_popu, null);
        lvContent = (ListView) conentView.findViewById(R.id.lv_toptitle_menu);
        lvContent.setAdapter(new MyAdapter(context, list));
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(context.getResources().getDimensionPixelSize(R.dimen.x300));
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
//        //产生背景变暗效果
//        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
//        lp.alpha = 0.6f;
//        context.getWindow().setAttributes(lp);
        //popupWindow设置背景图
//        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.career_newfunction_bg);
//        this.setBackgroundDrawable(drawable);
        //设置popupWindow消失时的监听
        this.setOnDismissListener(new OnDismissListener() {
            //在dismiss中恢复透明度
            public void onDismiss() {
                WindowManager.LayoutParams lp = context.getWindow().getAttributes();
                lp.alpha = 1f;
                context.getWindow().setAttributes(lp);

            }
        });
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.NewAnimTools);
    }


    public void setOnItemClick(AdapterView.OnItemClickListener myOnItemClickListener) {
        lvContent.setOnItemClickListener(myOnItemClickListener);
    }


    class MyAdapter extends BaseAdapter {
        private List<NewMenuPopwindowBean> list;
        private LayoutInflater inflater;

        public MyAdapter(Context context, List<NewMenuPopwindowBean> list) {
            inflater = LayoutInflater.from(context);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.newmenu_popup_item, null);
                holder = new Holder();
//                holder.ivItem = (ImageView) convertView.findViewById(R.id.iv_menu_item);
                holder.tvItem = (TextView) convertView.findViewById(R.id.tv_menu_item);
                    mChangeTextviewColorListener.setTextviewColor(position,holder.tvItem);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
//            holder.ivItem.setImageResource(list.get(position).icon);
            holder.tvItem.setText(list.get(position).text);
            return convertView;
        }

        class Holder {
            ImageView ivItem;
            TextView tvItem;
        }
    }

    public interface toChangeTextviewColorListener{
        void setTextviewColor(int postition,TextView textView);
    }

    private toChangeTextviewColorListener mChangeTextviewColorListener;

    public void setChangeTextviewColorListener(toChangeTextviewColorListener changeTextviewColorListener){
        mChangeTextviewColorListener = changeTextviewColorListener;
    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(Activity activity, View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, -(activity.getResources().getDimensionPixelSize(R.dimen.x190)), 10);
        } else {
            this.dismiss();
        }
    }
   public static class NewMenuPopwindowBean {
        public int icon;
        public String text;
    }
}