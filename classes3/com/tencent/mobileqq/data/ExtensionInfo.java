package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;

public class ExtensionInfo
  extends Entity
{
  public static final int AUDIO_PANEL_TYPE__LS = 3;
  public static final int AUDIO_PANEL_TYPE__NONE = -1;
  public static final int AUDIO_PANEL_TYPE__PRESS_RECORDER = 1;
  public static final int AUDIO_PANEL_TYPE__RECORDER = 2;
  public static final int AUDIO_PANEL_TYPE__VOICE_CHANGER = 0;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final int CHAT_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_SHOW_NONE_PANEL = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final int INTERACTION_TYPE_NORMAL = 0;
  public static final int INTERACTION_TYPE_SMALL = 1;
  public static final int INTERACTION_TYPE_SUPER = 2;
  public static final int INTIMACY_FRIEND_LOW = 1;
  public static final int INTIMACY_FRIEND_NONE = 0;
  public static final int INTIMACY_FRIEND_SUPER = 2;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public static final int TYPE_FROM_CHAT = 1;
  public static final int TYPE_FROM_CONTACT = 0;
  public String apolloDataBuffer;
  public String apolloHistoryDress;
  public long apolloLocalTS;
  public long apolloServerTS;
  public int apolloStatus;
  public long apolloUpdateTime;
  public int apolloVipFlag;
  public int apolloVipLevel;
  @defaultValue(a=-1)
  public int audioPanelType;
  public int bestIntimacyDays;
  public int bestIntimacyType;
  public int chatDays;
  public int chatHotLevel;
  public int chatInputType;
  public long colorRingId;
  public long commingRingId;
  public String feedContent;
  public boolean feedHasPhoto;
  public long feedTime;
  public boolean isAdded2C2C;
  @notColumn
  public boolean isDataChanged;
  public long pendantId;
  public int praiseDays;
  public int praiseHotLevel;
  public int pttChangeVoiceType;
  public byte[] richBuffer;
  @notColumn
  public RichStatus richStatus;
  public long richTime;
  public int showC2CPanel;
  public long timestamp;
  public long uVipFont;
  @unique
  public String uin;
  public int uinType;
  public int vipFontType;
  
  public ExtensionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.chatInputType = 0;
    this.showC2CPanel = 1;
    this.pttChangeVoiceType = 0;
    this.chatHotLevel = 0;
    this.praiseHotLevel = 0;
    this.bestIntimacyType = 0;
    this.audioPanelType = -1;
  }
  
  public RichStatus getRichStatus()
  {
    return getRichStatus(false);
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.getEmptyStatus();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.parseStatus(this.richBuffer);
      this.richStatus.time = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = new RichStatus(null);
    }
  }
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
    this.richStatus = null;
    this.isAdded2C2C = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ExtensionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */