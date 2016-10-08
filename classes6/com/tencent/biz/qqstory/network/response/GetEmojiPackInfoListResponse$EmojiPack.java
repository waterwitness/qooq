package com.tencent.biz.qqstory.network.response;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetEmojiPackInfoListResponse$EmojiPack
  implements Cloneable
{
  public static final int a = 1;
  public static final int b = 2;
  public final String a;
  public final String b;
  public final int c;
  public final String c;
  public final int d;
  public final String d;
  public final String e;
  public final String f;
  
  public GetEmojiPackInfoListResponse$EmojiPack(qqstory_struct.EmoticonPack paramEmoticonPack)
  {
    this.a = String.valueOf(paramEmoticonPack.pack_id.get());
    this.b = paramEmoticonPack.icon.get().toStringUtf8();
    this.jdField_d_of_type_JavaLangString = paramEmoticonPack.name.get().toStringUtf8();
    this.e = paramEmoticonPack.download_url.get().toStringUtf8();
    this.f = paramEmoticonPack.md5.get().toStringUtf8();
    this.jdField_c_of_type_Int = paramEmoticonPack.version.get();
    this.jdField_d_of_type_Int = a(paramEmoticonPack.type.get());
    this.jdField_c_of_type_JavaLangString = paramEmoticonPack.download_icon.get().toStringUtf8();
  }
  
  public GetEmojiPackInfoListResponse$EmojiPack(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = a(paramInt2);
  }
  
  private int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.e));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (EmojiPack)paramObject;
      if (this.a == null) {
        break;
      }
    } while (this.a.equals(((EmojiPack)paramObject).a));
    while (((EmojiPack)paramObject).a != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "EmojiPack{mPackId=" + this.a + ", mLogoUrl='" + this.b + '\'' + ", mPackName='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mPackDownloadUrl='" + this.e + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetEmojiPackInfoListResponse$EmojiPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */