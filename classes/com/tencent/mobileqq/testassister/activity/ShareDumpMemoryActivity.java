package com.tencent.mobileqq.testassister.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import uyz;
import uza;
import uzb;
import uzc;

public class ShareDumpMemoryActivity
  extends BaseActivity
{
  public static final String a = "showWarningDialog";
  public static final String b = "suspiciousName";
  public static final String c = "dumpFilePath";
  public static final String d = "leaked";
  private static final String e = "LeakInspector";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private String f;
  private String g;
  
  public ShareDumpMemoryActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
  }
  
  public static ProgressDialog a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130842887);
    paramContext = new ProgressDialog(paramContext, 2131558973);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903052);
    paramContext.setContentView(2130903052);
    ((TextView)paramContext.findViewById(2131296852)).setText(2131369309);
    ((ProgressBar)paramContext.findViewById(2131296851)).setIndeterminateDrawable(localDrawable);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("以下对象存在内存泄露：\n");
    localStringBuffer.append(this.f);
    localStringBuffer.append("\n\n发现内存泄漏，请及时反馈。\n点击发送开始dump。\n文件路径:SD卡/tencent/MobileQQ/log\n时间：");
    localStringBuffer.append(new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss").format(new Date(System.currentTimeMillis())));
    return localStringBuffer.toString();
  }
  
  private void c()
  {
    Object localObject;
    Dialog localDialog;
    if (this.b)
    {
      localObject = "内存泄漏告警(内测)";
      localDialog = new Dialog(this, 2131558973);
      localDialog.setContentView(2130903236);
      TextView localTextView = (TextView)localDialog.findViewById(2131297840);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131296852));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (!this.b) {
          break label173;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
      }
    }
    for (;;)
    {
      localObject = (TextView)localDialog.findViewById(2131297843);
      if (localObject != null)
      {
        ((TextView)localObject).setText(2131367262);
        ((TextView)localObject).setOnClickListener(new uyz(this, localDialog));
      }
      localObject = (TextView)localDialog.findViewById(2131297844);
      if (localObject != null)
      {
        ((TextView)localObject).setText(2131370828);
        ((TextView)localObject).setOnClickListener(new uza(this, localDialog));
      }
      localDialog.show();
      localDialog.setOnCancelListener(new uzb(this));
      return;
      localObject = "导出进程内存";
      break;
      label173:
      this.jdField_a_of_type_AndroidWidgetTextView.setText("是否dump内存信息并发送");
    }
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = new FileInfo(this.g);
      Object localObject3 = FileManagerUtil.a((FileInfo)localObject1);
      Object localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject3).nSessionId);
      ((ForwardFileInfo)localObject2).d(3);
      ((ForwardFileInfo)localObject2).b(10000);
      ((ForwardFileInfo)localObject2).a(((FileInfo)localObject1).d());
      ((ForwardFileInfo)localObject2).d(((FileInfo)localObject1).e());
      ((ForwardFileInfo)localObject2).d(((FileInfo)localObject1).a());
      localObject3 = new Bundle();
      ((Bundle)localObject3).putParcelable("fileinfo", (Parcelable)localObject2);
      ((Bundle)localObject3).putBoolean("not_forward", true);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras((Bundle)localObject3);
      ((Intent)localObject1).putExtra("forward_text", ((ForwardFileInfo)localObject2).d());
      ((Intent)localObject1).putExtra("forward_type", 0);
      ((Intent)localObject1).putExtra("forward _key_nojump", true);
      ((Intent)localObject1).setAction("android.intent.action.SEND");
      ((Intent)localObject1).setClass(this, JumpActivity.class);
      localObject2 = Uri.fromFile(new File(this.g));
      ((Intent)localObject1).putExtra("android.intent.extra.STREAM", (Parcelable)localObject2);
      ((Intent)localObject1).setDataAndType((Uri)localObject2, "application/x-zip-compressed");
      localObject2 = new ConcurrentHashMap(2);
      localObject3 = new HashMap(1);
      ((HashMap)localObject3).put("fileObj1", this.g);
      HashMap localHashMap = new HashMap(7);
      localHashMap.put("plugin", String.valueOf(7));
      ((ConcurrentHashMap)localObject2).put("fileObj", localObject3);
      ((ConcurrentHashMap)localObject2).put("clientinfo", localHashMap);
      localObject2 = new ResultObject(0, "testcase", true, 1L, 1L, (ConcurrentHashMap)localObject2, true, true, MagnifierSDK.a);
      if (BaseApplicationImpl.i == 1)
      {
        ReporterMachine.a(1);
        ReporterMachine.a(null, (ResultObject)localObject2);
      }
      for (;;)
      {
        startActivity((Intent)localObject1);
        return;
        ReporterMachine.a(1);
        ReporterMachine.a(BaseApplicationImpl.a(), (ResultObject)localObject2);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b()
  {
    ProgressDialog localProgressDialog = a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new uzc(this, localProgressDialog), 100L);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      finish();
      return;
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2130903420);
    paramBundle = getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("showWarningDialog", false);
    this.f = paramBundle.getStringExtra("suspiciousName");
    this.g = paramBundle.getStringExtra("dumpFilePath");
    this.b = paramBundle.getBooleanExtra("leaked", true);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.a());
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      return true;
    }
    a();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.b) {
      LeakInspector.a(this.f);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\testassister\activity\ShareDumpMemoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */