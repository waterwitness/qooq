package com.tencent.av.gaudio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoViewInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public VideoViewInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 4L;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof VideoViewInfo)))
    {
      paramObject = (VideoViewInfo)paramObject;
      if (this.jdField_a_of_type_Long == ((VideoViewInfo)paramObject).jdField_a_of_type_Long) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "Uin= " + this.jdField_a_of_type_Long + " ,VideoSrcType= " + this.jdField_a_of_type_Int + " ,isBigView= " + this.jdField_a_of_type_Boolean + " ,isRender=" + this.jdField_b_of_type_Boolean + " ,isNeedRequest=" + this.c + " ,hasRecvData=" + this.d + " , inviteId=" + this.jdField_a_of_type_JavaLangString + ".";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\VideoViewInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */