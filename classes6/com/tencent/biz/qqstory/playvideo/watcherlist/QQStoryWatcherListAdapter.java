package com.tencent.biz.qqstory.playvideo.watcherlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import ipx;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class QQStoryWatcherListAdapter
  extends BaseAdapter
{
  public Context a;
  View.OnTouchListener a;
  public InfoCardDialog a;
  protected List a;
  
  public QQStoryWatcherListAdapter(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  private View a()
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904507, null);
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    WatcherItem localWatcherItem = (WatcherItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((TextView)paramBaseViewHolder.a(2131296932)).setText(localWatcherItem.jdField_a_of_type_JavaLangString);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131298449);
    Object localObject = ImageUtil.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      localQQAppInterface = (QQAppInterface)localAppRuntime;
    }
    for (localObject = FaceDrawable.a(localQQAppInterface, 1, Long.toString(localWatcherItem.jdField_a_of_type_Long), 3, (Drawable)localObject, (Drawable)localObject);; localObject = null)
    {
      paramBaseViewHolder.a(localWatcherItem);
      paramBaseViewHolder.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      if (paramBaseViewHolder.a() == null) {
        paramBaseViewHolder.a(new ipx(this, localQQAppInterface));
      }
      if (localObject != null) {
        localImageView.setImageDrawable((Drawable)localObject);
      }
      while (!HttpUtil.a(localWatcherItem.b)) {
        return;
      }
      UIUtils.a(localImageView, localWatcherItem.b, 38, 38, 1);
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = new BaseViewHolder(a());; paramView = (BaseViewHolder)paramView.getTag())
    {
      a(paramView, paramInt);
      return paramView.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\watcherlist\QQStoryWatcherListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */