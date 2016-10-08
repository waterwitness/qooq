package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OnlineFileSessionInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public short b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public long d;
  
  public OnlineFileSessionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = -1L;
    this.a = new byte[16];
  }
  
  public OnlineFileSessionInfo a()
  {
    try
    {
      OnlineFileSessionInfo localOnlineFileSessionInfo = (OnlineFileSessionInfo)super.clone();
      return localOnlineFileSessionInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\OnlineFileSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */