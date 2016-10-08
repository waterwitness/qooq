package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PBUtils
{
  public PBUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field, int paramInt)
  {
    if (paramPBUInt32Field.has()) {
      paramInt = paramPBUInt32Field.get();
    }
    return paramInt;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field, long paramLong)
  {
    if (paramPBUInt64Field.has()) {
      paramLong = paramPBUInt64Field.get();
    }
    return paramLong;
  }
  
  public static String a(MessageMicro paramMessageMicro)
  {
    return a(paramMessageMicro).toString();
  }
  
  private static String a(PBPrimitiveField paramPBPrimitiveField)
  {
    if ((paramPBPrimitiveField instanceof PBBytesField)) {
      return ((PBBytesField)paramPBPrimitiveField).get().toStringUtf8();
    }
    if ((paramPBPrimitiveField instanceof PBStringField)) {
      return ((PBStringField)paramPBPrimitiveField).get();
    }
    if ((paramPBPrimitiveField instanceof PBBoolField)) {
      return String.valueOf(((PBBoolField)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFixed32Field)) {
      return String.valueOf(((PBFixed32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFixed64Field)) {
      return String.valueOf(((PBFixed64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFloatField)) {
      return String.valueOf(((PBFloatField)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBInt32Field)) {
      return String.valueOf(((PBInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBInt64Field)) {
      return String.valueOf(((PBInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSFixed32Field)) {
      return String.valueOf(((PBSFixed32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSInt32Field)) {
      return String.valueOf(((PBSInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSInt64Field)) {
      return String.valueOf(((PBSInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBUInt32Field)) {
      return String.valueOf(((PBUInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBUInt64Field)) {
      return String.valueOf(((PBUInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBEnumField)) {
      return String.valueOf(((PBEnumField)paramPBPrimitiveField).get());
    }
    return "(null)";
  }
  
  public static JSONObject a(MessageMicro paramMessageMicro)
  {
    JSONObject localJSONObject = new JSONObject();
    a(paramMessageMicro, localJSONObject);
    return localJSONObject;
  }
  
  private static void a(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    Field[] arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    for (;;)
    {
      int i;
      Object localObject1;
      String str;
      try
      {
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localObject1 = arrayOfField[i];
          str = ((Field)localObject1).getName();
          if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {
            break label289;
          }
          localObject1 = ((Field)localObject1).get(paramMessageMicro);
          if ((!(localObject1 instanceof MessageMicro)) || (!((MessageMicro)localObject1).has())) {
            break label98;
          }
          paramJSONObject.put(str, a((MessageMicro)localObject1));
        }
      }
      catch (Exception paramMessageMicro)
      {
        paramMessageMicro.printStackTrace();
      }
      return;
      label98:
      if (((localObject1 instanceof PBPrimitiveField)) && (((PBPrimitiveField)localObject1).has()))
      {
        paramJSONObject.put(str, a((PBPrimitiveField)localObject1));
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof PBRepeatField))
        {
          localObject2 = ((PBRepeatField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a((PBPrimitiveField)((Iterator)localObject2).next()));
          }
          paramJSONObject.put(str, localObject1);
        }
        else if ((localObject1 instanceof PBRepeatMessageField))
        {
          localObject2 = ((PBRepeatMessageField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a((MessageMicro)((Iterator)localObject2).next()));
          }
          paramJSONObject.put(str, localObject1);
        }
      }
      label289:
      i += 1;
    }
  }
  
  public static void a(PBBytesField paramPBBytesField, String paramString)
  {
    if (paramString != null) {
      paramPBBytesField.set(ByteStringMicro.copyFromUtf8(paramString));
    }
  }
  
  public static void a(ArrayList paramArrayList, PBRepeatField paramPBRepeatField)
  {
    int i = 0;
    while (i < paramPBRepeatField.size())
    {
      paramArrayList.add(paramPBRepeatField.get(i));
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\PBUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */