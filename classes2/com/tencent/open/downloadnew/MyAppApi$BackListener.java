package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.business.base.StaticAnalyz;

public class MyAppApi$BackListener
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public MyAppApi$BackListener(MyAppApi paramMyAppApi, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = StaticAnalyz.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = DownloadManager.a();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.b = this.b;
    localDownloadInfo.a(10);
    if (localDownloadInfo != null) {
      paramDialogInterface.a(10, localDownloadInfo);
    }
    StaticAnalyz.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\MyAppApi$BackListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */