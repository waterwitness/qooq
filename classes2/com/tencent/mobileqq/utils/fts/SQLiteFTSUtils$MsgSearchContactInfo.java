package com.tencent.mobileqq.utils.fts;

import android.util.Pair;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SQLiteFTSUtils$MsgSearchContactInfo
{
  public int a;
  public Pair a;
  public String a;
  
  public SQLiteFTSUtils$MsgSearchContactInfo(String paramString, int paramInt, Pair paramPair)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidUtilPair = paramPair;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("MsgSearchContactInfo{uin='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", uinType=").append(this.jdField_a_of_type_Int).append(", matchTitle=[");
    if (this.jdField_a_of_type_AndroidUtilPair == null)
    {
      localObject = "null";
      return (String)localObject + "]" + '}';
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.jdField_a_of_type_AndroidUtilPair.first == null)
    {
      localObject = "null";
      label92:
      localStringBuilder2 = localStringBuilder2.append(localObject).append(", ");
      if (this.jdField_a_of_type_AndroidUtilPair.second != null) {
        break label142;
      }
    }
    label142:
    for (Object localObject = "null";; localObject = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.second)
    {
      localObject = localObject;
      break;
      localObject = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.first;
      break label92;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\fts\SQLiteFTSUtils$MsgSearchContactInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */