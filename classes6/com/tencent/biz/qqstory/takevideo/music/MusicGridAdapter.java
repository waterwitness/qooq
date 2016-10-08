package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class MusicGridAdapter
  extends BaseAdapter
{
  protected static int b;
  protected static int c;
  protected static int d;
  protected int a;
  protected Context a;
  protected GridView a;
  protected ArrayList a;
  protected boolean a;
  protected ArrayList b;
  
  public MusicGridAdapter(Context paramContext, GridView paramGridView, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    jdField_b_of_type_Int = AIOUtils.a(90.0F, paramContext);
    c = AIOUtils.a(10.0F, paramContext);
    d = AIOUtils.a(5.0F, paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(jdField_b_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.add(new QQStoryMusicInfo(0, "静音"));
    if (!paramBoolean) {
      this.jdField_b_of_type_JavaUtilArrayList.add(new QQStoryMusicInfo(1, "视频原声"));
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new QQStoryMusicInfo(2, "QQ音乐曲库"));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, this.jdField_b_of_type_JavaUtilArrayList);
    int i = getCount();
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
    paramArrayList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    int j = jdField_b_of_type_Int;
    paramArrayList.width = ((i - 1) * c + j * i + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight());
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramArrayList);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)getItem(paramInt);
    if (localQQStoryMusicInfo == null) {
      return null;
    }
    View localView;
    if (paramView == null)
    {
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setGravity(17);
      paramView.setSingleLine();
      paramView.setLayoutParams(new AbsListView.LayoutParams(jdField_b_of_type_Int, jdField_b_of_type_Int));
      paramView.setPadding(d, c * 2, d, 0);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      localView = paramView;
      paramViewGroup = paramView;
      paramViewGroup.setText(localQQStoryMusicInfo.b);
      if (localQQStoryMusicInfo.f != 0) {
        break label147;
      }
      paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 2130841465, 0, 0);
      paramViewGroup.setTag(null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != paramInt) {
        break label217;
      }
      paramViewGroup.setBackgroundResource(2130841463);
      return localView;
      paramViewGroup = (TextView)paramView;
      localView = paramView;
      break;
      label147:
      if (localQQStoryMusicInfo.f == 1)
      {
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 2130841469, 0, 0);
        paramViewGroup.setTag(null);
      }
      else if (localQQStoryMusicInfo.f == 2)
      {
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 2130841460, 0, 0);
        paramViewGroup.setTag(null);
      }
      else
      {
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 2130841464, 0, 0);
        paramViewGroup.setTag(localQQStoryMusicInfo);
      }
    }
    label217:
    paramViewGroup.setBackgroundResource(2130841462);
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\MusicGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */