package com.tencent.mobileqq.earlydownload.handler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class SystemFaceHandler
  extends EarlyHandler
  implements Handler.Callback
{
  public static final int a = 2000;
  public static final String a = "qq.android.system.face.gifv4";
  public static final int b = 196864;
  public static final String b;
  private Handler a = new Handler(Looper.getMainLooper(), this);
  private ArrayList b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = SystemFaceData.class.getSimpleName();
  }
  
  public SystemFaceHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv4", paramQQAppInterface);
  }
  
  private void d(String paramString)
  {
    int j = 0;
    int i = j;
    try
    {
      int m = Integer.parseInt(paramString);
      i = j;
      int k = com.tencent.mobileqq.text.EmotcationConstants.a[m];
      i = j;
      j = com.tencent.mobileqq.text.EmotcationConstants.b[m];
      i = j;
      localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(k), "");
      i = j;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          URL localURL;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "reloadFaceOnUI() ", localMalformedURLException);
          }
          localObject = null;
        }
        Drawable localDrawable = BaseApplicationImpl.a().getResources().getDrawable(i);
        localObject = URLDrawable.getDrawable((URL)localObject, localDrawable, localDrawable, true);
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "reloadFaceOnUI() idx=" + paramString + " d.status!=successed||loading. go to restartDownload");
          }
          ((URLDrawable)localObject).addHeader("faceIdx", paramString);
          ((URLDrawable)localObject).restartDownload();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_b_of_type_JavaLangString, 2, "reloadFaceOnUI() idx=" + paramString + " d.status=" + ((URLDrawable)localObject).getStatus() + " do nothing..");
    }
    if (localURL == null) {
      return;
    }
  }
  
  public Class a()
  {
    return SystemFaceData.class;
  }
  
  public String a()
  {
    return "actEarlySysFaceGif";
  }
  
  public void a(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      FileUtils.a(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "doOnDownloadFinish() uncompressZip to:" + localFile.getAbsolutePath());
      }
      super.a(paramString);
      this.a.sendEmptyMessage(196864);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void b(String paramString)
  {
    EarlyDownloadManager.a.lock();
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(0, paramString);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addWaittingFace idx=" + paramString);
        }
      }
      return;
    }
    finally
    {
      EarlyDownloadManager.a.unlock();
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c(String paramString)
  {
    EarlyDownloadManager.a.lock();
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      if ((this.jdField_b_of_type_JavaUtilArrayList.remove(paramString)) && (QLog.isColorLevel())) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "removeWaittingFace() idx=" + paramString);
      }
      return;
    }
    finally
    {
      EarlyDownloadManager.a.unlock();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = null;
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        continue;
      }
      EarlyDownloadManager.a.lock();
      try
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          paramMessage = (String)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        }
        EarlyDownloadManager.a.unlock();
        if ((paramMessage == null) || (paramMessage.length() <= 0)) {
          continue;
        }
        d(paramMessage);
        if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
          continue;
        }
        this.a.sendEmptyMessageDelayed(196864, 2000L);
        return false;
      }
      finally
      {
        EarlyDownloadManager.a.unlock();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\SystemFaceHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */