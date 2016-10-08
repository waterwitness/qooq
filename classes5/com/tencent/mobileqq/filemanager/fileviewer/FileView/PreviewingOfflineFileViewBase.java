package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public abstract class PreviewingOfflineFileViewBase
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "PreviewingOfflineFileViewBase<FileAssistant>";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private FilePreviewDataReporter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
  private FilePreviewAnimQueue jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue;
  FileWebView.JSInterface jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface;
  private FileWebView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
  private Timer jdField_a_of_type_JavaUtilTimer;
  protected boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FilePreviewAnimQueue jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue;
  private Timer jdField_b_of_type_JavaUtilTimer;
  protected boolean b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public PreviewingOfflineFileViewBase(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = null;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.w("PreviewingOfflineFileViewBase<FileAssistant>", 4, "initVarView: but adapter is invalid");
      }
    }
    do
    {
      return;
      ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888)).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) || (16 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status)) {
        localTextView.setVisibility(8);
      }
      for (;;)
      {
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891);
        if (((!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) || (1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().getCloudType())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status)) {
          break;
        }
        localTextView.setVisibility(0);
        return;
        localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
      }
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()))
      {
        localTextView.setVisibility(0);
        localTextView.setText(BaseApplicationImpl.getContext().getString(2131362944));
        return;
      }
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d(false);
  }
  
  private void h()
  {
    String str = BaseApplicationImpl.getContext().getString(2131362845) + "(" + this.jdField_a_of_type_Int + "%)";
    this.e.setText(str);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904025, paramViewGroup, false);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract PreviewingOfflineFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.a();
    }
    return BaseApplicationImpl.getContext().getString(2131362789);
  }
  
  public void a()
  {
    this.f = true;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) && (this.jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a();
    }
    return true;
  }
  
  public void c()
  {
    f();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onResume();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onPause();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\PreviewingOfflineFileViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */