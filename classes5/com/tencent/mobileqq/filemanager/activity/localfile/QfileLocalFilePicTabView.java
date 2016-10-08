package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import rtu;
import rtv;
import rtx;
import rty;
import rtz;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  QfileLocalImageExpandableListAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
  private IClickListener_Ver51 b;
  
  public QfileLocalFilePicTabView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new rtz(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new rtu(this, paramContext);
    ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((paramFileInfo.b() != 0) || ((g()) && (((FMDataCache.a(paramFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label59;
      }
      FMDataCache.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label59:
      FMDataCache.b(paramFileInfo);
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter = new QfileLocalImageExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  }
  
  protected void a()
  {
    ThreadManager.a().post(new rtv(this));
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new rtx(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    j();
    return true;
  }
  
  public void g(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileInfo)paramArrayList.next());
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.runOnUiThread(new rty(this));
  }
  
  public void k()
  {
    super.k();
    setEditbarButton(true, false, true, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().W();
    }
    for (;;)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().ab();
    }
  }
  
  protected void l()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a();
    a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\localfile\QfileLocalFilePicTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */