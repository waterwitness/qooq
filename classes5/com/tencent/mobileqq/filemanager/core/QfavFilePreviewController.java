package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;
import rzl;
import rzn;
import rzo;

public class QfavFilePreviewController
  extends FilePreViewControllerBase
{
  public static final int a = 0;
  public static final String a = "QfavFilePreviewController";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FavoritesRemoteCommand.IRemoteCommandHandler jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  
  public QfavFilePreviewController(Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 0;
    this.f = 80;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler = new rzl(this);
    QfavPluginProxyService.a().a(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
    this.e = 2;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new rzn(this), 300000L);
  }
  
  public int a()
  {
    return 4;
  }
  
  public boolean a()
  {
    if (3 != this.e)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.e + ", newState = STATE_REQUESTING.");
      }
      this.e = 1;
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new rzo(this), 2000L);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QfavPluginProxyService.a().b(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\QfavFilePreviewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */