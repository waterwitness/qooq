package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView.IPtvTemplateItemCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import gxz;
import gya;
import gyb;
import java.util.ArrayList;

public class QAVPtvTemplateAdapter
  extends BaseAdapter
{
  static final float jdField_a_of_type_Float = 5.5F;
  public static final String a = "-1";
  static final float jdField_b_of_type_Float = 0.07F;
  public static final String b = "-2";
  public static final String c = "0";
  int jdField_a_of_type_Int;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  public QAVPtvTemplateAdapter.IEffectCallback a;
  QAVPtvTemplateAdapter.IItemDownloadMgr jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PtvTemplateItemView.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
  public HorizontalListView a;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  public int d;
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.d = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback = new gya(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new gyb(this);
    a(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 5.5F, 0.07F);
  }
  
  public int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / paramFloat);
  }
  
  public int a(int paramInt, float paramFloat)
  {
    return (int)(paramInt * paramFloat);
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.d = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      View localView1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt1);
      View localView2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof PtvTemplateItemView))) {
        ((PtvTemplateItemView)localView1).setHightlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof PtvTemplateItemView))) {
        ((PtvTemplateItemView)localView2).setHightlight(true);
      }
    }
  }
  
  public void a(QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback = paramIEffectCallback;
  }
  
  public void a(QAVPtvTemplateAdapter.IItemDownloadMgr paramIItemDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr = paramIItemDownloadMgr;
  }
  
  void a(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = a(paramFloat1);
    this.jdField_a_of_type_Int = AIOUtils.a(94.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.c = a(this.jdField_b_of_type_Int, paramFloat2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    if (AudioHelper.b()) {
      QLog.d(PtvTemplateManager.a, 4, String.format("initAdapter, mTemplateList[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new gxz(this));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback == null) {}
    while ((!TextUtils.isEmpty(paramPtvTemplateInfo.id)) && (!paramPtvTemplateInfo.id.equals("0")) && (!paramPtvTemplateInfo.usable)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a(paramPtvTemplateInfo);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() > paramInt);
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.jdField_b_of_type_Int;; i = this.jdField_b_of_type_Int * 4)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, -i, 200);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((TextUtils.isEmpty(localPtvTemplateInfo.id)) || (localPtvTemplateInfo.id.equals("0"))) {
      a(localPtvTemplateInfo);
    }
    do
    {
      return;
      if (localPtvTemplateInfo.usable)
      {
        a(localPtvTemplateInfo);
        return;
      }
    } while ((localPtvTemplateInfo.downloading) || (TextUtils.isEmpty(localPtvTemplateInfo.id)));
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localPtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
      localPtvTemplateInfo.downloading = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool = true;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = a(paramInt);
    if (localPtvTemplateInfo == null) {
      paramViewGroup = paramView;
    }
    do
    {
      do
      {
        return paramViewGroup;
        if (!"-1".equals(localPtvTemplateInfo.id)) {
          break;
        }
        paramViewGroup = (ViewGroup)localObject1;
        if (paramView != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          if (paramView.getId() == Integer.valueOf(localPtvTemplateInfo.id).intValue()) {
            paramViewGroup = paramView;
          }
        }
        paramView = paramViewGroup;
        if (paramViewGroup == null)
        {
          paramView = new View(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(Integer.valueOf(localPtvTemplateInfo.id).intValue());
          paramViewGroup = new AbsListView.LayoutParams(this.c, this.jdField_a_of_type_Int);
          paramViewGroup.height = -1;
          paramView.setLayoutParams(paramViewGroup);
        }
        paramViewGroup = paramView;
      } while (!AudioHelper.b());
      paramView.setBackgroundColor(65280);
      return paramView;
      if (!"-2".equals(localPtvTemplateInfo.id)) {
        break;
      }
      paramViewGroup = (ViewGroup)localObject2;
      if (paramView != null)
      {
        paramViewGroup = (ViewGroup)localObject2;
        if (paramView.getId() == Integer.valueOf(localPtvTemplateInfo.id).intValue()) {
          paramViewGroup = paramView;
        }
      }
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(Integer.valueOf(localPtvTemplateInfo.id).intValue());
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int));
      }
      paramViewGroup = paramView;
    } while (!AudioHelper.b());
    paramView.setBackgroundColor(-65536);
    return paramView;
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      if (AudioHelper.b())
      {
        paramView.a(localPtvTemplateInfo);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
        QLog.d("PtvTemplateItemView", 4, String.format("[%s][%s]getView[%s, %s], mFullItemWidth[%s], mListView[%s, %s], itemView[%s, %s], %s", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(paramView.a()), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight()), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()), Integer.valueOf(paramView.getHeight()), localPtvTemplateInfo }));
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label482;
      }
      if (paramInt != this.d) {
        break label476;
      }
    }
    for (;;)
    {
      paramView.a(paramInt, bool, this.jdField_b_of_type_Boolean, localPtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback);
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
      break;
      label476:
      bool = false;
      continue;
      label482:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\QAVPtvTemplateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */