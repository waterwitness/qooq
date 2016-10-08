package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import sfb;

public class LocalSimpleFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TbsReaderView jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public LocalSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "LocalSimpleFileView";
    this.jdField_b_of_type_JavaLangString = "REQ_FEATURE_ID";
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalSimpleFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = LocalTbsViewManager.a().a(this.jdField_b_of_type_AndroidAppActivity, (String)localObject, new sfb(this));
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
      return;
    }
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904017, this.jdField_a_of_type_AndroidViewViewGroup, false);
    localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300888);
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(str));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(str);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890)).setText(b());
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891);
    BaseApplicationImpl.getContext().getString(2131362871);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() == 16) {
      localObject = BaseApplicationImpl.getContext().getString(2131362871);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      str = BaseApplicationImpl.getContext().getString(2131362839);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 7)
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 6) {}
      }
      else
      {
        localObject = str;
        if (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b()))
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)
          {
            localObject = str;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bSend) {
              localObject = BaseApplicationImpl.getContext().getString(2131369299);
            }
          }
        }
      }
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView instanceof TbsReaderView))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      this.jdField_a_of_type_Boolean = true;
    }
    return str;
  }
  
  public void a()
  {
    LocalTbsViewManager.a().a(this.jdField_b_of_type_AndroidAppActivity);
    super.a();
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null)
    {
      paramConfiguration = new DisplayMetrics();
      this.jdField_b_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
      int i = paramConfiguration.widthPixels;
      int j = paramConfiguration.heightPixels;
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onSizeChanged(i, j);
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.removeAllViews();
    f();
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null)
    {
      paramRelativeLayout = new DisplayMetrics();
      this.jdField_b_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramRelativeLayout);
      int i = paramRelativeLayout.widthPixels;
      int j = paramRelativeLayout.heightPixels;
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onSizeChanged(i, j);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    if ((104 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().lastTime > 0L))
    {
      localStringBuffer.append(BaseApplicationImpl.getContext().getString(2131362770));
      localStringBuffer.append(TroopFileUtils.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().lastTime));
    }
    return localStringBuffer.toString();
  }
  
  public void b() {}
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidAppActivity.setRequestedOrientation(1);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\LocalSimpleFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */