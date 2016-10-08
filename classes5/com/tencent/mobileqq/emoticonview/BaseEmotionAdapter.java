package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseEmotionAdapter
  extends BaseAdapter
{
  public static final int a = 72;
  public static final String a;
  public static final int b = 56;
  protected float a;
  public Context a;
  protected QQAppInterface a;
  protected EmoticonCallback a;
  protected EmotionPanelInfo a;
  private EmotionPanelListView a;
  protected List a;
  protected Map a;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BaseAdapter.class.getSimpleName();
  }
  
  public BaseEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt1;
    this.e = paramInt2;
    this.d = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    new DisplayMetrics();
    this.f = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.g = paramContext.getResources().getColor(2131427547);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public abstract View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public RelativeLayout a()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getEmotionLayout");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f / this.c, (int)(72.0F * this.jdField_a_of_type_Float)));
    try
    {
      Object localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject1).setId(2131296396);
        ((TextView)localObject1).setTextColor(this.g);
        ((TextView)localObject1).setTextSize(11.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
        ((TextView)localObject1).setGravity(17);
        localRelativeLayout.addView((View)localObject1, localLayoutParams);
      }
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject1).setId(2131296394);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(2, 2131296396);
      localLayoutParams.addRule(14);
      ((URLImageView)localObject1).setVisibility(8);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((URLImageView)localObject1).setAdjustViewBounds(false);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setId(2131296395);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131296394);
      localLayoutParams.addRule(8, 2131296394);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (AppSetting.j) {
        localRelativeLayout.setFocusable(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getEmotionlayout cost = " + (System.currentTimeMillis() - l));
      }
      return localRelativeLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public EmoticonPackage a()
  {
    return null;
  }
  
  public abstract BaseEmotionAdapter.ViewHolder a();
  
  public EmotionPanelListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destory");
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int j = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((ArrayList)localObject).size())
          {
            View localView = (View)((ArrayList)localObject).get(i);
            if (localView.getParent() != null) {
              ((ViewGroup)localView.getParent()).removeView(localView);
            }
            localView.setTag(null);
            if ((localView instanceof EmotionPanelLinearLayout)) {
              ((EmotionPanelLinearLayout)localView).setCallBack(null);
            }
            EmotionPanelViewPool.a().a(j, localView);
            i += 1;
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "recycleView viewType = " + paramInt);
      }
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
    } while (localArrayList.contains(paramView));
    localArrayList.add(paramView);
  }
  
  public void a(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramEmotionPanelData != null))
    {
      paramView.setVisibility(0);
      localObject1 = null;
      if ((paramEmotionPanelData instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)paramEmotionPanelData;
      }
      if (localObject1 != null) {
        break label58;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "emotionInfo = null");
    }
    label58:
    Object localObject2;
    do
    {
      return;
      paramView.setTag(localObject1);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131296394);
      long l = System.currentTimeMillis();
      localObject2 = ((EmoticonInfo)localObject1).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getDrawable cost = " + (System.currentTimeMillis() - l));
      }
      paramEmotionPanelData.setImageDrawable((Drawable)localObject2);
      paramEmotionPanelData.setVisibility(0);
    } while (!(localObject1 instanceof PicEmoticonInfo));
    paramEmotionPanelData = (PicEmoticonInfo)localObject1;
    Object localObject1 = (TextView)paramView.findViewById(2131296396);
    if (paramEmotionPanelData.a != null)
    {
      localObject2 = paramEmotionPanelData.a.name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label270;
      }
      ((TextView)localObject1).setVisibility(0);
      if (((String)localObject2).length() <= 5) {
        break label261;
      }
      ((TextView)localObject1).setText(((String)localObject2).substring(0, 4) + "...");
    }
    for (;;)
    {
      paramView = (ImageView)paramView.findViewById(2131296395);
      if (!paramEmotionPanelData.a()) {
        break;
      }
      paramView.setVisibility(0);
      paramView.setImageResource(2130843335);
      return;
      label261:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      continue;
      label270:
      ((TextView)localObject1).setVisibility(8);
    }
    paramView.setVisibility(4);
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = paramEmotionPanelListView;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b() {}
  
  public void c() {}
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = k / this.c;
      int i = j;
      if (k % this.c > 0) {
        i = j + 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCount count = " + i);
      }
      return i;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "get count len = 0");
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (BaseEmotionAdapter.ViewHolder localViewHolder = a();; localViewHolder = (BaseEmotionAdapter.ViewHolder)paramView.getTag()) {
      return a(localViewHolder, paramInt, paramView, paramViewGroup);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\BaseEmotionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */