package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.XListView;

public abstract interface MediaPlayerManager$Callback
{
  public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
  
  public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
  
  public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer);
  
  public abstract boolean b(ChatMessage paramChatMessage);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\MediaPlayerManager$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */