package com.tencent.bitapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.react.uimanager.OnFactSizeChangedListener;
import com.tencent.av.utils.UITools;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitAppMonitorFrameLayout
  implements OnFactSizeChangedListener
{
  private MessageForBitApp bitAppMr;
  private BitAppBaseViewCache cache;
  private Context context;
  private String msgId;
  private BitAppBaseView view;
  
  public BitAppMonitorFrameLayout(MessageForBitApp paramMessageForBitApp, Context paramContext, String paramString, BitAppBaseView paramBitAppBaseView, BitAppBaseViewCache paramBitAppBaseViewCache)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msgId = "";
    this.bitAppMr = paramMessageForBitApp;
    this.context = paramContext;
    this.msgId = paramString;
    this.view = paramBitAppBaseView;
    this.cache = paramBitAppBaseViewCache;
  }
  
  public void onFactSizeChanged(int paramInt)
  {
    if ((this.bitAppMr == null) || (this.context == null) || (TextUtils.isEmpty(this.msgId)) || (this.view == null) || (this.cache == null)) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = this.bitAppMr.bitAppMsg.getHeight();
        j = (int)UITools.b(this.context, paramInt);
      } while (j < 240);
      if (j != i) {
        this.cache.a(this.bitAppMr.frienduin, this.bitAppMr.istroop + "", this.msgId, j);
      }
    } while ((this.view.getLayoutParams() == null) || (((ViewGroup)this.view.getParent()).getLayoutParams() == null) || (this.view.getLayoutParams().height == paramInt));
    this.view.getLayoutParams().height = paramInt;
    ((ViewGroup)this.view.getParent()).getLayoutParams().height = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMonitorFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */