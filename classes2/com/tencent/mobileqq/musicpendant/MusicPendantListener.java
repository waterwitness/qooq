package com.tencent.mobileqq.musicpendant;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.IQQPlayerCallback;

public abstract interface MusicPendantListener
  extends IQQPlayerCallback
{
  public abstract void a();
  
  public abstract void a(Card paramCard);
  
  public abstract void b(Card paramCard);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\musicpendant\MusicPendantListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */