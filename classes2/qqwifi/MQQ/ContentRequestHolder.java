package qqwifi.MQQ;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ContentRequestHolder
{
  public ContentRequest a;
  
  public ContentRequestHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContentRequestHolder(ContentRequest paramContentRequest)
  {
    this.a = paramContentRequest;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\MQQ\ContentRequestHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */