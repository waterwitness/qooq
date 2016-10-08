package com.tencent.av.ui;

import com.tencent.av.utils.MultiVideoMembersClickListener;
import java.util.ArrayList;

public abstract interface MultiMembersUI
{
  public static final int d = 18;
  
  public abstract void a();
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt, boolean paramBoolean);
  
  public abstract void a(long paramLong, boolean paramBoolean);
  
  public abstract void a(ArrayList paramArrayList);
  
  public abstract void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiMembersUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */