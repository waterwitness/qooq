package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class ApolloListenerManager
{
  private List a;
  
  public ApolloListenerManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public List a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((IResDownloadListener)this.a.get(i)).a();
        i += 1;
      }
    }
  }
  
  public void a(IResDownloadListener paramIResDownloadListener)
  {
    if (this.a != null) {
      this.a.add(paramIResDownloadListener);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((IResDownloadListener)this.a.get(i)).a(paramApolloActionData);
        i += 1;
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((IResDownloadListener)this.a.get(i)).a(paramBoolean);
        i += 1;
      }
    }
  }
  
  public void b(IResDownloadListener paramIResDownloadListener)
  {
    if (this.a != null) {
      this.a.remove(paramIResDownloadListener);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\utils\ApolloListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */