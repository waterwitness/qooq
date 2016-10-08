package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class OfflineSimpleFileView
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineSimpleFileView";
  private View jdField_a_of_type_AndroidViewView;
  
  public OfflineSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineSimpleFileView", 4, "initVarView: but adapter is null");
      }
    }
    Object localObject;
    label287:
    label303:
    do
    {
      return;
      localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888);
      if (5 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b())
      {
        ((AsyncImageView)localObject).setDefaultImage(2130840343);
        ((AsyncImageView)localObject).setApkIconAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d());
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 7)) {
          break label287;
        }
        ((TextView)localObject).setVisibility(8);
      }
      for (;;)
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301007);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891);
        if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b()) {
          ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362810));
        }
        if (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status) {
          break label303;
        }
        ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362871));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g() != null)
        {
          ((AsyncImageView)localObject).setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g());
          break;
        }
        ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
        break;
        ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem())
      {
        ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362944));
        return;
      }
      if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) && (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().getCloudType()))
      {
        ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362871));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() > this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d());
    ((TextView)localObject).setVisibility(8);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904015, paramViewGroup, false);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\OfflineSimpleFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */