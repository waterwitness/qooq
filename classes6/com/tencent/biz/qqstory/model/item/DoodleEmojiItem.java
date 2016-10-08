package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DoodleEmojiItem
  implements Cloneable
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public String f;
  
  public DoodleEmojiItem(GetEmojiPackInfoListResponse.EmojiPack paramEmojiPack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramEmojiPack.a;
    this.b = paramEmojiPack.b;
    this.c = paramEmojiPack.c;
    this.d = paramEmojiPack.d;
    this.e = paramEmojiPack.e;
  }
  
  public DoodleEmojiItem(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = null;
    this.d = paramString3;
    this.e = paramString4;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (DoodleEmojiItem)paramObject;
    return this.a.equals(((DoodleEmojiItem)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return "DoodleEmojiItem{mPackId='" + this.a + '\'' + ", mLogoUrl='" + this.b + '\'' + ", mPackName='" + this.d + '\'' + ", mPackDownloadUrl='" + this.e + '\'' + ", mLocalEmojiFolderPath='" + this.f + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\DoodleEmojiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */