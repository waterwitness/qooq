package com.tencent.open.base.http;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class AvatarUpdateService$AvatarUpdateTask
{
  public String a;
  public WeakReference a;
  public String b;
  public WeakReference b;
  public String c;
  
  public AvatarUpdateService$AvatarUpdateTask(AvatarUpdateService paramAvatarUpdateService, Context paramContext, String paramString1, String paramString2, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramTaskCompleteCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\http\AvatarUpdateService$AvatarUpdateTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */