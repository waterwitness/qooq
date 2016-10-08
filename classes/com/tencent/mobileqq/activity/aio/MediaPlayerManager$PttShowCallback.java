package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.HorizontalListView;

public abstract interface MediaPlayerManager$PttShowCallback
{
  public abstract void a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean);
  
  public abstract boolean a(ChatMessage paramChatMessage);
  
  public abstract boolean a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage);
  
  public abstract boolean a(HorizontalListView paramHorizontalListView, int paramInt, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\MediaPlayerManager$PttShowCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */