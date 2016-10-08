package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class PicBrowserModel
  implements AbstractImageListModel
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public PicBrowserModel(Context paramContext, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      if (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((!TextUtils.isEmpty(paramContext.d)) || (!TextUtils.isEmpty(paramContext.e))) {}
        for (paramContext = new GalleryItemVideo(this.jdField_a_of_type_AndroidContentContext, paramContext);; paramContext = new GalleryItemImage(this.jdField_a_of_type_AndroidContentContext, paramContext))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
          i += 1;
          break;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public PicBrowserImage a()
  {
    return (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public PicBrowserImage a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    ((PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicBrowserImage localPicBrowserImage = (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localPicBrowserImage.a(bool);
        i += 1;
        break;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\PicBrowserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */