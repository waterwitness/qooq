package com.tencent.mobileqq.unifiedebug;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.MobileQQ;
import vwk;
import vwl;
import vwn;
import vwo;
import vwp;
import vwq;
import vwr;

public class SnapshotService
  extends IphoneTitleBarActivity
{
  public static final int a = 0;
  public static final String a = "android.intent.action.ultimatesnapshot";
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  private static String jdField_b_of_type_JavaLangString = "SnapshotService";
  public static final int c = 2;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new vwo(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private vwr jdField_a_of_type_Vwr;
  private vwr jdField_b_of_type_Vwr;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Bitmap paramBitmap, vwp paramvwp, vwr paramvwr)
  {
    int j = 1;
    if ((paramvwr == null) || (paramvwr.jdField_a_of_type_Vwq == null) || (paramvwr.jdField_a_of_type_Vwq.a.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = paramvwr.jdField_a_of_type_Vwq.a.getX5WebViewExtension().getClass().getInterfaces();
    int k = localObject1.length;
    int i = 0;
    label69:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!"com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(((Class)localObject2).getName())) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Class)localObject2).getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap");
        }
        ((Method)localObject1).invoke(paramvwr.jdField_a_of_type_Vwq.a.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new vwl(this, paramBitmap, paramvwp, paramvwr) });
        i = j;
      }
      catch (Exception paramBitmap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_b_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap failed: " + paramBitmap.getMessage());
        i = 0;
        continue;
      }
      if (i != 0) {
        break;
      }
      if (paramvwr.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", paramvwp.jdField_a_of_type_Long);
        paramvwr.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  private void a(vwp paramvwp, vwr paramvwr)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vwk(this, paramvwr, paramvwp), paramvwr.jdField_a_of_type_Long);
  }
  
  private void a(vwr paramvwr)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    vwp localvwp = (vwp)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localvwp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "current cmd=" + localvwp.jdField_a_of_type_Long);
      }
      a(localvwp, paramvwr);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    vwp localvwp = new vwp();
    localvwp.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localvwp.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localvwp.b = ???.getIntExtra("maxSnapshotCount", 5);
    localvwp.jdField_a_of_type_Int = 0;
    localvwp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localvwp.jdField_a_of_type_Long);
    }
    if (localvwp.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localvwp);
        a(this.jdField_a_of_type_Vwr);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localvwp);
    }
  }
  
  private boolean a(Intent paramIntent, vwr paramvwr)
  {
    vwr.a(paramvwr, paramIntent.getLongExtra("id", -1L));
    paramvwr.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramvwr.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    paramvwr.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramvwr.jdField_a_of_type_JavaLangString))
    {
      paramvwr.jdField_b_of_type_JavaLangString = (vwr.a(paramvwr) + MD5Utils.d(paramvwr.jdField_a_of_type_JavaLangString));
      if (!paramvwr.jdField_a_of_type_JavaLangString.startsWith("http://")) {
        paramvwr.jdField_a_of_type_JavaLangString = ("http://" + paramvwr.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    return false;
  }
  
  private void b(Bitmap paramBitmap, vwp paramvwp, vwr paramvwr)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramvwr = new StringBuilder().append("/Snapshot_").append(paramvwr.jdField_b_of_type_JavaLangString).append("_");
      int i = paramvwp.jdField_a_of_type_Int;
      paramvwp.jdField_a_of_type_Int = (i + 1);
      paramvwr = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(paramvwr);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramvwp.jdField_a_of_type_JavaUtilArrayList.add(paramvwr.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + paramvwr.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void b(vwp arg1, vwr paramvwr)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "finish once debug, webview id =" + vwr.a(paramvwr) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (paramvwr.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = paramvwr.jdField_a_of_type_AndroidOsResultReceiver;
      if (vwr.a(paramvwr) <= 0L) {
        break label165;
      }
      i = 1;
    }
    for (;;)
    {
      ???.send(i, localBundle);
      synchronized (this.jdField_a_of_type_JavaUtilQueue)
      {
        if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) {
          this.jdField_a_of_type_JavaUtilQueue.remove();
        }
        if (this.jdField_a_of_type_Long > 0L)
        {
          a(paramvwr);
          return;
          label165:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void c(vwp paramvwp, vwr paramvwr)
  {
    if ((paramvwr.jdField_a_of_type_Vwq.a.getWidth() <= 0) || (paramvwr.jdField_a_of_type_Vwq.a.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + paramvwr.jdField_a_of_type_Vwq.a.getWidth() + ", height=" + paramvwr.jdField_a_of_type_Vwq.a.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramvwr.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", paramvwr.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", paramvwp.b);
        ((Bundle)localObject).putLong("delay", paramvwr.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", paramvwp.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", paramvwp.jdField_a_of_type_JavaLangString);
        paramvwr.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(paramvwr.jdField_a_of_type_Vwq.a.getWidth(), paramvwr.jdField_a_of_type_Vwq.a.getHeight(), Bitmap.Config.ARGB_8888);
    if (paramvwr.jdField_a_of_type_Vwq.a.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, paramvwp, paramvwr);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramvwr.jdField_a_of_type_Vwq.a.draw(localCanvas);
    if (paramvwp.jdField_a_of_type_Int == 0) {
      paramvwp.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(paramvwp, paramvwr);
      return;
      b((Bitmap)localObject, paramvwp, paramvwr);
    }
  }
  
  private void d(vwp paramvwp, vwr paramvwr)
  {
    int j;
    int i;
    boolean bool;
    if (paramvwr.jdField_a_of_type_Vwq.a.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label216;
      }
      i = paramvwr.jdField_a_of_type_Vwq.a.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + paramvwr.jdField_a_of_type_Vwq.a.getWidth() + ", height=" + paramvwr.jdField_a_of_type_Vwq.a.getHeight());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      paramvwr.jdField_a_of_type_Vwq.a.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label232;
      }
      i = paramvwp.b;
      label169:
      if (paramvwp.jdField_a_of_type_Int >= i) {
        break label242;
      }
      i = 1;
      label179:
      if (j == 0) {
        break label247;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label274;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vwn(this, paramvwp, paramvwr), 3000L);
      return;
      j = 0;
      break;
      label216:
      bool = paramvwr.jdField_a_of_type_Vwq.a.pageDown(false);
      break label159;
      label232:
      i = paramvwp.b + 1;
      break label169;
      label242:
      i = 0;
      break label179;
      label247:
      if ((paramvwp.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label274:
    b(paramvwp, paramvwr);
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "in onDestroy method()");
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.jdField_a_of_type_JavaUtilQueue = null;
    super.doOnDestroy();
    if (this.jdField_a_of_type_Vwr != null) {
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.c();
    }
    if (this.jdField_b_of_type_Vwr != null) {
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Vwr != null) {
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.b();
    }
    if (this.jdField_b_of_type_Vwr != null) {
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.b();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)((MobileQQ)super.getApplicationContext()).waitAppRuntime(null));
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "app == null");
      }
      super.finish();
    }
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Vwr = new vwr(this);
      if (!a(getIntent(), this.jdField_a_of_type_Vwr)) {
        finish();
      }
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq = new vwq(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a, new ViewGroup.LayoutParams(-1, -1));
      super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      super.moveTaskToBack(true);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onCreate");
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        break label402;
      }
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a(this.jdField_a_of_type_Vwr.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label402:
    do
    {
      return;
      this.jdField_b_of_type_Vwr = new vwr(this);
      if (!a(getIntent(), this.jdField_b_of_type_Vwr)) {
        finish();
      }
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq = new vwq(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a(this.jdField_b_of_type_Vwr.jdField_a_of_type_JavaLangString);
      paramBundle = new vwp();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + paramBundle.jdField_a_of_type_Long);
      }
    } while (paramBundle.jdField_a_of_type_Long == -1L);
    a(paramBundle, this.jdField_b_of_type_Vwr);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.jdField_b_of_type_Vwr == null)
      {
        this.jdField_b_of_type_Vwr = new vwr(this);
        this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq = new vwq(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.jdField_b_of_type_Vwr);
      vwp localvwp = new vwp();
      localvwp.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localvwp.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localvwp.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localvwp.jdField_a_of_type_Int = 0;
      localvwp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localvwp.jdField_a_of_type_Long);
      }
      if (localvwp.jdField_a_of_type_Long != -1L)
      {
        this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a(this.jdField_b_of_type_Vwr.jdField_a_of_type_JavaLangString);
        a(localvwp, this.jdField_b_of_type_Vwr);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Vwr == null)
        {
          this.jdField_a_of_type_Vwr = new vwr(this);
          this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq = new vwq(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a, new ViewGroup.LayoutParams(-1, -1));
        }
        switch (paramIntent.getIntExtra("action", 2))
        {
        case 1: 
        default: 
          return;
        }
      } while (l != this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "onNewIntent(), just snapshot for loaded url");
      }
      a(paramIntent);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "onNewIntent(), load url");
      }
      if (!jdField_a_of_type_Boolean)
      {
        paramIntent = new IntentFilter("android.intent.action.ultimatesnapshot");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
        }
      }
      jdField_a_of_type_Boolean = true;
    } while ((!a(getIntent(), this.jdField_a_of_type_Vwr)) || (!a(getIntent())));
    this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a(this.jdField_a_of_type_Vwr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Vwr != null) {
      this.jdField_a_of_type_Vwr.jdField_a_of_type_Vwq.a();
    }
    if (this.jdField_b_of_type_Vwr != null) {
      this.jdField_b_of_type_Vwr.jdField_a_of_type_Vwq.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\SnapshotService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */