package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rkr;

public class EmotionPanelViewPagerAdapter
  extends PagerAdapter
{
  public static final int a = 5;
  public static final String a;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmotionPanelInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private Map b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelViewPagerAdapter.class.getSimpleName();
  }
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
  }
  
  private BaseEmotionAdapter a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getAdapterFromCache type = " + paramEmotionPanelInfo.jdField_a_of_type_Int);
        }
        if ((paramEmotionPanelInfo.jdField_a_of_type_Int != 6) && (paramEmotionPanelInfo.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramEmotionPanelInfo = paramEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramEmotionPanelInfo == null) || (TextUtils.isEmpty(paramEmotionPanelInfo.epId)) || (!this.b.containsKey(paramEmotionPanelInfo.epId)));
      return (BaseEmotionAdapter)this.b.get(paramEmotionPanelInfo.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramEmotionPanelInfo.jdField_a_of_type_Int)));
    return (BaseEmotionAdapter)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramEmotionPanelInfo.jdField_a_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestory");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    EmotionPanelListViewPool.a().a();
    EmotionPanelViewPool.a().a();
  }
  
  public void a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshListViewAdapter panelType = " + i);
      }
      paramEmotionPanelInfo = a(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.b();
    notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setdata");
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void b(EmotionPanelInfo paramEmotionPanelInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = paramEmotionPanelInfo;
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onPageSelected panelType = " + i);
      }
      paramEmotionPanelInfo = a(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
    paramEmotionPanelInfo.c();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroyItem position = " + paramInt);
    }
    if ((paramView == null) || (paramObject == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "container or object = null");
      return;
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    paramView = (EmotionPanelListView)paramObject;
    paramObject = (BaseEmotionAdapter)paramView.a();
    paramView.setAdapter(null);
    paramView.setOnScrollListener(null);
    if (paramObject != null)
    {
      paramInt = ((BaseEmotionAdapter)paramObject).d;
      if ((paramInt != 6) && (paramInt != 10)) {
        break label171;
      }
      EmoticonPackage localEmoticonPackage = ((BaseEmotionAdapter)paramObject).a();
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)) && (this.b.containsKey(localEmoticonPackage.epId))) {
        this.b.remove(localEmoticonPackage.epId);
      }
    }
    for (;;)
    {
      ((BaseEmotionAdapter)paramObject).a();
      EmotionPanelListViewPool.a().a(paramView);
      return;
      label171:
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "getCount count = 0");
    return 0;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "instantiateItem position = " + paramInt);
    }
    EmotionPanelListView localEmotionPanelListView = EmotionPanelListViewPool.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "instantiateItem listview is null");
      return null;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130843567);
    Object localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (EmotionPanelInfo)localObject);
    BaseEmotionAdapter localBaseEmotionAdapter = EmotionPanelListViewAdapterBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((EmotionPanelInfo)localObject).b, i, ((EmotionPanelInfo)localObject).jdField_a_of_type_Int, ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    List localList = EmotionPanelDataBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    if ((localBaseEmotionAdapter == null) || (localList == null) || (localList.size() < 1))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "instantiateItem adapter or data is null or data size < 1: panelType = " + i);
      return null;
    }
    localEmotionPanelListView.setOnScrollListener(new rkr(this, i, localList));
    localBaseEmotionAdapter.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
    localBaseEmotionAdapter.a(localList);
    localBaseEmotionAdapter.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localBaseEmotionAdapter);
    if ((((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6) || (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 10))
    {
      localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localObject != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject).epId))) {
        this.b.put(((EmoticonPackage)localObject).epId, localBaseEmotionAdapter);
      }
    }
    for (;;)
    {
      if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localEmotionPanelListView);
      }
      return localEmotionPanelListView;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "instantiateItem put adapter to map erro");
      continue;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((EmotionPanelInfo)localObject).jdField_a_of_type_Int), localBaseEmotionAdapter);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */