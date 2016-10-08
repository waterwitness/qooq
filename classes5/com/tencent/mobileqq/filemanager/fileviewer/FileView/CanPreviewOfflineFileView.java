package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ser;

public class CanPreviewOfflineFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private FileManagerUtil.TipsClickedInterface jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$TipsClickedInterface;
  private final String jdField_a_of_type_JavaLangString;
  private TextView b;
  private TextView c;
  
  public CanPreviewOfflineFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "CanPreviewOfflineFileView";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$TipsClickedInterface = new ser(this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("CanPreviewOfflineFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888)).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) || (16 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status)) {
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300909));
      localObject = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131362844), BaseApplicationImpl.getContext().getString(2131362844), this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$TipsClickedInterface);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301009));
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891));
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (((!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) || (1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().getCloudType())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status)) {
        break;
      }
      this.c.setText(BaseApplicationImpl.getContext().getString(2131362871));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
    }
    if ((localObject != null) && (((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setText(BaseApplicationImpl.getContext().getString(2131362944));
      return;
    }
    if (NetworkUtil.i(BaseApplication.getContext()))
    {
      this.c.setText(BaseApplicationImpl.getContext().getString(2131362849));
      return;
    }
    this.c.setText(BaseApplicationImpl.getContext().getString(2131362850));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904016, paramViewGroup, false);
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
    this.jdField_b_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\CanPreviewOfflineFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */