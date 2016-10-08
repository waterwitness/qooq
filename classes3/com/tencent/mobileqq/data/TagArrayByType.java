package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class TagArrayByType
{
  public String mInfo;
  public ArrayList mTags;
  public String mTypeText;
  
  public TagArrayByType(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mTypeText = paramString1;
    this.mInfo = paramString2;
    this.mTags = paramArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TagArrayByType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */