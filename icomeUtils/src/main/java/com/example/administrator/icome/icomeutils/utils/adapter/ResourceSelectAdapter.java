
package com.example.administrator.icome.icomeutils.utils.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;
import com.example.administrator.icome.icomeutils.utils.NewGlideUtils;
import com.example.administrator.icome.icomeutils.utils.bean.SelectPersonBean;


import java.util.List;

public class ResourceSelectAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<SelectPersonBean> mList;

    public ResourceSelectAdapter(Context context, List<SelectPersonBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.resource_selectperson_item, null);
        return new RelatedCar(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RelatedCar relatedCar = (RelatedCar) holder;

        //切换选中
        if (mList.get(position).isSelect()){
            relatedCar.mLayout.setBackground(mContext.getResources().getDrawable(R.mipmap.grouping));
        }else {
            relatedCar.mLayout.setBackground(mContext.getResources().getDrawable(R.mipmap.resource_select_image));
        }

        //名字
        if (!TextUtils.isEmpty(mList.get(position).getName())){
            relatedCar.mName.setText(mList.get(position).getName());
        }

        //头像
        if (!TextUtils.isEmpty(mList.get(position).getPersonIcon())){
            NewGlideUtils.glideCircularBead3(mContext,mList.get(position).getPersonIcon(),relatedCar.mHeadImage,200);
        }

        relatedCar.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重置所有状态
               if (isHasSelected(mList,position)){
                   resetStatus(mList);
                   mOnClickListener.onClick(v,position,0);
               }else {
                   //设置点击的选中
                   resetStatus(mList);
                   mList.get(position).setSelect(true);
                   mOnClickListener.onClick(v,position,mList.get(position).getUserId());
               }
                notifyDataSetChanged();
            }

        });

    }

    private void resetStatus(List<SelectPersonBean> list){
        for (SelectPersonBean bean : mList) {
            bean.setSelect(false);
        }
    }

    private boolean isHasSelected(List<SelectPersonBean> list,int position){
        boolean ret = false;
        for (SelectPersonBean bean : mList) {
            if (bean.isSelect()){
                if(bean.getUserId() == mList.get(position).getUserId()){
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    private class RelatedCar extends RecyclerView.ViewHolder {
        ImageView mHeadImage;
        TextView mName;
        LinearLayout mLayout;

        public RelatedCar(View view) {
            super(view);
            mName = view.findViewById(R.id.resource_selectperson_name);
            mHeadImage = view.findViewById(R.id.resource_selectperson_heard);
            mLayout = view.findViewById(R.id.resource_selectperson_layout);
        }
    }

    /**
     * recyclerView点击事件
     */
    public interface onClickListener {
        void onClick(View view, int position ,int userId);
    }

    private onClickListener mOnClickListener;

    public void setOnClickListener(onClickListener clickListener) {
        mOnClickListener = clickListener;
    }
}