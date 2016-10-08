package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FileViewBase
{
  protected IFileViewListener a;
  protected IFileViewerAdapter a;
  protected Activity b;
  
  public FileViewBase(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramActivity;
  }
  
  public abstract View a(ViewGroup paramViewGroup);
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
  }
  
  public void a() {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(RelativeLayout paramRelativeLayout) {}
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = paramIFileViewListener;
  }
  
  public void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = paramIFileViewerAdapter;
  }
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract void c();
  
  public void d() {}
  
  public void e() {}
  
  public void g() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */