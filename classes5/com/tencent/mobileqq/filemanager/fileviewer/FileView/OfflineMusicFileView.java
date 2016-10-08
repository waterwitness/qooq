package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class OfflineMusicFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString;
  
  public OfflineMusicFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "OfflineMusicFileViewer";
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineMusicFileViewer", 4, "initVarView: but adapter is null");
      }
    }
    TextView localTextView;
    do
    {
      return;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem())
      {
        localTextView.setText(BaseApplicationImpl.getContext().getString(2131362944));
        return;
      }
    } while ((!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) || (1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().getCloudType()));
    localTextView.setText(BaseApplicationImpl.getContext().getString(2131362871));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904021, paramViewGroup, false);
    paramViewGroup = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) {
      paramViewGroup.setVisibility(8);
    }
    for (;;)
    {
      ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131301022)).setEnabled(false);
      f();
      float f;
      if (FontSettingManager.a() > 17.0F)
      {
        paramViewGroup = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301021);
        f = this.b.getResources().getDisplayMetrics().density;
        paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams((int)(150.0F * f), (int)(f * 150.0F)));
      }
      if (FontSettingManager.a() > 17.0F)
      {
        paramViewGroup = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301021);
        f = this.b.getResources().getDisplayMetrics().density;
        paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams((int)(150.0F * f), (int)(f * 150.0F)));
      }
      return this.jdField_a_of_type_AndroidViewView;
      paramViewGroup.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
    }
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131362789);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\OfflineMusicFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */