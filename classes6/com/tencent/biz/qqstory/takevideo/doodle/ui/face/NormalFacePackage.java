package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyb;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NormalFacePackage
  extends FacePackage
{
  public static final String e = "NormalFacePackage";
  public int a;
  public final List a;
  public boolean a;
  public int b;
  public String f;
  public String g;
  
  public NormalFacePackage(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 100;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String a()
  {
    return "NormalFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  boolean a()
  {
    if (TextUtils.isEmpty(this.g)) {}
    do
    {
      Object localObject1;
      do
      {
        return false;
        localObject1 = new File(this.g);
      } while (!((File)localObject1).exists());
      this.jdField_a_of_type_JavaUtilList.clear();
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles(new iyb(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            this.jdField_a_of_type_JavaUtilList.add(((File)localObject2).toURI().toString());
            i += 1;
          }
          Collections.sort(this.jdField_a_of_type_JavaUtilList);
        }
      }
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    return true;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.c).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append(", zipDownloadUrl='").append(this.f).append('\'');
    localStringBuffer.append(", facePkgPath='").append(this.g).append('\'');
    localStringBuffer.append(", faceUriList=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isDownloading=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", maxProgress=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", currentProgress=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\NormalFacePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */