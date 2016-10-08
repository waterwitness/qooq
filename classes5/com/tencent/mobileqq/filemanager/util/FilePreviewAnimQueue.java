package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class FilePreviewAnimQueue
  implements Animation.AnimationListener
{
  public static int a;
  public static int b;
  View jdField_a_of_type_AndroidViewView;
  FilePreviewAnimQueue.FilePreviewAnim jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$FilePreviewAnim;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  
  public FilePreviewAnimQueue(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void b(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$FilePreviewAnim = paramFilePreviewAnim;
    Animation localAnimation = (Animation)paramFilePreviewAnim.jdField_a_of_type_JavaLangObject;
    localAnimation.setDuration(paramFilePreviewAnim.b);
    localAnimation.setAnimationListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        continue;
      }
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = (FilePreviewAnimQueue.FilePreviewAnim)this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(0);
        if ((localFilePreviewAnim == null) || ((localFilePreviewAnim.jdField_a_of_type_Boolean == true) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((!localFilePreviewAnim.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4)))) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewView.setAnimation((Animation)localFilePreviewAnim.jdField_a_of_type_JavaLangObject);
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localFilePreviewAnim.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
  }
  
  public void a(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramFilePreviewAnim);
      b(paramFilePreviewAnim);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$FilePreviewAnim.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      a();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FilePreviewAnimQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */