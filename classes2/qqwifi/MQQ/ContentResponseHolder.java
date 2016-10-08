package qqwifi.MQQ;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ContentResponseHolder
{
  public ContentResponse a;
  
  public ContentResponseHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContentResponseHolder(ContentResponse paramContentResponse)
  {
    this.a = paramContentResponse;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\MQQ\ContentResponseHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */