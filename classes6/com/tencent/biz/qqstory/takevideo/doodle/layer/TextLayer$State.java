package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;

public abstract interface TextLayer$State
{
  public abstract Paint a();
  
  public abstract TextInfo a();
  
  public abstract void a();
  
  public abstract void a(Canvas paramCanvas);
  
  public abstract void a(MotionEvent paramMotionEvent);
  
  public abstract void a(TextInfo paramTextInfo);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas);
  
  public abstract boolean b(MotionEvent paramMotionEvent);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\TextLayer$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */