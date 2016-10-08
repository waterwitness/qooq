package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import rrm;
import rrn;
import rrp;
import rrq;
import rrr;
import rrs;
import rrt;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
  public long b;
  public String b;
  public boolean d;
  final int f;
  public int g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public QfileCloudFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 15;
    this.g = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new rrs(this);
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      m();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent == null) {
      l();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((FileManagerUtil.a(FileUtil.a(paramWeiYunFileInfo.jdField_b_of_type_JavaLangString)) != 0) || ((g()) && (((FMDataCache.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label65;
      }
      FMDataCache.a(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      FMDataCache.b(paramWeiYunFileInfo);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new rrm(this);
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().v();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().A();
      continue;
      if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().B();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().x();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().C();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().y();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().D();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().z();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().E();
        }
      }
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new QfileWeiYunImageExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new QfileCloudFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    a(new rrq(this));
  }
  
  protected void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramWeiYunFileInfo);
    }
    a(new rrr(this, paramWeiYunFileInfo));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, 0, 15, MessageCache.a());
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWeiYunFileInfo);
    String str = QfileTimeUtils.b(paramWeiYunFileInfo.jdField_b_of_type_Long);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramWeiYunFileInfo);
    j();
    return true;
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((WeiYunFileInfo)paramArrayList.next());
      }
    }
  }
  
  public void i()
  {
    this.j = false;
    if (!NetworkUtil.h(a()))
    {
      FMToastUtil.a(2131362941);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.g * 15, 15, this.jdField_b_of_type_Long);
    g();
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      v();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    v();
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = new rrn(this);
  }
  
  void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rrp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void n()
  {
    super.n();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void o()
  {
    super.o();
    m();
    if (this.i) {
      j();
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.runOnUiThread(new rrt(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\cloudfile\QfileCloudFileTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */