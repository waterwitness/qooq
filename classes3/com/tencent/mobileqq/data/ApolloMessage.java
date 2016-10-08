package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class ApolloMessage
  implements Serializable
{
  public String extStr;
  public int flag;
  public int id;
  public boolean isPlayed;
  public byte[] name;
  public int peer_status;
  public long peer_ts;
  public long peer_uin;
  public int sender_status;
  public long sender_ts;
  public int status;
  public byte[] text;
  
  public ApolloMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ApolloMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */