package com.tencent.biz.qqstory.storyHome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;

public class StoryRecordButtonAnimationView
  extends SpriteGLView
{
  private FrameSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public StoryRecordButtonAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    setZOrderOnTop(true);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) && (this.jdField_a_of_type_ArrayOfJavaLangString == null)) {
      return;
    }
    if (paramList != null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.get(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite = new FrameSprite(this.jdField_a_of_type_ArrayOfJavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(20);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(true);
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(DisplayUtil.a(getContext(), 75.0F), DisplayUtil.a(getContext(), 75.0F));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.c = (DisplayUtil.a(getContext(), 150.0F) / 300.0F);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(getContext(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\StoryRecordButtonAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */