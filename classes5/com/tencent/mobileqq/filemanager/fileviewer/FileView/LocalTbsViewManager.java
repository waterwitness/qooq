package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;
import sfc;
import sfh;

public class LocalTbsViewManager
{
  private static LocalTbsViewManager jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager;
  private static final String jdField_a_of_type_JavaLangString = "LocalTbsViewManager<FileAssistant>";
  private int jdField_a_of_type_Int;
  private TbsReaderView jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
  private TbsReaderView b;
  
  public LocalTbsViewManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static LocalTbsViewManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager = new LocalTbsViewManager();
    }
    return jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager;
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null) && (paramActivity.hashCode() == this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
    }
    if (!FileUtil.b(paramString)) {
      return null;
    }
    if (this.b != null)
    {
      this.b.onStop();
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
    }
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = new TbsReaderView(paramActivity, new sfc(this, paramActivity, paramLocalTbsViewManagerCallback, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.setBackgroundColor(-65536);
    Object localObject = FileUtil.a(paramString);
    paramLocalTbsViewManagerCallback = (LocalTbsViewManager.LocalTbsViewManagerCallback)localObject;
    if (((String)localObject).startsWith(".")) {
      paramLocalTbsViewManagerCallback = ((String)localObject).replaceFirst(".", "");
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.preOpen(paramLocalTbsViewManagerCallback, false))
    {
      paramLocalTbsViewManagerCallback = new Bundle();
      paramLocalTbsViewManagerCallback.putString("filePath", paramString);
      paramString = FMSettings.a().b();
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramLocalTbsViewManagerCallback.putString("tempPath", paramString);
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.openFile(paramLocalTbsViewManagerCallback);
      this.jdField_a_of_type_Int = paramActivity.hashCode();
      return this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
    }
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalTbsViewManager<FileAssistant>", 4, "LocalTbsViewManager destroy hashCode[" + this.jdField_a_of_type_Int + "],activity[" + i + "]");
    }
    if (this.jdField_a_of_type_Int != i) {}
    do
    {
      return;
      if (this.b != null)
      {
        this.b.onStop();
        this.b = null;
      }
    } while (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView == null);
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
  }
  
  public void a(Activity paramActivity, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return 2-------");
      }
      this.b.onStop();
      this.b = null;
    }
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new sfh(this, paramLocalTbsViewManagerCallback));
    paramActivity = FileUtil.a(paramString);
    if (paramActivity.startsWith(".")) {
      paramActivity = paramActivity.replaceFirst(".", "");
    }
    for (;;)
    {
      boolean bool;
      if (!paramBoolean)
      {
        bool = true;
        if (localTbsReaderView.preOpen(paramActivity, bool)) {
          break label134;
        }
        localTbsReaderView.onStop();
        paramLocalTbsViewManagerCallback.b(false);
        if (!QLog.isColorLevel()) {
          break label166;
        }
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
        paramActivity = null;
      }
      for (;;)
      {
        this.b = paramActivity;
        return;
        bool = false;
        break;
        label134:
        if (paramBoolean) {
          paramLocalTbsViewManagerCallback.b(true);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
        }
        paramActivity = localTbsReaderView;
        continue;
        label166:
        paramActivity = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\LocalTbsViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */