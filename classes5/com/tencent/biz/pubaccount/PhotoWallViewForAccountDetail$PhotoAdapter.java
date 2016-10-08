package com.tencent.biz.pubaccount;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import hpd;
import java.util.List;
import org.json.JSONArray;

public class PhotoWallViewForAccountDetail$PhotoAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List jdField_a_of_type_JavaUtilList;
  
  public PhotoWallViewForAccountDetail$PhotoAdapter(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        paramViewGroup = new JSONArray(((PaConfigAttr.PaConfigInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).e);
        if (paramViewGroup.length() > 0)
        {
          paramViewGroup = paramViewGroup.optString(0);
          if (paramView == null)
          {
            localhpd = new hpd(this);
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903455, null);
            paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.b, this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.c));
            localhpd.a = ((URLImageView)paramView.findViewById(2131298670));
            paramView.setTag(localhpd);
            localhpd.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
            if (!TextUtils.isEmpty(paramViewGroup)) {
              continue;
            }
            localhpd.a.setImageResource(2130838424);
            return paramView;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramViewGroup.printStackTrace();
        paramViewGroup = null;
        continue;
        hpd localhpd = (hpd)paramView.getTag();
        continue;
        paramViewGroup = URLDrawable.getDrawable(paramViewGroup);
        localhpd.a.setImageDrawable(paramViewGroup);
        return paramView;
      }
      paramViewGroup = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PhotoWallViewForAccountDetail$PhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */