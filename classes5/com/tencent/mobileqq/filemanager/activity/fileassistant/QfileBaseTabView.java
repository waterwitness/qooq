package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import rru;

public class QfileBaseTabView
  extends RelativeLayout
  implements IBaseTabViewEvent
{
  protected QQAppInterface a;
  public FMActivity a;
  protected Runnable a;
  View d;
  boolean e;
  protected boolean f = true;
  public boolean g = true;
  
  public QfileBaseTabView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity = ((FMActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected BaseFileAssistantActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity;
  }
  
  protected String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(paramInt);
  }
  
  protected void a(int paramInt)
  {
    this.d = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.d);
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void a(FileManagerEntity paramFileManagerEntity) {}
  
  protected void a(Runnable paramRunnable)
  {
    a().runOnUiThread(paramRunnable);
  }
  
  public void a(ArrayList paramArrayList) {}
  
  public boolean a(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaLangRunnable == null;
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected boolean d()
  {
    return this.g;
  }
  
  public void e(ArrayList paramArrayList) {}
  
  protected boolean e()
  {
    return a().c();
  }
  
  public void f(ArrayList paramArrayList) {}
  
  protected boolean f()
  {
    return a().e();
  }
  
  public void g(ArrayList paramArrayList) {}
  
  protected boolean g()
  {
    return (f()) || (e());
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public void j() {}
  
  public void k() {}
  
  public void n() {}
  
  public void o() {}
  
  public void q() {}
  
  public void r()
  {
    this.f = false;
  }
  
  protected void s()
  {
    this.g = false;
    new Handler().postDelayed(new rru(this), 1500L);
  }
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
  
  public void t()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  protected void u()
  {
    a().k();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\fileassistant\QfileBaseTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */