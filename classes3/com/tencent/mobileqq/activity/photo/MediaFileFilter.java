package com.tencent.mobileqq.activity.photo;

import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import oqy;
import oqz;
import ora;

public abstract class MediaFileFilter
{
  public static final int a = 0;
  public static final SparseArray a;
  public static final MediaFileFilter a;
  public static final int b = 1;
  public static final MediaFileFilter b;
  public static final int c = 2;
  public static final MediaFileFilter c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new oqy();
    b = new oqz();
    c = new ora();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(0, jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, b);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, c);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\MediaFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */