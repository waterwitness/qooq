package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import rtn;
import rto;
import rtq;

public class QfileLocalFileMediaTabView
  extends QfileBaseLocalFileTabView
{
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  private IClickListener_Ver51 b;
  private int i;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = 3;
    setEditbarButton(false, false, true, true, true);
    this.i = paramInt;
    this.jdField_a_of_type_JavaLangRunnable = new rtn(this, paramInt, paramContext);
    ThreadManager.c(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileLocalFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new rto(this);
    ThreadManager.c(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new rtq(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
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
  
  protected void i()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a();
    a(true);
  }
  
  public void k()
  {
    super.k();
    setEditbarButton(false, false, true, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().U();
    }
    for (;;)
    {
      h();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().Z();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\localfile\QfileLocalFileMediaTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */