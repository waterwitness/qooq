package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StoryLoadingView
  extends ImageView
{
  protected AnimationDrawable a;
  
  public StoryLoadingView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new AnimationDrawable();
    this.a.addFrame(getResources().getDrawable(2130841420), 50);
    this.a.addFrame(getResources().getDrawable(2130841421), 50);
    this.a.addFrame(getResources().getDrawable(2130841422), 50);
    this.a.addFrame(getResources().getDrawable(2130841423), 50);
    this.a.addFrame(getResources().getDrawable(2130841424), 50);
    this.a.addFrame(getResources().getDrawable(2130841425), 50);
    this.a.addFrame(getResources().getDrawable(2130841426), 50);
    this.a.addFrame(getResources().getDrawable(2130841427), 50);
    this.a.addFrame(getResources().getDrawable(2130841428), 50);
    this.a.addFrame(getResources().getDrawable(2130841429), 50);
    this.a.addFrame(getResources().getDrawable(2130841430), 50);
    this.a.addFrame(getResources().getDrawable(2130841431), 50);
    this.a.addFrame(getResources().getDrawable(2130841432), 50);
    this.a.addFrame(getResources().getDrawable(2130841433), 50);
    this.a.addFrame(getResources().getDrawable(2130841434), 50);
    this.a.addFrame(getResources().getDrawable(2130841435), 50);
    this.a.addFrame(getResources().getDrawable(2130841436), 50);
    this.a.addFrame(getResources().getDrawable(2130841437), 50);
    this.a.addFrame(getResources().getDrawable(2130841438), 50);
    this.a.addFrame(getResources().getDrawable(2130841439), 50);
    this.a.addFrame(getResources().getDrawable(2130841440), 50);
    this.a.addFrame(getResources().getDrawable(2130841441), 50);
    this.a.addFrame(getResources().getDrawable(2130841442), 50);
    this.a.addFrame(getResources().getDrawable(2130841443), 50);
    this.a.addFrame(getResources().getDrawable(2130841444), 50);
    this.a.addFrame(getResources().getDrawable(2130841445), 50);
    this.a.addFrame(getResources().getDrawable(2130841446), 50);
    this.a.addFrame(getResources().getDrawable(2130841447), 50);
    this.a.addFrame(getResources().getDrawable(2130841448), 50);
    this.a.setOneShot(false);
    super.setImageDrawable(this.a);
    if ((this.a != null) && (!this.a.isRunning())) {
      this.a.start();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (!this.a.isRunning())) {
      this.a.start();
    }
    while (!this.a.isRunning()) {
      return;
    }
    this.a.stop();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\StoryLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */