package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.WeiYunPreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalApkFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OnlineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.filemanager.fileviewer.report.FileClickReport;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import sef;
import seg;
import seh;
import sei;
import sem;
import seo;
import sep;
import seq;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements IFileBrowser
{
  static final String jdField_a_of_type_JavaLangString = "FileBrowserActivity<FileAssistant>";
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  public ActionBarManager a;
  protected BaseActionBar.IActionBarClickEvent a;
  public FileViewBase a;
  private ForwardData jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData;
  public IFileViewListener a;
  public IFileViewReport a;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  public List a;
  public boolean a;
  public int b;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  protected int c;
  private boolean c;
  
  public FileBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 10000;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new seg(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = new seo(this);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static void a(Object paramObject, String paramString, FileBrowserActivity.TypedObject... paramVarArgs)
  {
    int i = 0;
    if (paramObject == null) {
      return;
    }
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramVarArgs == null) {}
      for (Object[] arrayOfObject = new Object[0];; arrayOfObject = new Object[paramVarArgs.length])
      {
        if (paramVarArgs == null) {
          break label93;
        }
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].a();
          arrayOfObject[i] = paramVarArgs[i].a();
          i += 1;
        }
        arrayOfClass = new Class[paramVarArgs.length];
        break;
      }
      label93:
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface.getApplication().getBaseContext(), paramIFileViewerAdapter.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
      return FileManagerUtil.a(i);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private FileViewBase g()
  {
    LocalApkFileView localLocalApkFileView = new LocalApkFileView(this);
    localLocalApkFileView.a(a());
    return localLocalApkFileView;
  }
  
  private boolean g()
  {
    this.jdField_a_of_type_Int = 2;
    Object localObject = FileViewMusicService.a();
    this.jdField_a_of_type_JavaUtilList = ((FileViewMusicService)localObject).a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    this.jdField_b_of_type_Int = ((FileViewMusicService)localObject).a();
    a(a());
    setContentViewNoTitle(2130904019);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
    a().addView((View)localObject);
    return true;
  }
  
  private FileViewBase h()
  {
    LocalSimpleFileView localLocalSimpleFileView = new LocalSimpleFileView(this);
    localLocalSimpleFileView.a(a());
    return localLocalSimpleFileView;
  }
  
  private FileViewBase i()
  {
    boolean bool2 = true;
    LocalMusicFileView localLocalMusicFileView = new LocalMusicFileView(this);
    IFileViewerAdapter localIFileViewerAdapter = a();
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_b_of_type_Int > 0)
      {
        bool1 = true;
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label78;
        }
      }
    }
    for (;;)
    {
      localIFileViewerAdapter.e(bool1);
      localIFileViewerAdapter.f(bool2);
      localLocalMusicFileView.a(localIFileViewerAdapter);
      return localLocalMusicFileView;
      bool1 = false;
      break;
      label78:
      bool2 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  private FileViewBase j()
  {
    OnlineSimpleFileView localOnlineSimpleFileView = new OnlineSimpleFileView(this);
    localOnlineSimpleFileView.a(a());
    return localOnlineSimpleFileView;
  }
  
  private void j()
  {
    Object localObject = getSystemService("input_method");
    a(localObject, "windowDismissed", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(getWindow().getDecorView().getWindowToken(), IBinder.class) });
    a(localObject, "startGettingWindowFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(null, View.class) });
  }
  
  private FileViewBase k()
  {
    PreviewingOfflineFileView localPreviewingOfflineFileView = new PreviewingOfflineFileView(this, this.app);
    localPreviewingOfflineFileView.a(a());
    return localPreviewingOfflineFileView;
  }
  
  private void k()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(localRelativeLayout, View.class) });
  }
  
  private void l()
  {
    ImageView localImageView = (ImageView)findViewById(2131297392);
    localImageView.setVisibility(8);
    IFileViewerAdapter localIFileViewerAdapter = a();
    int i = localIFileViewerAdapter.d();
    if (((3 != i) && (5 != i) && ((6 != i) || (!FileUtil.a(localIFileViewerAdapter.b())))) || (a()) || (e())) {}
    while (!FileUtil.a(localIFileViewerAdapter.b())) {
      return;
    }
    localImageView.setOnClickListener(new sei(this, localIFileViewerAdapter));
    localImageView.setImageResource(2130840457);
    localImageView.setContentDescription(getString(2131366103));
    localImageView.setVisibility(0);
  }
  
  private void m()
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
      ((TextView)findViewById(2131301016)).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void n()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new seq(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131301014);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  public BaseActionBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.a();
    }
    return null;
  }
  
  public FileViewBase a()
  {
    LocalVideoFileView localLocalVideoFileView = new LocalVideoFileView(this);
    localLocalVideoFileView.a(a());
    return localLocalVideoFileView;
  }
  
  public IFileViewerAdapter a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_b_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        QLog.e("FileBrowserActivity<FileAssistant>", 1, "index error, index[" + this.jdField_b_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
        return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(0);
      }
      return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    l();
    a(false);
  }
  
  protected void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    switch (paramIFileViewerAdapter.d())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null)
      {
        QLog.e("FileBrowserActivity<FileAssistant>", 1, "refresh fileView error!fileType[" + paramIFileViewerAdapter.b() + "],cloudType[" + paramIFileViewerAdapter.d() + "]");
        if (QLog.isColorLevel()) {
          QLog.e("FileBrowserActivity<FileAssistant>", 2, FileManagerUtil.a(paramIFileViewerAdapter.a()));
        }
      }
      return;
      switch (paramIFileViewerAdapter.b())
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
        break;
      case 5: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
        break;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = i();
        break;
      case 2: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
        continue;
        switch (paramIFileViewerAdapter.b())
        {
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
          break;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
          break;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = i();
          break;
        case 2: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
          continue;
          if ((paramIFileViewerAdapter.d()) && (paramIFileViewerAdapter.a() > paramIFileViewerAdapter.d())) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
          } else if ((paramIFileViewerAdapter.d()) && (paramIFileViewerAdapter.a() <= paramIFileViewerAdapter.d())) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = k();
          } else {
            switch (paramIFileViewerAdapter.b())
            {
            default: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
              break;
            case 2: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
              continue;
              paramIFileViewerAdapter.b();
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = j();
              continue;
              if (FileUtils.b(paramIFileViewerAdapter.a().getFilePath())) {
                switch (paramIFileViewerAdapter.b())
                {
                case 3: 
                case 4: 
                default: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
                  break;
                case 5: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
                  break;
                case 1: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = i();
                  break;
                case 2: 
                  if ((paramIFileViewerAdapter.a().status != 1) && (!paramIFileViewerAdapter.c()))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
                    continue;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
                  break;
                }
              } else {
                switch (paramIFileViewerAdapter.b())
                {
                default: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
                  break;
                case 2: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
                }
              }
              break;
            }
          }
          break;
        }
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      }
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
        break;
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || ((!(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase instanceof PreviewingOfflineFileView)) && (!(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase instanceof CanPreviewOfflineFileView)))) {
          break label171;
        }
      } while (!FileUtil.b(a().b()));
      Object localObject = a();
      if ((((IFileViewerAdapter)localObject).d() == 3) || ((6 == ((IFileViewerAdapter)localObject).d()) && (((IFileViewerAdapter)localObject).e() == 1) && (FileUtils.b(((IFileViewerAdapter)localObject).b()))))
      {
        a(paramBoolean, a());
        continue;
        label171:
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || (!LocalSimpleFileView.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase)))
        {
          localObject = a();
          int i = ((IFileViewerAdapter)localObject).d();
          int j = ((IFileViewerAdapter)localObject).c();
          if (((1 == i) || (2 == i)) && (a().f()))
          {
            if (i == 1) {
              if (j == 3000) {
                this.app.a().a(new DiscOfflinePreviewController(this.app, a().e(), a().i()));
              }
            }
            for (;;)
            {
              localObject = new Intent(this, FilePreviewActivity.class);
              ((Intent)localObject).putExtra("offline_file_type", 0);
              ((Intent)localObject).putExtra("offline_file_name", a().a());
              ((Intent)localObject).putExtra("offline_file_size", a().a());
              QLog.i("FileBrowserActivity<FileAssistant>", 1, "open zip file,open new activity");
              startActivity((Intent)localObject);
              overridePendingTransition(2130968602, 2130968604);
              a().a(false);
              return;
              this.app.a().a(new OfflinePreviewController(this.app, a().e()));
              continue;
              if (i == 2) {
                this.app.a().a(new WeiYunPreviewController(this.app, a().f()));
              }
            }
          }
          a().removeAllViews();
          a(a());
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
            localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
            a().addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.d();
            d();
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((getIntent().getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject = new FileViewerParamParser(this.app);
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      ((FileViewerParamParser)localObject).a(this.jdField_b_of_type_JavaLangString);
    }
    if (!((FileViewerParamParser)localObject).a(paramIntent)) {
      return false;
    }
    this.jdField_a_of_type_Int = ((FileViewerParamParser)localObject).a();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 2: 
      this.jdField_a_of_type_JavaUtilList = ((FileViewerParamParser)localObject).a();
      this.jdField_b_of_type_Int = ((FileViewerParamParser)localObject).b();
      a(a());
    }
    do
    {
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b())) {
          setRequestedOrientation(1);
        }
        setContentViewNoTitle(2130904019);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
          break label284;
        }
        return false;
        this.jdField_a_of_type_JavaUtilList = ((FileViewerParamParser)localObject).a();
        this.jdField_b_of_type_Int = ((FileViewerParamParser)localObject).b();
        f();
        continue;
        this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
        this.jdField_a_of_type_JavaUtilList.add(((FileViewerParamParser)localObject).a());
        this.jdField_b_of_type_Int = 0;
        paramIntent = a();
        if (paramIntent == null) {
          return false;
        }
        if ((paramIntent.d() == 3) && (6 == paramIntent.d()) && (paramIntent.e() == 1) && (FileUtils.b(paramIntent.b()))) {
          break;
        }
        a(paramIntent);
      }
      setContentViewNoTitle(2130904019);
    } while (!a(true, paramIntent));
    return true;
    label284:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    a().removeAllViews();
    a().addView(paramIntent, 0, (ViewGroup.LayoutParams)localObject);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramIntent = (RelativeLayout)findViewById(2131298651);
      paramIntent.setFitsSystemWindows(true);
      paramIntent.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, IFileViewerAdapter paramIFileViewerAdapter)
  {
    LocalTbsViewManager.a().a(getActivity(), paramIFileViewerAdapter.b(), new sem(this, paramIFileViewerAdapter), paramBoolean);
    return true;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public RelativeLayout b()
  {
    return (RelativeLayout)findViewById(2131301018);
  }
  
  protected FileViewBase b()
  {
    OfflineMusicFileView localOfflineMusicFileView = new OfflineMusicFileView(this);
    localOfflineMusicFileView.a(a());
    return localOfflineMusicFileView;
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297834));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected FileViewBase c()
  {
    OfflineSimpleFileView localOfflineSimpleFileView = new OfflineSimpleFileView(this);
    localOfflineSimpleFileView.a(a());
    return localOfflineSimpleFileView;
  }
  
  public void c()
  {
    ((TextView)findViewById(2131297083)).setOnClickListener(new seh(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
        break label130;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_Int + 1 + "/" + this.jdField_a_of_type_JavaUtilList.size());
    }
    for (;;)
    {
      ((TextView)findViewById(2131301016)).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
      l();
      return;
      label130:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a().a());
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int > 0);
  }
  
  protected FileViewBase d()
  {
    OfflineVideoFileView localOfflineVideoFileView = new OfflineVideoFileView(this, this.app);
    localOfflineVideoFileView.a(a());
    return localOfflineVideoFileView;
  }
  
  public void d()
  {
    m();
    if (a().h()) {
      FileManagerUtil.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
    }
    for (;;)
    {
      l();
      return;
      FileManagerUtil.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.jdField_c_of_type_Int);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = new ForwardData();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a(getIntent());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
    }
    do
    {
      return;
      if (paramInt2 != -1) {
        break;
      }
    } while ((paramIntent != null) && (paramIntent.getExtras() != null) && ((this.jdField_c_of_type_Int == 10004) || (this.jdField_c_of_type_Int == 10006) || (this.jdField_c_of_type_Int == 10000) || (this.jdField_c_of_type_Int == 10001) || (this.jdField_c_of_type_Int == 10003) || (this.jdField_c_of_type_Int == 10008) || (this.jdField_c_of_type_Int == 10009)));
    setResult(-1, paramIntent);
    finish();
    if (paramInt2 == 10)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = FMConfig.a(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramBundle != null) {}
    try
    {
      i = Integer.parseInt(paramBundle);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int i = 0;
      }
      Object localObject1;
      Object localObject2;
      if ((-1L == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b()) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a())))
      {
        localObject1 = new FileInfo();
        ((FileInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
        ((FileInfo)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
        ((FileInfo)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        FMDataCache.a((ArrayList)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b(FileManagerUtil.a((FileInfo)localObject1).nSessionId);
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
      boolean bool;
      if (10004 == this.jdField_c_of_type_Int)
      {
        this.jdField_c_of_type_Boolean = true;
        FileManagerReporter.a("0X8004BB3");
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.jdField_c_of_type_Boolean = true;
        }
        if (10008 != this.jdField_c_of_type_Int) {
          break label370;
        }
        bool = g();
      }
      for (;;)
      {
        label264:
        if (!bool)
        {
          QLog.e("FileBrowserActivity<FileAssistant>", 1, "!!!!!!!create fileView faild!!!!!!!");
          if (QLog.isDevelopLevel())
          {
            paramBundle = paramBundle.getExtras();
            localObject1 = paramBundle.keySet().iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                QLog.i("FileBrowserActivity<FileAssistant>", 4, "Key=" + (String)localObject2 + ", content=" + paramBundle.getString((String)localObject2));
                continue;
                FileManagerReporter.a("0X8004BC8");
                break;
                label370:
                bool = a(paramBundle);
                break label264;
              }
            }
          }
          finish();
          return false;
        }
      }
    }
    init(paramBundle);
    if (Build.VERSION.SDK_INT <= 11) {
      removeWebViewLayerType();
    }
    c();
    i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = new ActionBarManager(this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent);
    FileManagerReporter.a("0X8004C01");
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d() == 7) {
      AppNetConnInfo.registerNetChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new sef(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (RelativeLayout)findViewById(2131298651);
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    if (FileManagerUtil.a()) {
      return true;
    }
    paramBundle = new Intent(this, WebProcessReceiver.class);
    paramBundle.setAction("action_download_tbs");
    sendBroadcast(paramBundle, "com.tencent.msg.permission.pushnotify");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      int i = hashCode();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileBrowserActivity<FileAssistant>", 4, "destroy activity hashCode[" + i + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    k();
    o();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d() == 7) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
    LocalTbsViewManager.a().a(this);
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.e();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.d();
    }
    b();
    super.doOnResume();
  }
  
  protected FileViewBase e()
  {
    ZipPreviewFileView localZipPreviewFileView = new ZipPreviewFileView(this, this.app);
    localZipPreviewFileView.a(a());
    return localZipPreviewFileView;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_Boolean) {
      FileManagerReporter.a("0X8004BC7");
    }
    for (;;)
    {
      localObject = getIntent().getExtras().getString("leftViewText");
      if ((localObject == null) || (!((String)localObject).equals(getString(2131362731)))) {
        break;
      }
      finish();
      overridePendingTransition(2130968590, 2130968591);
      return;
      FileManagerReporter.a("0X8004BDD");
    }
    Object localObject = new Intent(getApplicationContext(), FMActivity.class);
    ((Intent)localObject).putExtra("selectMode", false);
    ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
    ((Intent)localObject).putExtra("tab_tab_type", 0);
    ((Intent)localObject).putExtra("from_qlink", a());
    startActivityForResult((Intent)localObject, 103);
    overridePendingTransition(2130968602, 2130968604);
  }
  
  public boolean e()
  {
    return getIntent().getBooleanExtra("FromEditBarPreview", false);
  }
  
  protected FileViewBase f()
  {
    CanPreviewOfflineFileView localCanPreviewOfflineFileView = new CanPreviewOfflineFileView(this);
    localCanPreviewOfflineFileView.a(a());
    return localCanPreviewOfflineFileView;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = new PhotoFileView(this, this.app, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
  }
  
  public boolean f()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131301019)).inflate();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new sep(this));
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent == null)
    {
      FileClickReport localFileClickReport = new FileClickReport(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = localFileClickReport;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = localFileClickReport;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool = true;
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(paramConfiguration);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b())
      {
        setRequestedOrientation(-1);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(true);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.g();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b();
        }
        if (this.jdField_b_of_type_Boolean) {
          break label81;
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      label81:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */