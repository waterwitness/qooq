package cooperation.qzone.model;

import android.media.ExifInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import ymo;

public class LocalImageShootInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymo();
  private static final String b;
  public long a;
  public GpsInfo4LocalImage a;
  public String a;
  public long b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = LocalImageShootInfo.class.getSimpleName();
  }
  
  public LocalImageShootInfo() {}
  
  public LocalImageShootInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = new GpsInfo4LocalImage(paramParcel);
    }
  }
  
  private LocalImageShootInfo(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("file:///")) {
        str = paramString.replaceFirst("file://", "");
      }
    }
    paramString = new File(str);
    if ((!paramString.exists()) || (paramString.isDirectory())) {
      throw new Exception();
    }
    this.jdField_a_of_type_JavaLangString = paramString.getAbsolutePath();
    this.jdField_b_of_type_Long = paramString.lastModified();
  }
  
  public static LocalImageShootInfo a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label21;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      return (LocalImageShootInfo)localObject1;
      try
      {
        label21:
        paramString = new LocalImageShootInfo(paramString);
        localObject1 = paramString;
        if (paramString == null) {
          continue;
        }
        b(paramString);
        a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = (String)localObject2;
        }
      }
    }
  }
  
  public static boolean a(LocalImageShootInfo paramLocalImageShootInfo)
  {
    boolean bool = true;
    if (paramLocalImageShootInfo == null) {
      bool = false;
    }
    while (paramLocalImageShootInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage != null) {
      return bool;
    }
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString))
      {
        ExifInterface localExifInterface = new ExifInterface(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString);
        float[] arrayOfFloat = new float[2];
        if (localExifInterface.getLatLong(arrayOfFloat))
        {
          paramLocalImageShootInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = new GpsInfo4LocalImage(arrayOfFloat[0], arrayOfFloat[1]);
          return true;
        }
      }
    }
    catch (Exception paramLocalImageShootInfo)
    {
      paramLocalImageShootInfo.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(LocalImageShootInfo paramLocalImageShootInfo)
  {
    if (paramLocalImageShootInfo == null) {}
    Object localObject;
    do
    {
      return false;
      try
      {
        if (JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString))
        {
          paramLocalImageShootInfo.jdField_a_of_type_Long = new File(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString).lastModified();
          QLog.d(jdField_b_of_type_JavaLangString, 4, jdField_b_of_type_JavaLangString + "#appendCaptureDate photo exif date info parse exception, now use last modified time.");
          return false;
        }
      }
      catch (Exception localException)
      {
        paramLocalImageShootInfo.jdField_a_of_type_Long = new File(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString).lastModified();
        QLog.d(jdField_b_of_type_JavaLangString, 4, jdField_b_of_type_JavaLangString + "#appendCaptureDate photo exif date info parse exception, now use last modified time.", localException);
        return false;
      }
      localObject = new ExifInterface(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString).getAttribute("DateTime");
      if (localObject == null) {
        break;
      }
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject);
    } while (localObject == null);
    paramLocalImageShootInfo.jdField_a_of_type_Long = ((Date)localObject).getTime();
    return true;
    paramLocalImageShootInfo.jdField_a_of_type_Long = new File(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString).lastModified();
    QLog.d(jdField_b_of_type_JavaLangString, 4, jdField_b_of_type_JavaLangString + "#appendCaptureDate photo exif date info parse exception, now use last modified time.");
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof LocalImageShootInfo));
    paramObject = (LocalImageShootInfo)paramObject;
    if ((this.jdField_a_of_type_Long == ((LocalImageShootInfo)paramObject).jdField_a_of_type_Long) && (this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage.equals(paramObject))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage != null)
    {
      paramParcel.writeInt(1);
      this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage.writeToParcel(paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\LocalImageShootInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */