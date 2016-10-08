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

public abstract class OfflineVideoFileViewBase
  extends FileViewBase
{
  private static final String a = "OfflineVideoFileViewBase";
  protected View a;
  
  public OfflineVideoFileViewBase(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904022, paramViewGroup, false);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract OfflineVideoFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131362789);
  }
  
  public void a()
  {
    a().b();
  }
  
  public void c()
  {
    f();
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineVideoFileViewBase", 4, "initVarView: but adapter is null");
      }
    }
    TextView localTextView;
    do
    {
      return;
      h();
      a().c();
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) || (16 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status)) {
        localTextView.setVisibility(8);
      }
      for (;;)
      {
        if ((6 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d()) || (7 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d())) {
          localTextView.setVisibility(4);
        }
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891);
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem()) {
          break;
        }
        localTextView.setText(BaseApplicationImpl.getContext().getString(2131362944));
        return;
        localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
      }
    } while (((!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) || (1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().getCloudType())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status));
    localTextView.setText(BaseApplicationImpl.getContext().getString(2131362871));
  }
  
  public void h()
  {
    AsyncImageView localAsyncImageView = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g() != null)
    {
      localAsyncImageView.setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g());
      return;
    }
    localAsyncImageView.setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\OfflineVideoFileViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */