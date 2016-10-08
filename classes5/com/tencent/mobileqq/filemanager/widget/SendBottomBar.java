package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qlink.QQProxyForQlink;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import skh;
import ski;
import skm;
import skn;
import sko;

public class SendBottomBar
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  public QQProgressDialog a;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new skh(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ski(this);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130904005, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new skh(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ski(this);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130904005, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.jdField_a_of_type_AndroidContentContext);
    this.d = ((TextView)findViewById(2131300975));
    this.e = ((TextView)findViewById(2131300976));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297875));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.c = ((TextView)findViewById(2131300974));
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("确定");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  private void e()
  {
    boolean bool = false;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    ArrayList localArrayList = FMDataCache.b();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((ArrayList)localObject1).add(((FileInfo)localArrayList.get(i)).d());
      i += 1;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if (222 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
      return;
      if ((333 == i) || (666 == i))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
      else if ((444 == i) || (555 == i))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
        if (444 == i) {
          bool = true;
        }
        ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
        ((Intent)localObject2).putExtra("string_filepaths", (Serializable)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
      else if ((777 == i) || (888 == i))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("string_filepaths", (ArrayList)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 16, (Bundle)localObject2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, (List)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
        ((Intent)localObject1).putExtra("_UIN_", (String)localObject2);
        ((Intent)localObject1).putExtra("_SEND_QLINK_FILE_", true);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
      }
    }
  }
  
  private void f()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131366156, 2131366157, new skm(this));
      return;
    }
    e();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public void a()
  {
    boolean bool3 = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c();
    Object localObject1 = localObject2;
    label239:
    boolean bool1;
    if (localObject2 == null)
    {
      if (i == 5) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364081) + this.jdField_a_of_type_AndroidContentContext.getString(2131362859) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362860);
      }
    }
    else
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131362760) + FileUtil.a(FMDataCache.c());
      localObject2 = str;
      if (FMDataCache.d() > 0L) {
        localObject2 = str + this.jdField_a_of_type_AndroidContentContext.getString(2131362761) + FileUtil.a(FMDataCache.d());
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
      {
      default: 
        i = this.c.getVisibility();
        if ((i == 4) || (i == 8))
        {
          this.e.setVisibility(0);
          this.d.setVisibility(8);
          this.e.setText((CharSequence)localObject2);
          if (FileManagerUtil.a() == null) {
            break label575;
          }
          bool1 = true;
          label248:
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b()) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText("确定");
          }
          localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
          if (FMDataCache.a() <= 0L) {
            break label581;
          }
          bool2 = true;
          label292:
          ((TextView)localObject1).setEnabled(bool2);
          this.c.setEnabled(bool1);
          localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
          if (FMDataCache.a() <= 0L) {
            break label587;
          }
        }
        break;
      }
    }
    label575:
    label581:
    label587:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      ((TextView)localObject1).setSelected(bool2);
      this.c.setSelected(bool1);
      return;
      if (i == 6001)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362756) + this.jdField_a_of_type_AndroidContentContext.getString(2131362859) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362860);
        break;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362751) + this.jdField_a_of_type_AndroidContentContext.getString(2131362859) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362860);
      break;
      i = this.c.getVisibility();
      if ((i == 4) || (i == 8))
      {
        this.e.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setText(2131366155);
        break label239;
      }
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.d.setText(2131366155);
      break label239;
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.d.setText((CharSequence)localObject2);
      break label239;
      bool1 = false;
      break label248;
      bool2 = false;
      break label292;
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      c();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131492908));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("请稍后...");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((FileManagerUtil.a()) && (paramBoolean))
    {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362855, 2131362851, new skn(this));
      return;
    }
    b();
  }
  
  public void b()
  {
    a(2131370345);
    new Handler().postDelayed(new sko(this), 100L);
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.c;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\SendBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */