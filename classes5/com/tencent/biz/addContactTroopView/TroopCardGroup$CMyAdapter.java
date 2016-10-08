package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.ListView;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item1;

public class TroopCardGroup$CMyAdapter
  extends FacePreloadBaseAdapter
{
  public TroopCardGroup$CMyAdapter(TroopCardGroup paramTroopCardGroup, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    super(paramContext, paramQQAppInterface, paramListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(int paramInt)
  {
    searchtab.Item1 localItem1 = (searchtab.Item1)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = String.valueOf(localItem1.uint64_group_code.get());
    localFaceInfo.jdField_a_of_type_Int = 4;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return this.a.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    searchtab.Item1 localItem1 = (searchtab.Item1)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = GroupViewAdapter.a(this.a.jdField_a_of_type_AndroidContentContext, paramViewGroup, 5, true, 1);
    }
    GroupViewAdapter.a(localView, this.a.jdField_a_of_type_AndroidContentContext, localItem1);
    paramView = (FacePreloadBaseAdapter.ViewHolder)localView.getTag();
    if (!TextUtils.isEmpty(localItem1.str_img_url.get())) {
      paramView.d.setImageDrawable(URLDrawable.getDrawable(localItem1.str_img_url.get(), paramView.d.getWidth(), paramView.d.getHeight()));
    }
    while (localItem1.uint64_group_code.get() <= 0L) {
      return localView;
    }
    paramView.b = String.valueOf(localItem1.uint64_group_code.get());
    paramView.d.setImageBitmap(a(4, String.valueOf(localItem1.uint64_group_code.get())));
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\addContactTroopView\TroopCardGroup$CMyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */