package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import pda;
import pdb;
import pdc;
import pdf;
import pdg;

public class PtvTemplateAdapter
  extends BaseAdapter
{
  public static final float a = 4.5F;
  static final String jdField_a_of_type_JavaLangString = "-1";
  public static final float b = 0.75F;
  static final String b = "-2";
  public static final int c = 1001;
  public static final String c = "0";
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback;
  public FSurfaceViewLayout a;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
  PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  public HorizontalListView a;
  public ArrayList a;
  public int b;
  float c;
  public String d;
  
  public PtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView, FSurfaceViewLayout paramFSurfaceViewLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.d = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new pda(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback = new pdb(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new pdc(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new pdf(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = paramFSurfaceViewLayout;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = PtvTemplateManager.a(paramAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramAppInterface = new PtvTemplateManager.PtvTemplateInfo();
    paramAppInterface.id = "-1";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAppInterface);
    paramAppInterface = new PtvTemplateManager.PtvTemplateInfo();
    paramAppInterface.id = "0";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAppInterface);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    paramAppInterface = new PtvTemplateManager.PtvTemplateInfo();
    paramAppInterface.id = "-2";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAppInterface);
    paramAppInterface = new PtvTemplateManager.PtvTemplateInfo();
    paramAppInterface.id = "-1";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAppInterface);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
  }
  
  public int a()
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 4.5F);
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + 1;
    if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).id)) && (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals("0"))) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter("");
          this.d = "";
        } while (!QLog.isColorLevel());
        QLog.i(PtvTemplateManager.a, 2, "setVideoFilter null");
        return;
        if (!((PtvTemplateManager.PtvTemplateInfo)localObject).usable) {
          break;
        }
        localObject = PtvTemplateManager.g + ((PtvTemplateManager.PtvTemplateInfo)localObject).name;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout == null);
      if (QLog.isColorLevel()) {
        QLog.i(PtvTemplateManager.a, 2, "setVideoFilter " + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject);
      this.d = ((String)localObject);
      return;
    } while ((((PtvTemplateManager.PtvTemplateInfo)localObject).downloading) || (TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (PtvTemplateManager.PtvTemplateInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
    ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
  }
  
  public void b()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(2);
    if (localPtvTemplateInfo.usable) {}
    while ((localPtvTemplateInfo.downloading) || (TextUtils.isEmpty(localPtvTemplateInfo.id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localPtvTemplateInfo, new pdg(this));
    localPtvTemplateInfo.downloading = true;
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
    paramViewGroup = a(paramInt);
    if ("-1".equals(paramViewGroup.id))
    {
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams((int)(this.jdField_a_of_type_Int * 0.75F), this.jdField_a_of_type_Int));
      return paramView;
    }
    if ("-2".equals(paramViewGroup.id))
    {
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      return paramView;
    }
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback);
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\PtvTemplateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */