package com.dataline.core;

import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DirectForwarder$CallBack
{
  public boolean a;
  
  public DirectForwarder$CallBack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    DirectForwarder.a(2131362202, 1);
  }
  
  public void a(AsyncTask paramAsyncTask, int paramInt)
  {
    this.a = true;
  }
  
  protected void b()
  {
    DirectForwarder.a("文件路径错误", 1);
  }
  
  protected void c()
  {
    DirectForwarder.a("字数超出限制", 1);
  }
  
  protected void d()
  {
    DirectForwarder.a("字数串为空", 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\core\DirectForwarder$CallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */