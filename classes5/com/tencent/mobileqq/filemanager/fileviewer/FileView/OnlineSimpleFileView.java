package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFileView
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OnlineSimpleFileView";
  private View jdField_a_of_type_AndroidViewView;
  
  public OnlineSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f())
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f() + "not implemented");
      }
      break;
    }
    do
    {
      do
      {
        return null;
        switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e())
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() + "not implemented");
      return null;
      return BaseApplicationImpl.getContext().getString(2131362877);
      return BaseApplicationImpl.getContext().getString(2131362878);
      return BaseApplicationImpl.getContext().getString(2131362879);
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() + "not implemented");
    return null;
    return BaseApplicationImpl.getContext().getString(2131362880);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OnlineSimpleFileView", 4, "initVarView: but adapter is null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888);
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(str));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(FileManagerUtil.d(str));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
      localObject = b();
    } while (localObject == null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891)).setText((CharSequence)localObject);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904017, paramViewGroup, false);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b() {}
  
  public boolean b()
  {
    this.b.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\OnlineSimpleFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */