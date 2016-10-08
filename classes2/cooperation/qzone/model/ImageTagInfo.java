package cooperation.qzone.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import ymn;

public class ImageTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymn();
  private static String e;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageTagInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public ImageTagInfo(stPhotoTag paramstPhotoTag)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    if (paramstPhotoTag != null)
    {
      this.jdField_a_of_type_Int = paramstPhotoTag.type;
      this.jdField_a_of_type_JavaLangString = paramstPhotoTag.content;
      this.jdField_b_of_type_JavaLangString = paramstPhotoTag.tag_id;
      this.jdField_e_of_type_Int = ((int)paramstPhotoTag.x_scale);
      this.f = ((int)paramstPhotoTag.y_scale);
      this.g = paramstPhotoTag.direction;
      this.jdField_c_of_type_JavaLangString = paramstPhotoTag.poiTagStreet;
    }
  }
  
  private ImageTagInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
  }
  
  public static String a()
  {
    return jdField_e_of_type_JavaLangString;
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ImageTagInfo localImageTagInfo = new ImageTagInfo((stPhotoTag)paramArrayList.next());
        if (localImageTagInfo != null) {
          localArrayList.add(localImageTagInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      jdField_e_of_type_JavaLangString = paramString;
      return;
      paramString = "";
    }
  }
  
  public static ArrayList b(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (ImageTagInfo)paramArrayList.next();
        if (localObject != null)
        {
          localObject = new stPhotoTag(((ImageTagInfo)localObject).jdField_a_of_type_Int, ((ImageTagInfo)localObject).jdField_a_of_type_JavaLangString, ((ImageTagInfo)localObject).jdField_b_of_type_JavaLangString, ((ImageTagInfo)localObject).jdField_e_of_type_Int, ((ImageTagInfo)localObject).f, ((ImageTagInfo)localObject).g, ((ImageTagInfo)localObject).jdField_c_of_type_JavaLangString);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ImageTagInfo a()
  {
    ImageTagInfo localImageTagInfo = new ImageTagInfo();
    localImageTagInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localImageTagInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localImageTagInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localImageTagInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localImageTagInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    localImageTagInfo.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
    localImageTagInfo.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localImageTagInfo.f = this.f;
    localImageTagInfo.g = this.g;
    localImageTagInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localImageTagInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    return localImageTagInfo;
  }
  
  public void a(ContentValues paramContentValues)
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("key", jdField_e_of_type_JavaLangString);
    paramContentValues.put("data", arrayOfByte);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\ImageTagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */