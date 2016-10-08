package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.DisLikeInfo;

public class DislikeInfo
{
  public static final String a = "_";
  public int a;
  public long a;
  public byte[] a;
  public String b;
  public String c;
  
  public DislikeInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(ArrayList paramArrayList)
  {
    Object localObject2;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject2 = "";
      return (String)localObject2;
    }
    int j = paramArrayList.size();
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = (String)localObject1 + PkgTools.b(((DislikeInfo)paramArrayList.get(i)).jdField_a_of_type_ArrayOfByte);
      localObject1 = localObject2;
      if (i != j - 1) {
        localObject1 = (String)localObject2 + "_";
      }
      i += 1;
    }
  }
  
  public static ArrayList a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("_");
    int i = paramString.length;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        oidb_cmd0x68b.DisLikeInfo localDisLikeInfo = new oidb_cmd0x68b.DisLikeInfo();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        try
        {
          localDisLikeInfo.mergeFrom(PkgTools.a(paramString[i]));
          localDislikeInfo.a(localDisLikeInfo);
          localArrayList.add(localDislikeInfo);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(oidb_cmd0x68b.DisLikeInfo paramDisLikeInfo)
  {
    this.b = paramDisLikeInfo.bytes_dislike_describe.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramDisLikeInfo.type.get();
    this.c = paramDisLikeInfo.bytes_dislike_account_id.get().toStringUtf8();
    this.jdField_a_of_type_Long = paramDisLikeInfo.uint64_dislike_tagid.get();
    this.jdField_a_of_type_ArrayOfByte = paramDisLikeInfo.toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\DislikeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */