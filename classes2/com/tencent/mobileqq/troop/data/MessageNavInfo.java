package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageNavInfo
{
  private static final String a;
  public long a;
  public long b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MessageNavInfo.class.getSimpleName();
  }
  
  public MessageNavInfo()
  {
    a();
  }
  
  public MessageNavInfo(MessageNavInfo paramMessageNavInfo)
  {
    a(paramMessageNavInfo);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shmsgseq", this.jdField_a_of_type_Long);
      localJSONObject.put("uniseq", this.b);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
  }
  
  public void a(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo != null)
    {
      this.jdField_a_of_type_Long = paramMessageNavInfo.jdField_a_of_type_Long;
      this.b = paramMessageNavInfo.b;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.getLong("shmsgseq");
      this.b = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != -1L;
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong != -1L) && ((this.jdField_a_of_type_Long == -1L) || (this.jdField_a_of_type_Long > paramLong));
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (a(paramLong1))
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.b = paramLong2;
      return true;
    }
    return false;
  }
  
  public boolean a(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo == null) {
      return false;
    }
    return a(paramMessageNavInfo.jdField_a_of_type_Long, paramMessageNavInfo.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\MessageNavInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */