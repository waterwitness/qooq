package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoServerInfoManager$ServerInfo
{
  public static final int a = 7200;
  public long a;
  public String a;
  public byte[] a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public VideoServerInfoManager$ServerInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis())
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "server inf validate %s", this);
      return true;
    }
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "server inf invalidate %s", new Object[] { this });
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Long <= System.currentTimeMillis() + 7200L;
  }
  
  public String toString()
  {
    return "ServerInfo{, userIp='" + this.jdField_a_of_type_JavaLangString + '\'' + ", serverIp1='" + this.b + '\'' + ", serverIp2='" + this.c + '\'' + ", backupServerIp1='" + this.d + '\'' + ", backupServerIp2='" + this.e + '\'' + ", expireTime=" + this.jdField_a_of_type_Long + "" + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\VideoServerInfoManager$ServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */