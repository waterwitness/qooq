package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class AIOImageData
  extends AIORichMediaData
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 0;
  public static final int f = 1;
  public long a;
  public Object a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public long e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public int i;
  public int j;
  
  public AIOImageData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.h = 0;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.contains(this.jdField_a_of_type_JavaLangString)) {
        return 1;
      }
      if (paramString.contains(this.jdField_b_of_type_JavaLangString)) {
        return 2;
      }
    } while (!paramString.contains(this.jdField_c_of_type_JavaLangString));
    return 4;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return (File)localObject;
      localObject = this.jdField_a_of_type_JavaLangString;
      continue;
      localObject = this.jdField_b_of_type_JavaLangString;
      continue;
      localObject = this.jdField_c_of_type_JavaLangString;
      continue;
      localObject = this.jdField_d_of_type_JavaLangString;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          if (str.startsWith("/")) {
            break;
          }
          localObject1 = "file:/" + str;
        }
      }
      return (String)localObject1;
      str = this.jdField_a_of_type_JavaLangString;
      continue;
      str = this.jdField_b_of_type_JavaLangString;
      continue;
      str = this.jdField_c_of_type_JavaLangString;
      continue;
      str = this.jdField_d_of_type_JavaLangString;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label206;
      }
      bool1 = true;
      label102:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label211;
      }
      bool1 = true;
      label116:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
      if (paramParcel.readByte() == 0) {
        break label216;
      }
    }
    label206:
    label211:
    label216:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (!this.jdField_a_of_type_JavaLangString.equals("I:N"));
        return false;
      } while (!this.jdField_b_of_type_JavaLangString.equals("I:N"));
      return false;
    } while (!this.jdField_c_of_type_JavaLangString.equals("I:N"));
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    if (this.jdField_d_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label210;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label215;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeInt(this.h);
      paramParcel.writeValue(this.jdField_a_of_type_JavaLangObject);
      if (!this.jdField_g_of_type_Boolean) {
        break label220;
      }
    }
    label210:
    label215:
    label220:
    for (paramInt = k;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeInt(this.i);
      paramParcel.writeInt(this.j);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
      paramInt = 0;
      break label119;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOImageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */